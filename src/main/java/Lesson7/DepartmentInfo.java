package Lesson7;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "DEPARTMENT_INFO")
public class DepartmentInfo implements Serializable {

    @Column(nullable = false)
    private int employeeCount;

    @Column(nullable = false)
    private String manager;

    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Department department;

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
