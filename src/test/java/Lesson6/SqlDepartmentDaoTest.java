package Lesson6;

import Lesson6.Resourses.JdbcConnection;
import Lesson6.dao.DepartmentDao;
import Lesson6.dao.SqlDepartmentDao;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class SqlDepartmentDaoTest {

    @Test
    public void sqlDepartmentDaoCreateTest() throws SQLException {
        DepartmentDao departmentDao = new SqlDepartmentDao();
        Lesson6.Resourses.Connection newConnection = new JdbcConnection();
        departmentDao.create(5, "HR", "Moscow", newConnection);
    }

    @Test
    public void sqlDepartmentDaoFindByIdTest() throws SQLException {
        DepartmentDao departmentDao = new SqlDepartmentDao();
        Lesson6.Resourses.Connection newConnection = new JdbcConnection();
        departmentDao.findById(3,newConnection);
    }
}
