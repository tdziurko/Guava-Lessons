package pl.tomaszdziurko.guava.collect;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.tomaszdziurko.guava.geo.Continent;
import pl.tomaszdziurko.guava.geo.Country;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Collections2 showcase
 */
public class Collections2Test {

    @Test
    public void shouldTransformCollection() throws Exception {

        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.ENGLAND);

        // when
        Collection<String> capitalCities = Collections2.transform(countries,
                new Function<Country, String>() {

                    @Override
                    public String apply(@Nullable Country country) {
                        return country.getCapitalCity();
                    }
                });

        // then
        assertThat(capitalCities).containsOnly("Warsaw", "Brussels", "London");
    }

    @Test
    public void shouldFilterCountriesOnlyFromAfrica() throws Exception {

        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.SOUTH_AFRICA);

        // when
        Collection<Country> countriesFromAfrica = Collections2.filter(countries, new Predicate<Country>() {

            @Override
            public boolean apply(@Nullable Country country) {
                return Continent.AFRICA.equals(country.getContinent());
            }
        });

        // then
        assertThat(countriesFromAfrica).containsOnly(Country.SOUTH_AFRICA);
    }

    @Test
    public void shouldShowThatResultIsOnlyAView() throws Exception {

        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.ENGLAND);

        // when
        Collection<String> capitalCities = Collections2.transform(countries,
                new Function<Country, String>() {

                    @Override
                    public String apply(@Nullable Country country) {
                        return country.getCapitalCity();
                    }
                });

        // then
        assertThat(capitalCities).containsOnly("Warsaw", "Brussels", "London");
        assertThat(capitalCities).excludes("Pretoria");

        countries.add(Country.SOUTH_AFRICA);

        assertThat(capitalCities).contains("Pretoria");
    }
}
