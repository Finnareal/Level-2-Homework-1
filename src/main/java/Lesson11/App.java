package Lesson11;


import Lesson11.Domain.Department;
import Lesson11.Domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class App {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:mem:employees;INIT=create schema if not exists employees");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        SessionFactory factory = new Configuration().addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class).buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Department department = new Department();
        department.setName("Development");
        department.setCity(City.SAINT_PETERSBURG);

        Employee employee = new Employee();
        employee.setLogin("gengre");
        employee.setName("Gendalf");
        employee.setLastName("Grey");
        employee.setEmail("gendalf@mail.ru");
        employee.setDepartment(department);

        department.getEmployees().add(employee);

        session.persist(department);
        //employee.setName("Saruman");

        //session.persist(employee);

        transaction.commit();
        session.close();
        factory.close();
    }

}
