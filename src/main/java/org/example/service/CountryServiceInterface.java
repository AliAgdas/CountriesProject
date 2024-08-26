package org.example.service;

import org.example.entity.Country;

import java.util.List;

public interface CountryServiceInterface {
    String getCountryByIso(String iso);
    List<String> getCountriesByLetter(String letter);
    String getCountryInfoByName(String countryName);
}

