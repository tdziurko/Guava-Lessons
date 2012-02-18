package pl.tomaszdziurko.guava.geo;


import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

public class Country {

    public static final Country POLAND = new Country(1L, "Poland", "Warsaw", 38.186, Continent.EUROPE, 313);
    public static final Country BELGIUM = new Country(2L, "Belgium", "Brussels", 11.007, Continent.EUROPE, 30);
    public static final Country SPAIN = new Country(3L, "Spain", "Madrid", 46.0, Continent.EUROPE, 508);
    public static final Country ENGLAND = new Country(4L, "England", "London", 51.446, Continent.EUROPE, 130);
    public static final Country FINLAND_WITHOUT_CAPITAL_CITY = new Country(5L, "Finland", null, null, Continent.EUROPE, null);
    public static final Country SOUTH_AFRICA = new Country(9L, "South Africa", "Pretoria", 50.586, Continent.AFRICA, 1221);
    public static final Country ICELAND = new Country(8L, "Iceland", "Reykjavik", 0.318, Continent.EUROPE, 103);

    private Long id;
    private String name;
    private String capitalCity;
    private Double population;
    private Continent continent;
    private Integer area;


    public Country(Long id, String name, String capitalCity, Double population, Continent continent, Integer area) {
        this.id = id;
        this.name = name;
        this.capitalCity = capitalCity;
        this.population = population;
        this.continent = continent;
        this.area = area;
    }

    public static List<Country> getSomeCountries() {
        List<Country> countries = Lists.newArrayList();

        countries.add(POLAND);
        countries.add(BELGIUM);
        countries.add(SPAIN);
        countries.add(ENGLAND);
        countries.add(new Country(6L, "Sweden", "Stockholm", 9.354, Continent.EUROPE, 450));
        countries.add(new Country(7L, "Croatia", "Zagreb", 4.290, Continent.EUROPE, 57));
        countries.add(ICELAND);
        countries.add(SOUTH_AFRICA);
        countries.add(new Country(10L, "Egypt", "Cairo", 80.801, Continent.AFRICA, 1002));
        countries.add(new Country(11L, "Tanzania", "Dodoma", 41.048, Continent.AFRICA, 945));
        countries.add(new Country(12L, "Tunisia", "Tunis", 10.486, Continent.AFRICA, 163));
        countries.add(new Country(13L, "Togo", "Lome", 6.019, Continent.AFRICA, 57));
        countries.add(new Country(14L, "Gambia", "Banjul", 1.782, Continent.AFRICA, 11));

        return countries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("capital city", capitalCity)
                .add("population", population).toString();
    }
}
