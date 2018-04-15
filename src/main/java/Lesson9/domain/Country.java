package Lesson9.domain;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_id_gen")
    @SequenceGenerator(name = "country_id_gen", allocationSize = 20, sequenceName = "alloc_country_id", initialValue = 10000)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String capital;

    private double population;

    public Country(){}

    public Country(int id, String name, String capital, double population){
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                '}';
    }
}
