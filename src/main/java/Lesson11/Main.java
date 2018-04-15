package Lesson11;

import java.util.*;

//Лямбда-выражения
public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

        //Переопределен метод compare (использован анонимный внутренний класс
//        Collections.sort(integers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -Integer.compare(o1, o2);
//            }
//        });

        Collections.sort(integers, (o1, o2) -> {
            return -Integer.compare(o1, o2);
        });

        //Или еще проще (если строка одна и она сразу возвращает результат):
        Collections.sort(integers, (o1, o2) -> -Integer.compare(o1, o2));

        System.out.println(integers.toString());

        //Еще пример
        integers.forEach(integer -> {
            int i = 10 + integer;
            System.out.println(i);
        });

        //Можно записать как:
        integers.forEach(System.out::println);
    }
}
