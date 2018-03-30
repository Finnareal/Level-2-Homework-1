package Lesson6.Resourses;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection implements Connection {

    @Override
    public java.sql.Connection getSqlConnection() throws SQLException {
        JdbcConfiguration configuration = new JdbcConfigurationProperties();
        java.sql.Connection connection = DriverManager.getConnection(configuration.load().getUrl(), configuration.load().getUserName(), configuration.load().getPassword());
        return connection;
    }
}
