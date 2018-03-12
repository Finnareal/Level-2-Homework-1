
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Testing {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class <ObjectList> objectListClass = ObjectList.class;
        ObjectList objectList = objectListClass.newInstance();
        Method method = objectListClass.getDeclaredMethod("getObjects");
        Object[] objects = (Object[]) method.invoke(objectList);

        System.out.println(objects[0].toString() + "\n" + objects[1].toString() + "\n" + objects[2].toString());

    }
}
