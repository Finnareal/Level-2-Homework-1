package Lesson7;

import javax.persistence.*;

//Указывает, что класс соответствует таблице Department в БД
@Entity
//Присваивает таблице имя
@Table(name = "DEPARTMENT")

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name", unique = true, nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToOne(mappedBy = "department") //Название поля, по которому связываем таблицы
    private DepartmentInfo info;

    public Department(){}

    public Department(String name, String city){
        this.name = name;
        this.city = city;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DepartmentInfo getInfo() {
        return info;
    }

    public void setInfo(DepartmentInfo info) {
        this.info = info;
    }
}
