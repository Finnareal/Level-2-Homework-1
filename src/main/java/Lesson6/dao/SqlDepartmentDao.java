package Lesson6.dao;

import Lesson6.domain.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class SqlDepartmentDao implements DepartmentDao {

    @Override
    public Department create(int id, String name, String city, Lesson6.Resourses.Connection connection) throws SQLException {
        try (Connection sqlConnection = connection.getSqlConnection())
                     //DriverManager.getConnection("jdbc:mysql://localhost:3306/employeers?serverTimezone=UTC", "root", "root"))
        {
            //Insert into department value (id, name, city)
            String sql = "insert into department value (" + id + ", " + "\"" + name + "\"" + ", " + "\"" + city + "\"" + ")";
            Statement statement = sqlConnection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Rows affected = " + result);
        }

        Department department = new Department(id, name, city);
        return department;
    }

    @Override
    public Department update(int id, String name, String city, Lesson6.Resourses.Connection connection) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id, Lesson6.Resourses.Connection connection) {

    }

    @Override
    public Collection<Department> findAll(Lesson6.Resourses.Connection connection) {
        return null;
    }

    @Override
    public Department findById(int id, Lesson6.Resourses.Connection connection) throws SQLException {
        try (Connection sqlConnection = connection.getSqlConnection())
        {
            //Find from department where "id" = id
            String sql = "select * from department where id = " + id;
            System.out.println(sql);

            Statement statement = sqlConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            Department department = new Department(0, "", "");
            while (resultSet.next()){
                department.setDepartmentId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                department.setCity(resultSet.getString("city"));
            }
            System.out.println(department.toString());
            return department;
        }
    }
}
