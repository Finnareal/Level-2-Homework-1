package Lesson11.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GROUPS")
public class Groups implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int groupId;

    @Column(name = "name", unique = true, nullable = false)
    private String groupName;

    public Groups(){}


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
