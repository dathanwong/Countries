package com.dathanwong.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dathanwong.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

	@Query(value="SELECT * FROM world.languages WHERE percentage > ?1 ORDER BY percentage desc", nativeQuery = true)
	List<Language> findLanguagesGreaterThanPercentage(double percentage);
}
