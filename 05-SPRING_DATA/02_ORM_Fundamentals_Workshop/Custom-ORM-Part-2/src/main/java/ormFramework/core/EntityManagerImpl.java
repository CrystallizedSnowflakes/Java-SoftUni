package ormFramework.core;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManagerImpl implements EntityManager {

    private final Connection connection;

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T findById(int id, Class<T> clazz) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String tableName = clazz.getAnnotation(Entity.class).tableName(); // clazz: class bg.codexio.customOrmDemo.entity.User tableName: "users"
        String idColumnName = Arrays.stream(clazz.getDeclaredFields()) // idColumnName: "id"
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow()
                .getName();

        PreparedStatement stmt
                = this.connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?");

        stmt.setInt(1, id); // com.mysql.cj.jdbc.ClientPreparedStatement: SELECT * FROM users WHERE id = 1

        T entity = (T) clazz.getConstructors()[0].newInstance(); // entity: User@3005


        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }

        //ToDo: Add else if for LocalDate case
        for (Field field : clazz.getDeclaredFields()) { // clazz: class bg.codexio.customOrmDemo.entity.User
                                                       // field: private int bg.codexio.customOrmDemo.entity.User.id
                                                       // field: "private int bg.codexio.customOrmDemo.entity.User.age
            if (field.isAnnotationPresent(Column.class)) {
                Column columnInfo = field.getAnnotation(Column.class); // columnInfo: "@ormFramework.annotation.Column(columnDefinition="VARCHAR(100)", name="username")"
                                                                       // columnInfo: "@ormFramework.annotation.Column(columnDefinition="INT", name="age")"
                String setterName = "set" + ((field.getName().charAt(0) + "").toUpperCase()) + field.getName().substring(1); // setterName: "setUsername" | setterName: "setAge"
                if (field.getType().equals(String.class)) {
                    String s = rs.getString(columnInfo.name()); // s: "Pesho"   rs: "com.mysql.cj.jdbc.result.ResultSetImpl@291b4bf5"
                    // columnInfo: "@ormFramework.annotation.Column(columnDefinition="VARCHAR(100)", name="username")"
                    clazz.getMethod(setterName, String.class).invoke(entity, s);
                } else if (field.getType().equals(LocalDate.class)) {
                    LocalDate s = LocalDate.parse(rs.getString(columnInfo.name()));
                    clazz.getMethod(setterName, LocalDate.class).invoke(entity, s);
                } else {
                    int s = rs.getInt(columnInfo.name()); // s: 22  rs: "com.mysql.cj.jdbc.result.ResultSetImpl@291b4bf5"
                    // columnInfo: "@ormFramework.annotation.Column(columnDefinition="INT", name="age")"
                    clazz.getMethod(setterName, field.getType()).invoke(entity, s);
                    // setAge(int age) -> this.age = 22;
                }
            } else if (field.isAnnotationPresent(Id.class)) {
                String setterName = "set" + ((field.getName().charAt(0) + "").toUpperCase()) + field.getName().substring(1); // field: "private int bg.codexio.customOrmDemo.entity.User.id"  setterName: "setId"
                clazz.getMethod(setterName, int.class).invoke(entity, id); // clazz: "class bg.codexio.customOrmDemo.entity.User" setterName: "SetId" entity: "User@3005" id: 1
                // goes to class User.java -> method
                // public void setId(int id) {
                //    this.id = 1;
                // }
            }
        }

        return entity;
    }

    @Override
    public <T> boolean persist(T entity) throws IllegalAccessException, SQLException {
        Field idField = getIdFieldFromEntity(entity);
        idField.setAccessible(true); // needed to get the value of the PRIVATE field
        int id = (int) idField.get(entity);

        if (id == 0) {
            return doInsert(entity);
        }

        return doUpdate(id, entity);
    }

    @Override
    public <T> boolean delete(T entity) throws IllegalAccessException, SQLException {
        Field fieldId = getIdFieldFromEntity(entity);
        fieldId.setAccessible(true);
        int id = (int) fieldId.get(entity);

        String tableName = getTableNameByEntity(entity);

        String deleteQuery = String.format("DELETE FROM %s WHERE id = ?",
                tableName);

        PreparedStatement preparedStatement = connection
                .prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id);

        return preparedStatement.execute();
    }

    @Override
    public <T> boolean alterTable(T entity) throws SQLException {
        String tableName = getTableNameByEntity(entity);
        String query = String.format("ALTER TABLE %s ADD COLUMN %s;",
                tableName, getNewFields(entity));

        connection.prepareStatement(query).executeUpdate();
        return true;
    }

    private <T> String getNewFields(T entity) throws SQLException {
        StringBuilder result = new StringBuilder();
        Set<String> columnsInTable = getAllColumnsInTableBy(entity);
        Class<?> clazz = entity.getClass();
        Arrays.stream(clazz
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    String fieldName = field.getName();
                    if (!columnsInTable.contains(fieldName)){
                        result.append(getFieldNamesBy(clazz));
                    }
                });
        return result.toString();
    }

    private <T> Set<String> getAllColumnsInTableBy(T entity) throws SQLException {
        String tableName = getTableNameByEntity(entity);
        Set<String> allColumns = new HashSet<>();

        String query = "SELECT COLUMN_NAME FROM information_schema.COLUMNS " +
                "WHERE TABLE_SCHEMA = 'test_orm' AND TABLE_NAME = ? " +
                "AND COLUMN_NAME != 'id'";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, tableName);
        ResultSet resultSet = preparedStatement.executeQuery(query);

        while (resultSet.next()) {
            allColumns.add(resultSet.getString(1));
        }

        return allColumns;
    }

    private <T> boolean doUpdate(int id, T entity) throws SQLException {
        String tableName = getTableNameByEntity(entity);

        String fieldsNamesAndValues = getFieldAndValuesAsMap(entity).entrySet()
                .stream()
                .map(kvp -> String.format(" %s = %s ", kvp.getKey(), kvp.getValue()))
                .collect(Collectors.joining(", "));

        String updateQuery = String.format("UPDATE %s SET %s WHERE id = ?;",
                tableName, fieldsNamesAndValues);

        PreparedStatement preparedStatement = connection
                .prepareStatement(updateQuery);
        preparedStatement.setInt(1, id);

        return preparedStatement.execute();
    }

    private <T> Map<String, String> getFieldAndValuesAsMap(T entity) {
        Map<String, String> resultMap = new LinkedHashMap<>();

        Arrays.stream(entity
                .getClass()
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    String fieldName = field.getAnnotation(Column.class).name();
                    String fieldValue = null;
                    try {
                        fieldValue = getValueToString(field, entity);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    resultMap.put(fieldName, fieldValue);
                });

        return resultMap;
    }

    private <T> boolean doInsert(T entity) throws SQLException {
        String tableName = getTableNameByEntity(entity);

        String fieldsNames = getFieldNamesBy(entity.getClass());

        String fieldValues = getFieldsValuesAsStr(entity);

        String query = String.format("INSERT INTO %s (%s) VALUES (%s) ",
                tableName, fieldsNames, fieldValues);

        PreparedStatement preparedStatement = connection
                .prepareStatement(query);

        return preparedStatement.execute();
    }

    private <T> String getFieldsValuesAsStr(T entity) {
        return Arrays.stream(entity
                .getClass()
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> {
                    try {
                        return getValueToString(field, entity);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.joining(", "));
    }

    private String getFieldNamesBy(Class<?> clazz) {

        return Arrays.stream(clazz
                .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> field.getAnnotation(Column.class).name())
                .collect(Collectors.joining(", "));
    }

    private <T> String getTableNameByEntity(T entity) {
        return entity
                .getClass()
                .getAnnotation(Entity.class)
                .tableName();
    }

    private <T> Field getIdFieldFromEntity(T entity) {
        return Arrays.stream(entity
                .getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity doesn't have id"));
    }

    private <T> String getValueToString(Field field, T entity) throws IllegalAccessException {
        field.setAccessible(true);
        String type = field.getAnnotation(Column.class).columnDefinition();

        if (type.equals("DATE") || type.startsWith("VARCHAR")) {
            try {
                return String.format(" '%s' ", field.get(entity));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return String.format(" %s ", field.get(entity));
    }
}
