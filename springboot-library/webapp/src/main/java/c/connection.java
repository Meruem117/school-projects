package c;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meruem
 */
public class connection {
    private static final String username = "root";
    private static final String password = "abc123";
    private static final String url = "jdbc:mysql://localhost:3306/bk?useUnicode=true&characterEncoding=utf8";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException {
        return DriverManager.getConnection(url, username, password);
    }
}