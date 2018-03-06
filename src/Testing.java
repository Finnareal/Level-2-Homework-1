import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Testing {
    public static void main(String[] args) throws ParseException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        FriendStorage friendStorage = new FriendStorage();
        //Class <FriendStorage> friendStorageClass = FriendStorage.class;

//        Constructor constructor = friendStorageClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        FriendStorage friendStorage = (FriendStorage) constructor.newInstance();
        //friendStorage.clearFriends();



//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        friendStorage.addFriend("Ivan", "Popov", "222", simpleDateFormat.parse("03.10.1978"));
//        friendStorage.addFriend("Ivan", "Popov", "222", simpleDateFormat.parse("03.10.1978"));
//        friendStorage.addFriend("Andrey", "Minin", "333", simpleDateFormat.parse("05.05.1955"));
//        friendStorage.addFriend("Elena", "Alimova", "444", simpleDateFormat.parse("15.08.1991"));


        System.out.println(friendStorage.getFriends().toString());


        //Сохраняем список контактов в файл
//        File file = new File("Contacts.txt");
//        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
//            writer.writeObject(friendStorage.getFriends());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
