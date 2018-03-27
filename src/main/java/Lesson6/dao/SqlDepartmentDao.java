package Lesson6.dao;

import Lesson6.domain.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class SqlDepartmentDao implements DepartmentDao {

    @Override
    public Department create(int id, String name, String city) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeers?serverTimezone=UTC", "root", "root"))
        {
            //Insert into department value (id, name, city)
            String sql = "insert into department value (" + id + ", " + name + ", " + city + ")";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Rows affected = " + result);
        }
        Department department = new Department(id, name, city);
        return department;
    }

    @Override
    public Department update(int id, String name, String city) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Collection<Department> findAll() {
        return null;
    }

    @Override
    public Department findById(int id) {
        return null;
    }
}
