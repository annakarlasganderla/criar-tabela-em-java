package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/produtos", "root", "Sganderla0105");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
