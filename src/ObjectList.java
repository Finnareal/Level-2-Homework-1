import Lesson_2.Product;
import Lesson_2.Square;
import Lesson_2.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ObjectList {
    Object[] objects;

    public Object[] getObjects() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class <User> userClass = User.class;
        Constructor constructor1 = userClass.getDeclaredConstructor();
        constructor1.setAccessible(true);
        User user = (User) constructor1.newInstance();

        Class <Square> squareClass = Square.class;
        Constructor constructor2 = squareClass.getDeclaredConstructor();
        constructor2.setAccessible(true);
        Square square = (Square) constructor2.newInstance();

        Class <Product> productClass = Product.class;
        Constructor constructor3 = productClass.getDeclaredConstructor();
        constructor3.setAccessible(true);
        Product product = (Product) constructor3.newInstance();

        Object[] objects = new Object[]{user, square, product};

        for (Object o: objects) {
            RandomIntProsessor.prosessor(o);
        }
        return objects;
    }

    @Override
    public String toString() {
        return "ObjectList{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}
