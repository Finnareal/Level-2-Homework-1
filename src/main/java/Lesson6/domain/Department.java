package Lesson6.domain;

public class Department {
    private int departmentId;
    private String name;
    private String city;

    public Department (int departmentId, String name, String city){
        this.departmentId = departmentId;
        this.name = name;
        this.city = city;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
