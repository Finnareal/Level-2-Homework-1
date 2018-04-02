package Lesson6.Resourses;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    Connection getSqlConnection() throws SQLException;
}
