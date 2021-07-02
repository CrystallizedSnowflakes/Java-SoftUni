import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static Connection CONNECTION;

    public static void main(String[] args) throws SQLException, IOException {

        CONNECTION = getConnection();

        System.out.println("Be sure you reloaded minions_db before each exercise.\n\rEnter exercise number from 2 to 9:");
        int exNum = Integer.parseInt(READER.readLine());
        switch (exNum){
            case 2: exTwoGetVillainsNames();
                break;
            case 3: exThreeGetMinionsNames();
                break;
            case 4: exFourAddMinion();
                break;
            case 5: exFiveChangeTownNamesCasing();
                break;
            case 6: exSixRemoveVillain();
                break;
            case 7: exSevenPrintAllMinionNames();
                break;
            case 8: exEightIncreaseMinionsAge();
                break;
            case 9: exNineIncreaseAgeStoredProcedure();
                break;
        }
    }

    private static void exNineIncreaseAgeStoredProcedure() throws IOException, SQLException {
        System.out.println("Enter minion id:");
        int minion_id = Integer.parseInt(READER.readLine());
/*
Please create the procedure in MySQL
DELIMITER //
CREATE PROCEDURE usp_get_older(minion_id INT)
BEGIN
    UPDATE minions
    SET age = age + 1
    WHERE id = minion_id;
end //
DELIMITER ;
*/
        CallableStatement callableStatement = CONNECTION.prepareCall("CALL usp_get_older(?);");
        callableStatement.setInt(1, minion_id);
        int affectedRows = callableStatement.executeUpdate();
        PreparedStatement ps = CONNECTION.prepareStatement("SELECT name, age FROM minions;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.printf("%s %d %n", rs.getString("name"), rs.getInt("age"));
        }
    }

    private static void exEightIncreaseMinionsAge() throws SQLException, IOException {
        System.out.println("Please enter ids:");
        List<Integer> ids = Arrays.stream(READER.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String query = "UPDATE minions SET name = CONCAT(LOWER(LEFT(name, 1)), SUBSTRING(name, 2)), age = age + 1 WHERE id = ?;";
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        for (int id : ids) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

        PreparedStatement psMinions = CONNECTION.prepareStatement("SELECT name, age FROM minions;");
        ResultSet rs = psMinions.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name") + " " + rs.getInt("age"));
        }
    }

    private static void exSevenPrintAllMinionNames() throws SQLException {
        PreparedStatement ps = CONNECTION.prepareStatement("SELECT name FROM minions;");
        ResultSet rs = ps.executeQuery();
        List<String> minions = new ArrayList<>();
        while (rs.next()){
            minions.add(rs.getString(1)); // or "name"
        }
        int start = 0;
        int end = minions.size() - 1;
        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i % 2 == 0 ? minions.get(start++) : minions.get(end--));
        }
    }

    private static void exSixRemoveVillain() throws IOException, SQLException {
        System.out.println("Enter villain id: ");
        int villainId = Integer.parseInt(READER.readLine());
        String villainName = findEntityNameByID("villains", villainId);
        if(villainName == null){
            System.out.println("No such villain was found");
            return;
        }
        int affectedEntities = deleteMinionsByVillainId(villainId);
        deleteEntityById(villainId, "villains");
        System.out.printf("%s was deleted %n%d minions released%n", villainName, affectedEntities);
    }

    private static void deleteEntityById(int villainId, String tableName) throws SQLException {
        String query = String.format("DELETE FROM %s WHERE id = ?;", tableName);
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setInt(1, villainId);
        ps.executeUpdate();
    }

    private static int deleteMinionsByVillainId(int villainId) throws SQLException {
        PreparedStatement ps = CONNECTION.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        ps.setInt(1, villainId);
        return ps.executeUpdate();
    }

    private static void exFiveChangeTownNamesCasing() throws IOException, SQLException {
        System.out.println("Enter country name:");
        String countryName = READER.readLine();

        PreparedStatement ps = CONNECTION.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");
        ps.setString(1, countryName);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0){
            System.out.println("No town names were affected.");
            return;
        }
        System.out.printf("%d town names were affected.%n", affectedRows);

        PreparedStatement psTowns = CONNECTION.prepareStatement("SELECT name FROM towns WHERE country = ?");
        psTowns.setString(1, countryName);
        ResultSet rs = psTowns.executeQuery();
        List<String> towns = new ArrayList<>();
        while (rs.next()){
            towns.add(rs.getString("name"));
        }
        System.out.println("[" + String.join(", ", towns) + "]");
    }

    private static void exFourAddMinion() throws IOException, SQLException {
        System.out.println("Copy/Paste the whole 2-rows input from the table at once");

        String[] minionTokens = Arrays.stream(READER.readLine().split("\\s+")).skip(1).toArray(String[]::new);
        String minionName = minionTokens[0];
        int minionAge = Integer.parseInt(minionTokens[1]);
        String townName = minionTokens[2];

        int townId = getEntityIdByName(townName, "towns");
        if (townId < 0){
            insertEntityByEntityName(townName, "towns");
            System.out.printf("Town %s was added to the database.%n", townName);
            townId = getEntityIdByName(townName, "towns");
        }

        int minionId = getEntityIdByName(minionName, "minions");
        if (minionId < 0){
            insertMinionByNameAgeTownId(minionName, minionAge, townId);
            minionId = getEntityIdByName(minionName, "minions");
        }

        String[] villainTokens = Arrays.stream(READER.readLine().split("\\s+")).skip(1).toArray(String[]::new);
        String villainName = villainTokens[0];
        int villainId = getEntityIdByName(villainName, "villains");
        String evilnessFactor = "evil";
        if (villainId < 0){
            insertVillainByNameFactor(villainName, evilnessFactor);
            System.out.printf("Villain %s was added to the database.%n", villainName);
            villainId = getEntityIdByName(villainName, "villains");
        }

        addMinionToVillain(minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }


    private static void addMinionToVillain(int minionId, int villainId) throws SQLException {
        String query = "INSERT INTO minions_villains (minion_id, villain_id) values (?, ?);";
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setInt(1, minionId);
        ps.setInt(2, villainId);
        ps.executeUpdate();
    }

    private static void insertVillainByNameFactor(String villainName, String evilnessFactor) throws SQLException {
        String query = "INSERT INTO villains (name, evilness_factor) values (?, ?);";
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setString(1, villainName);
        ps.setString(2, evilnessFactor);
        ps.executeUpdate();
    }

    private static void insertMinionByNameAgeTownId(String minionName, int minionAge, int townId) throws SQLException {
        String query = "INSERT INTO minions (name, age, town_id) values (?, ?, ?);";
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setString(1, minionName);
        ps.setInt(2, minionAge);
        ps.setInt(3, townId);
        ps.executeUpdate();
    }

    private static void insertEntityByEntityName(String entityName, String tableName) throws SQLException {
        String query = String.format("INSERT INTO %s (name) value (?);", tableName);
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setString(1, entityName);
        ps.executeUpdate();
    }

    private static int getEntityIdByName(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?;", tableName);
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setString(1, entityName);
        ResultSet rs = ps.executeQuery();
        return rs.next() ? rs.getInt("id") : -1;
    }

    private static void exThreeGetMinionsNames() throws IOException, SQLException {
        System.out.println("Enter villain id: ");
        int villainId = Integer.parseInt(READER.readLine());
        //String villainName = findVillainNameById(villainId);
        String villainName = findEntityNameByID("villains", villainId);
        if (villainName == null){
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }
        System.out.printf("Villain: %s%n", villainName);
        Set<String> allMinionsByVillainId = getAllMinionsByVillainId(villainId);
        allMinionsByVillainId.forEach(System.out::print);
    }

    private static Set<String> getAllMinionsByVillainId(int villainId) throws SQLException {
        Set<String> resultSet = new LinkedHashSet<>();
        PreparedStatement ps = CONNECTION.prepareStatement(
                "SELECT m.name, m.age " +
                "FROM minions AS m " +
                "JOIN minions_villains mv on m.id = mv.minion_id " +
                "WHERE mv.villain_id = ?;");

        ps.setInt(1, villainId);
        ResultSet rs = ps.executeQuery();
        int counter = 0;
        while (rs.next()){
            resultSet.add(String.format("%d. %s %d %n",
                    ++counter,
                    rs.getString("name"),
                    rs.getInt("age")));
        }
        return resultSet;
    }

    private static String findEntityNameByID(String tableName, int entityId) throws SQLException {
        String query = String.format("SELECT name FROM %S WHERE ID = ?;", tableName);
        PreparedStatement ps = CONNECTION.prepareStatement(query);
        ps.setInt(1, entityId);
        ResultSet rs = ps.executeQuery();
        if(rs.isBeforeFirst()){
            rs.next();
            return rs.getString("name");
        }
        return null;
    }

    private static String findVillainNameById(int villainId) throws SQLException {
        PreparedStatement ps = CONNECTION.prepareStatement("SELECT name FROM villains WHERE id = ?;");
        ps.setInt(1, villainId);
        ResultSet rs = ps.executeQuery();
        if(rs.isBeforeFirst()){
            rs.next();
            return rs.getString("name");
        }
        return null;
    }

    private static void exTwoGetVillainsNames() throws SQLException {
        PreparedStatement ps = CONNECTION.prepareStatement(
                "SELECT v.name, COUNT(DISTINCT minion_id) AS m_count " +
                        "FROM villains AS v " +
                        "JOIN minions_villains mv " +
                        "on v.id = mv.villain_id " +
                        "GROUP BY v.id " +
                        "HAVING m_count > ? " +
                        "ORDER BY m_count DESC;");

        ps.setInt(1, 15);

        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.printf("%s %d %n", rs.getString("name"), rs.getInt("m_count"));
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        System.out.println("You can comment 296-301 and hardcode your 'user'-304 & 'password'-305 rows");
        System.out.println("Enter user or Press <Enter> for 'root': ");
        String user = READER.readLine();
        user = user.length() > 0 ? user : "root";
        System.out.println("Enter your SQL password: ");
        String password = READER.readLine();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        return DriverManager.getConnection(CONNECTION_STRING + DB_NAME, props);
    }
}
