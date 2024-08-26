package org.example.repository;

import org.example.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CountryRepository {

    private SessionFactory sessionFactory;

    public CountryRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public String getCountryByIso(String crud,String iso) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.createQuery(crud, Country.class)
                .setParameter("iso", iso)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();

        if (country == null) {
            return "yok";
        }
        return country.getName();
    }

    public List<String> getCountriesByLetter(String crud,String letter) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Country> countries = session.createQuery(crud, Country.class)
                .setParameter("letter", letter + "%")
                .list();

        session.getTransaction().commit();
        session.close();

        List<String> countryNames = new ArrayList<>();
        for (Country country : countries) {
            countryNames.add(country.getName());
        }

        if (countryNames.isEmpty()) {
            countryNames.add("yok");
        }

        return countryNames;
    }

    public String getCountryInfoByName(String crud,String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.createQuery(crud, Country.class)
                .setParameter("name", name)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();

        if (country == null) {
            return "yok";
        }
        String infos = country.getId()+","+country.getIso()+","+country.getName()+","+country.getNicename()+","+country.getIso3()+","+country.getNumcode()+","+country.getPhonecode();
        return infos;
    }




}


