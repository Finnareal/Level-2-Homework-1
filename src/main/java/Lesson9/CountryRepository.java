package Lesson9;

import Lesson9.domain.Country;

import java.util.List;

public interface CountryRepository {

    Country create(String name, String capital, double population);

    Country update(int id, String name, String capital, double population);

    void delete(int id);

    Country getById(int id);

    List<Country> getOverMillionPopulation();
}
