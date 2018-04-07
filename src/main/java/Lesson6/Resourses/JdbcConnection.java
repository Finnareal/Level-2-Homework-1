package Lesson6.Resourses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection implements DatabaseConnection {

    @Override
    public Connection getSqlConnection() throws SQLException {
        JdbcConfiguration configuration = new JdbcConfigurationProperties();
        Connection connection = DriverManager.getConnection(configuration.load().getUrl(), configuration.load().getUserName(), configuration.load().getPassword());
        return connection;
    }
}
