package Lesson6.dao;

import Lesson6.domain.Department;

import java.sql.SQLException;
import java.util.Collection;

public interface DepartmentDao {

    //Аналог Insert
    Department create(int id, String name, String city, Lesson6.Resourses.Connection connection) throws SQLException;

    //Update
    Department update(int id, String name, String city, Lesson6.Resourses.Connection connection) throws SQLException;

    //Delete
    void delete(int id, Lesson6.Resourses.Connection connection);

    //select * from department
    Collection<Department> findAll(Lesson6.Resourses.Connection connection);

    //Поиск по ID
    Department findById(int id, Lesson6.Resourses.Connection connection) throws SQLException;
}
