import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class FriendStorage {
    private ArrayList <Friend> friends;

    public FriendStorage(){
        File file = new File("Contacts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0){
            //System.out.println("File is empty");
            this.friends = new ArrayList<>();
        }else {
            //System.out.println("File is NOT empty");
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(file));
                this.friends = ((ArrayList<Friend>) fileReader.readObject());
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void addFriend(String name, String lastName, String phone, Date birthDate){
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

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "FriendStorage{" +
                "friends=" + friends +
                '}';
    }
}
