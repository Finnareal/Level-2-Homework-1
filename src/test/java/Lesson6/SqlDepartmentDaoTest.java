package Lesson6;

import Lesson6.dao.DepartmentDao;
import Lesson6.dao.SqlDepartmentDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class SqlDepartmentDaoTest {
    private static DepartmentDao departmentDao;

    @BeforeAll
    public static void setup() throws SQLException {
        departmentDao = new SqlDepartmentDao();
    }

    @Test
    public void sqlDepartmentDaoCreateTest() throws SQLException {
        departmentDao.create(5, "HR", "Moscow");
    }

    @Test
    public void sqlDepartmentDaoUpdateTest() throws SQLException {
        departmentDao.update(9, "HR", "Sochi");
    }

    @Test
    public void sqlDepartmentDaoDeleteTest() throws SQLException {
        departmentDao.delete(8);
    }

    @Test
    public void sqlDepartmentDaoFindAllTest() throws SQLException {
        departmentDao.findAll();
    }

    @Test
    public void sqlDepartmentDaoFindByIdTest(){
        departmentDao.findById(4);
    }
}
