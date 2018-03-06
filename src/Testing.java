import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) throws ParseException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        ArrayList <Friend> friendsFromFile = new ArrayList<>();

        File file = new File("Contacts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0){
            friendsFromFile = new ArrayList<>();
        }else {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(file));
                friendsFromFile = ((ArrayList<Friend>) fileReader.readObject());
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        Class <FriendStorage> friendStorageClass = FriendStorage.class;
        // получаем доступ к конструктору
        Constructor constructor = friendStorageClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        FriendStorage friendStorage = (FriendStorage) constructor.newInstance();

        // получаем доступ к методу getFriends
        Method methodGetFriends = friendStorageClass.getDeclaredMethod("getFriends");
        methodGetFriends.setAccessible(true);

        System.out.println(friendsFromFile.toString());
        System.out.println(methodGetFriends.invoke(friendStorage).toString());

        // получаем доступ к полю bestFriend
        Field fieldFriends = friendStorageClass.getDeclaredField("bestFriend");
        fieldFriends.setAccessible(true);

        System.out.println(friendStorage.isBestFriend());
        fieldFriends.set(friendStorage, true);
        System.out.println(friendStorage.isBestFriend());
    }
}
