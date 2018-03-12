import Lesson_2.RandomInt;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntProsessor {
    public static void prosessor (Object object) throws IllegalAccessException {

        final Class objectClass = object.getClass();
        final Field[] fields = objectClass.getDeclaredFields();

        for (Field field : fields) {
            final RandomInt annotation = field.getAnnotation(RandomInt.class);
            if (annotation != null){
                int random = new Random().nextInt(annotation.max() - annotation.min()) + annotation.min();
                field.setAccessible(true);
                field.set(object, random);
            }
        }
    }

}
