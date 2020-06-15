package com.dathanwong.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dathanwong.countries.models.City;
import com.dathanwong.countries.models.Country;
import com.dathanwong.countries.models.Language;
import com.dathanwong.countries.repositories.CityRepository;
import com.dathanwong.countries.repositories.CountryRepository;
import com.dathanwong.countries.repositories.LanguageRepository;

@Service
public class ApiService {

	private final CityRepository cityRepo;
	private final CountryRepository countryRepo;
	private final LanguageRepository languageRepo;
	
	public ApiService(CityRepository cityRepo, CountryRepository countryRepo, LanguageRepository languageRepo) {
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.languageRepo = languageRepo;
	}
	
	public String findCountryByLanguage(String language){
		List<Object[]> countries = countryRepo.findCountryByLanguage(language);
		String output = "";
		for(Object[] row : countries) {
			output += row[0] + " " + row[1] + " " + row[2] + "<br>";
		}
		return output;
	}
	
	public String findNumCities() {
		List<Object[]> countries = countryRepo.findNumCities();
		String output = "";
		for(Object[] row: countries) {
			output += row[0] + " : " + row[1] + "<br>"; 
		}
		return output;
	}
	
	public String findAllCitiesWithPopulationOver(int population) {
		List<City> cities = cityRepo.findAllCityWithPopulationGreaterThan(population);
		String output = "";
		for(City city: cities) {
			output += city.getName() + " : " + city.getPopulation() + "<br>";
		}
		return output;
	}
	
	public String findLanguagesGreaterThanPercentage(double percentage) {
		List<Language> languages = languageRepo.findLanguagesGreaterThanPercentage(percentage);
		String output = "";
		for(Language l: languages) {
			output += l.getLanguage() + " : " + l.getPercentage() + "<br>";
		}
		return output;
	}
	
	public String findCountrySurfaceAreaPopulation(double surfaceArea, int population) {
		List<Country> countries = countryRepo.findCountrySurfaceAreaAndPopulation(surfaceArea, population);
		String output = "";
		for(Country c: countries) {
			output += c.getName() + " : " + c.getSurface_area() + " : " + c.getPopulation() + "<br>";
		}
		return output;
	}
	
	public String findCountryConstMonarchy() {
		List<Country> countries = countryRepo.findCountryConstMonSurfaceArea();
		String output = "";
		for(Country c: countries) {
			output += c.getName() + " : " + c.getSurface_area() + " : " + c.getLife_expenctancy() + "<br>";
		}
		return output;
	}
	
	public String findArgentinaCities() {
		List<Object[]> objects = cityRepo.findArgentinaCities();
		String output = "";
		for(Object[] row: objects) {
			output += row[0] + " : " + row[1] + " : " + row[2] + " : " + row[3] +"<br>"; 
		}
		return output;
	}
	
	public String countCountriesByRegion() {
		List<Object[]> objects = countryRepo.countCountriesByRegion();
		String output = "";
		for(Object[] row: objects) {
			output += row[0] + " : " + row[1] + " : " + "<br>"; 
		}
		return output;
	}
}
