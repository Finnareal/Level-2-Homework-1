package Lesson11.Domain;

import Lesson11.City;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Указывает, что класс соответствует таблице Department в БД
@Entity
//Присваивает таблице имя
@Table(name = "department")

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "city", nullable = false)
    private City city;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})  //(targetEntity = Employee.class)
    private Set<Employee> employees = new HashSet<>();

    public Department(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
