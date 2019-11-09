package com.kukhotskovolets.lab.model;

import com.kukhotskovolets.lab.model.submodel.Area;

import java.time.LocalDate;
import java.util.Date;
import java.util.zip.CheckedOutputStream;

public class Country {
    public enum FieldNamesXmlSync {
        NAME("name"),
        POPULATION("population"),
        CAPITAL("capital"),
        POLICY("policy"),
        FOUNDINGDATE("foundingDate");

        private final String xmlName;

        FieldNamesXmlSync(String xmlName) {
            this.xmlName = xmlName;
        }

        public String getXmlName() {
            return xmlName;
        }
    }

    private String name;
    private long population;
    private String capital;
    private String policy;
    private LocalDate foundingDate;
    private Area area;

    public Country() {}

    public Country(String name, long population, String capital, String policy, LocalDate foundingDate, Area area) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.policy = policy;
        this.foundingDate = foundingDate;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        this.foundingDate = foundingDate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
