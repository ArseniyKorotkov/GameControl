package by.arsy.p1util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream resourceAsStream = ConnectorManager.class.getClassLoader().getResourceAsStream("connection_params.properties")) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                PROPERTIES.getProperty("db_url"),
                PROPERTIES.getProperty("db_username"),
                PROPERTIES.getProperty("db_password"));
    }

}
