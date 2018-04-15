package Lesson9;

import Lesson9.domain.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Matchers;
//import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class CountryRepositoryImpTest {

    //Dummy - объект-заглушка, имплементит интерфейс, "пустой", пишется самостоятельно.
    //Stub
    //Mock -

    private CountryRepository repository;

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private Country updatedCountry;
    private int id;

    @Before
    public void setup() {
        factory = mock(SessionFactory.class);
        session = mock(Session.class);
        transaction = mock(Transaction.class);
        updatedCountry = mock(Country.class);

        System.out.println(factory.openSession());

        repository = new CountryRepositoryImpl(factory);
        updatedCountry = new Country(3, "France", "Paris", 10_321_555);

        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(session.get(Country.class, 3)).thenReturn(updatedCountry);
    }

    @Test
    public void testCreate_validData_returnSavedObject(){
        String name = "Russia";
        String capital = "Moscow";
        double population = 147000000d;

        Country country = repository.create(name, capital, population);
        assertEquals(name, country.getName());
        assertEquals(capital, country.getCapital());
        assertEquals(population, country.getPopulation(), 0.2d);

        verify(session, times(1)).persist(Matchers.any(Country.class));
        verify(transaction).commit();
        verify(session).close();
    }

    @Test
    public void testUpdate_validData_returnUpdatedObject(){
        int id = 3;
        String name = "Germany";
        String capital = "Berlin";
        double population = 11700000d;

        Country country = repository.update(id, name, capital, population);

        assertEquals(name, country.getName());
        assertEquals(capital, country.getCapital());
        assertEquals(population, country.getPopulation(), 0.2d);

        verify(transaction).commit();
        verify(session).close();
    }

    @Test
    public void testDelete_validData_expectingNull(){
        int id = 3;
        repository.delete(id);

        verify(session, times(1)).delete(Matchers.any(Country.class)); //Так? Аналогично методу create?
        verify(transaction).commit();
        verify(session).close();

    }
}
