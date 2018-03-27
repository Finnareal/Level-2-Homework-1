package Lesson6.dao;

import Lesson6.domain.Department;

import java.sql.SQLException;
import java.util.Collection;

public interface DepartmentDao {

    //Аналог Insert
    Department create(int id, String name, String city) throws SQLException;

    //Update
    Department update(int id, String name, String city );

    //Delete
    void delete(int id);

    //select * from department
    Collection<Department> findAll();

    //Поиск по ID
    Department findById(int id);
}
