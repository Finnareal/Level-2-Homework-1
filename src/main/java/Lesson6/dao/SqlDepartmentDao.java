package Lesson6.dao;

import Lesson6.Resourses.JdbcConnection;
import Lesson6.domain.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class SqlDepartmentDao implements DepartmentDao {

    private Connection sqlConnection;

    public SqlDepartmentDao() throws SQLException {
        this.sqlConnection = new JdbcConnection().getSqlConnection();
    }

    @Override
    public Department create(int id, String name, String city) throws SQLException {

        Department insertedDepartment;
        try (Statement statement = sqlConnection.createStatement())
        {
            //Insert into department value (id, name, city)
            String sql = "insert into department value (" + id + ", " + "\"" + name + "\"" + ", " + "\"" + city + "\"" + ")";

            insertedDepartment = findById(id);

            //Проверяем, что такой записи еще нет
            if (insertedDepartment.getDepartmentId() == id){
                throw new SQLException("Record with id = " + id + " already exists!");
            }

            int result = statement.executeUpdate(sql);
            System.out.println("Rows affected = " + result);

            //Проверяем, что запись добавлена в таблицу
            insertedDepartment = findById(id);
            System.out.println("Row insert result = " + insertedDepartment);
        }
        return insertedDepartment;
    }

    @Override
    public Department update(int id, String name, String city) throws SQLException {

        Department updatedDepartment;
        try (Statement statement = sqlConnection.createStatement())
        {
            updatedDepartment = findById(id);
            if (updatedDepartment.getDepartmentId() == 0){
                throw new SQLException("No records with id = " + id + " found!");
            }else {
                System.out.println("Row for update = " + updatedDepartment);
            }

            String sql = "update department set name = " + "\"" + name + "\"" + ", " + "city = " + "\"" + city + "\"" + " where id = " + id;
            int result = statement.executeUpdate(sql);
            System.out.println("Rows affected = " + result);

            //Проверяем, что значения поменялись
            updatedDepartment = findById(id);
            System.out.println("Row update result = " + updatedDepartment);
        }
        return updatedDepartment;
    }

    @Override
    public void delete(int id) throws SQLException {

        try (Statement statement = sqlConnection.createStatement())
        {
            String sql = "delete from department where id = " + id;
            int result = statement.executeUpdate(sql);
            System.out.println("Rows affected = " + result);
            if (result == 0){
                throw new SQLException("No records with id = " + id + " found!");
            }
        }
    }

    @Override
    public Collection<Department> findAll() {
        ArrayList<Department> result = new ArrayList<>();

        try (Statement statement = sqlConnection.createStatement())
        {
            //Find all records from department
            String sql = "select * from department";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Department department = new Department(0, "", "");
                department.setDepartmentId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                department.setCity(resultSet.getString("city"));
                result.add(department);
                System.out.println(department.toString());
            }
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
        System.out.println(result.toString());
        return result;
    }

    @Override
    public Department findById(int id) throws SQLException {
        Department department = new Department(0, "", "");

        try (Statement statement = sqlConnection.createStatement())
        {
            //Find from department where "id" = id
            String sql = "select * from department where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            if (!resultSet.next()){
                System.out.println("No records found!");
            } else {
                department.setDepartmentId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                department.setCity(resultSet.getString("city"));
            }
        }
        System.out.println(department.toString());
        return department;
    }
}
