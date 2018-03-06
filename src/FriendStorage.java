import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class FriendStorage implements Serializable {
    private ArrayList <Friend> friends;
    private boolean bestFriend;

    private FriendStorage(){
        this.friends = new ArrayList<>();
        this.bestFriend = false;
    }

    public void addFriend(String name, String lastName, String phone, Date birthDate) {
        Friend newFriend = new Friend();
        newFriend.setName(name);
        newFriend.setLastName(lastName);
        newFriend.setPhone(phone);
        newFriend.setBirthDate(birthDate);
        getFriends().add(newFriend);
    }

    public void clearFriends(){
        getFriends().clear();
    }

    private ArrayList<Friend> getFriends() {
        return friends;
    }

    public boolean isBestFriend() {
        return bestFriend;
    }

    @Override
    public String toString() {
        return "FriendStorage{" +
                "friends=" + friends +
                '}';
    }
}
