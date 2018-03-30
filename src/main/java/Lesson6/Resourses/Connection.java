package Lesson6.Resourses;

import java.sql.SQLException;

public interface Connection {
    java.sql.Connection getSqlConnection() throws SQLException;
}
