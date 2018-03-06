import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend implements Serializable {
    private String name;
    private String lastName;
    private String phone;
    private Date birthDate;

    public Friend() {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    private String getName() {
        return name;
    }

    private String getLastName() {
        return lastName;
    }

    private String getPhone() {
        return phone;
    }

    private Date getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return name + " " + lastName + " " + phone + " " + simpleDateFormat.format(birthDate);
    }
}
