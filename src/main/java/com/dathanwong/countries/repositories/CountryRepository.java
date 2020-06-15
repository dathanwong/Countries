package com.dathanwong.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dathanwong.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{

	@Query(value="SELECT c.name, l.language, l.percentage FROM world.countries c JOIN world.languages l ON c.id = l.country_id WHERE l.language = ?1 order by l.percentage desc", nativeQuery=true)
	List<Object[]> findCountryByLanguage(String language);
	
	@Query(value="SELECT country.name, COUNT(city.name) FROM world.countries country JOIN world.cities city ON country.id = city.country_id group by country.name ORDER BY COUNT(city.name) desc", nativeQuery=true)
	List<Object[]> findNumCities();
	
	@Query(value="SELECT * FROM world.countries WHERE surface_area < ?1 AND population > ?2", nativeQuery = true)
	List<Country> findCountrySurfaceAreaAndPopulation(double surfaceArea, int population);
	
	@Query(value="SELECT * FROM world.countries WHERE government_form = \"Constitutional Monarchy\" AND surface_area > 200 AND life_expectancy > 75", nativeQuery = true)
	List<Country> findCountryConstMonSurfaceArea();
	
	@Query(value="SELECT region, COUNT(*) numCountries FROM world.countries GROUP BY region ORDER BY numCountries desc", nativeQuery = true)
	List<Object[]> countCountriesByRegion();
}
