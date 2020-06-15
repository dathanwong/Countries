package com.dathanwong.countries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dathanwong.countries.models.Country;
import com.dathanwong.countries.services.ApiService;

@RestController
public class MainController {

	private final ApiService service;
	
	public MainController(ApiService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String home() {
//		1.
//		return service.findCountryByLanguage("Slovene");
//		2.
//		return service.findNumCities();
//		3.
//		return service.findAllCitiesWithPopulationOver(500000);
//		4.
//		return service.findLanguagesGreaterThanPercentage(89.0);
//		5.
//		return service.findCountrySurfaceAreaPopulation(501.0, 100000);
//		6.
//		return service.findCountryConstMonarchy();
//		7.
//		return service.findArgentinaCities();
//		8.
		return service.countCountriesByRegion();
	}
}
