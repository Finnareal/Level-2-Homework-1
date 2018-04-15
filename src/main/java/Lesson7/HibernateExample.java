package Lesson7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {

        //Загружает настройки (файл конфигурации)
        Configuration config = new Configuration();
        config.configure();

        //Класс, управляющий подключениями
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Department department = new Department("Dev", "SPb"); //состояние данного объекта - transient - не связан с БД
        session.save(department);//состояние данного объекта - persistent - связан с БД, можно изменять поля не используя update
        department.setCity("Moscow");

        transaction.commit();
        session.close(); //состояние объекта Department - detached - не связан с БД, не управляется Hibernate'ом.
    }
}
