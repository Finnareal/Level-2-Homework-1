package Lesson7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {

        //Загружает настройки (файл конфигурации)
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //Класс, управляющий подключениями
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.close();
    }
}
