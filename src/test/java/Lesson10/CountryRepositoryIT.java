package Lesson10;

import Lesson9.domain.Country;
import Lesson9.CountryRepository;
import Lesson9.CountryRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CountryRepositoryIT {

    private static SessionFactory factory;
    private CountryRepository countryRepository = new CountryRepositoryImpl(factory);

    @BeforeClass
    public static void setupFactory(){
        factory = TestHibernateUtils.getFactory();
    }

    @Test
    public void testCreate_validParams_returnNewlyCreatedCountry(){
        String name = "England";
        String capital = "London";
        double population = 12_524_231d;

        Country country = countryRepository.create(name, capital, population);
        assertNotEquals(0, country.getId());
        System.out.println(country.getId());
    }

    @Test
    public void testGetById_entityExists_returnEntity(){
        Country country = countryRepository.create("name", "capital", 533.5d);

        Country result = countryRepository.getById(country.getId());
        assertNotNull(result);
        assertEquals(country.getId(), result.getId());
    }

    @Test
    public void testGetById_entityNotExists_returnNull(){
        Country result = countryRepository.getById(1_000);
        assertNull(result);
    }

    @Test
    public void testGetCountriesWithMillionPopulation_countriesExist_returnList(){
        countryRepository.create("country1", "cap1", 10_324_321);
        countryRepository.create("country2", "cap2", 324_321);
        countryRepository.create("country3", "cap3", 1_324_321);
        countryRepository.create("country4", "cap4", 1_000_000);
        countryRepository.create("country5", "cap5", 32_321);

        List<Country> countries = countryRepository.getOverMillionPopulation();
        assertEquals(2, countries.size());
    }

    @Test
    public void testGetCountriesWithMillionPopulation_countriesNotExist_returnEmpty(){
        countryRepository.create("country6", "cap6", 324_321);
        countryRepository.create("country7", "cap7", 324_321);
        countryRepository.create("country8", "cap8", 324_321);

        List<Country> countries = countryRepository.getOverMillionPopulation();
        assertEquals(0, countries.size());

    }

    @After
    public void clearDatabase() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Country").executeUpdate();

        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void closeFactory(){
        factory.close();
    }
}
