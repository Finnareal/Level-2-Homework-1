package Lesson11.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int infoId;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "sex", nullable = false)
    private boolean sex;

    @Column(name = "internal_phone", nullable = false)
    private int internalPhone;

    public EmployeeInfo(){}


    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getInternalPhone() {
        return internalPhone;
    }

    public void setInternalPhone(int internalPhone) {
        this.internalPhone = internalPhone;
    }
}
