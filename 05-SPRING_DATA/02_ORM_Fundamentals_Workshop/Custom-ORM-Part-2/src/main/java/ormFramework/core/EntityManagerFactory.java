package ormFramework.core;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityManagerFactory {

    public static EntityManager create(
            String dbType,
            String host,
            int port,
            String user,
            String pass,
            String dbName,
            Class<?> mainClass // mainClass: "bg.codexio.customOrmDemo.ApplicationStarter"
    ) throws SQLException, URISyntaxException, ClassNotFoundException {
        Connection connection = createConnection(dbType, host, port, user, pass, dbName);

        List<Class<?>> classes = getEntities(mainClass);

        createTables(connection, classes);

        return new EntityManagerImpl(connection);
    }

    private static void createTables(Connection connection, List<Class<?>> classes) throws SQLException {
        for (Class classInfo : classes) {
            Entity entityInfo = (Entity) classInfo.getAnnotation(Entity.class); //ex: @ormFramework.annotation.Entity(tableName="addresses")
            String sql = "CREATE TABLE IF NOT EXISTS ";

            String tableName = entityInfo.tableName(); //addresses

            sql += tableName + " (\n"; // CREATE TABLE addresses (
            String primaryKeyDef = "";

            for (Field field : classInfo.getDeclaredFields()) { //field: private int bg.codexio.customOrmDemo.entity.Address.id
                if (field.isAnnotationPresent(Id.class)) {
                    sql += "  " + field.getName() + " int auto_increment,\n"; // "CREATE TABLE addresses (\n id int auto_increment,\n"
                    primaryKeyDef = "constraint " + tableName + "_pk primary key (" + field.getName() + ")"; // constraint addresses_pk primary key (id)
                } else if (field.isAnnotationPresent(Column.class)) {
                    Column columnInfo = field.getAnnotation(Column.class); // columnInfo: @ormFramework.annotation.Column(columnDefinition="VARCHAR(255)", name="street")
                    sql += "  " + columnInfo.name() + " " + columnInfo.columnDefinition() + ",\n"; // "CREATE TABLE addresses (\n id int auto_increment,\n street VARCHAR(255),"
                }
            }

            sql += "  " + primaryKeyDef + "\n);";
            // CREATE TABLE addresses (
            //  id auto_increment,
            //  street VARCHAR(255),
            //  street_number VARCHAR(255),
            //  people_count INT(11),
            //  constraint addresses_pk primary key (id)"
            // );

            System.out.println(sql);

            connection.createStatement().execute(sql);
        }
    }

    private static List<Class<?>> getEntities(Class<?> mainClass) throws URISyntaxException, ClassNotFoundException {
        String path = mainClass.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(); // /D:/SPRING_DATA/02_ORM_Fundamentals/Custom-ORM-Part-2/target/classes/
        String packageName = mainClass.getPackageName(); // bg.codexio.customOrmDemo


        File rootDir = new File(path + packageName.replace(".", "/")); // "D:\SPRING_DATA\02_ORM_Fundamentals\Custom-ORM-Part-2\target\classes\bg\codexio\customOrmDemo"
        List<Class<?>> classes = new ArrayList<>();

        scanEntities(
                rootDir,
                packageName,
                classes
        );
        return classes;
    }

    private static Connection createConnection(String dbType, String host, int port, String user, String pass, String dbName) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:" + dbType + "://" + host + ":" + port + "/" + dbName,
                user,
                pass
        );
        return connection;
    }

    private static void scanEntities(File dir, String packageName, List<Class<?>> classes) throws ClassNotFoundException {
        for (File file : dir.listFiles()) { // D:\SPRING_DATA\02_ORM_Fundamentals\Custom-ORM-Part-2\target\classes\bg\codexio\customOrmDemo
            if (file.isDirectory()) {
                scanEntities(file, packageName + "." + file.getName(), classes);
            } else if (file.getName().endsWith(".class")) { // D:\SPRING_DATA\02_ORM_Fundamentals\Custom-ORM-Part-2\target\classes\bg\codexio\customOrmDemo\ApplicationStarter.class
                Class<?> classInfo = Class.forName(packageName + "." + file.getName().replace(".class", "")); // class bg.codexio.customOrmDemo.ApplicationStarter
                if (classInfo.isAnnotationPresent(Entity.class)) {
                    classes.add(classInfo);
                }
            }
        }
    }
}
