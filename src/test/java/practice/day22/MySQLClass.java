package practice.day22;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLClass {
    private static final Properties PROP = getProperties();

    public static void main(String[] args) {
//        PROP.forEach((k,v) -> System.out.println(v.toString()));
//        String query = "SHOW TABLES";
//        execStatement(query,1);
        String query = "SELECT * from Categories";
        execStatement(query,2);
//        String query = "Describe Categories";
//        execStatement(query,2);

    }

    private static Properties getProperties() {

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("src/test/resources/db.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    private static MysqlDataSource getDataSource() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(PROP.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(PROP.getProperty("PORT")));
        dataSource.setUser(PROP.getProperty("USER"));
        dataSource.setPassword(PROP.getProperty("PWD"));
        dataSource.setDatabaseName(PROP.getProperty("DBNAME"));

        return dataSource;
    }

    private static void execStatement(String query, int index) {

        try (Connection connection = getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(index));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
