package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

        public static void main(String[] args) {
            Connection getConnection = getConnection();

        }
        private static Connection conn = null;

        public JDBCConnection() {
        }

        public static Connection getConnection() {
            if (conn == null) {


                try {

                    InputStream input = (JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));
                    Properties p = new Properties();
                    p.load(input);

                    String endpoint = p.getProperty("endpoint");
                    String url = "jdbc:postgresql://" + endpoint + "/postgres";
                    String username = p.getProperty("username");
                    String password =  p.getProperty("password");


                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException | IOException e) {
                   // MyLogger.logger.error(e.getMessage());
                    e.printStackTrace();
                }
            }

            return conn;
        }
    }



