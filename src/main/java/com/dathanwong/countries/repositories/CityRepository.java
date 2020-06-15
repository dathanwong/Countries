package com.dathanwong.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dathanwong.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

	@Query(value="SELECT * FROM world.cities WHERE population > ?1 ORDER BY population desc", nativeQuery=true)
	List<City> findAllCityWithPopulationGreaterThan(int population);
	@Query(value="SElECt country.name countryName, city.name cityName, city.district, city.population FROM world.cities city JOIN world.countries country ON city.country_id = country.id WHERE country.name = \"Argentina\" AND city.district = \"Buenos Aires\" AND city.population > 500000", nativeQuery=true)
	List<Object[]> findArgentinaCities();
}
