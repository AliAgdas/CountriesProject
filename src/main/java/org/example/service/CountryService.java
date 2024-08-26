package org.example.service;

import org.example.entity.Country;
import org.example.repository.CountryRepository;
import java.util.List;

public class CountryService implements CountryServiceInterface {
    private CountryRepository repository;

    public CountryService() {
        this.repository = new CountryRepository();
    }

    @Override
    public String getCountryByIso(String iso) {
        return repository.getCountryByIso("from Country where iso = :iso",iso);
    }

    @Override
    public List<String> getCountriesByLetter(String letter) {
        return repository.getCountriesByLetter("FROM Country WHERE name LIKE :letter",letter);
    }

    @Override
    public String getCountryInfoByName(String name) {
        return repository.getCountryInfoByName("from Country where name = :name",name);
    }

}


