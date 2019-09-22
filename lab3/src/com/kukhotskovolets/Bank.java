package com.kukhotskovolets;

import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private String name;
    private Integer foundingDate;
    private Description description;

    public static class Description {
        Integer capital;
        String capitalUnit;
        Integer workersAmount;
        String country;
        String city;
        String history;
        List<String> awards;

        Description(Integer capital, String capitalUnit, Integer workersAmount, String country, String city,
                    String history, List<String> awards) {
            this.capital = capital;
            this.capitalUnit = capitalUnit;
            this.workersAmount = workersAmount;
            this.country = country;
            this.city = city;
            this.history = history;
            this.awards = awards;
        }
    }

    public Bank(String name, Integer foundingDate, Integer capital, String capitalUnit, Integer workersAmount,
                String country, String city, String history, List<String> awards) {
        this.name = name;
        this.foundingDate = foundingDate;
        this.description = new Description(capital, capitalUnit, workersAmount, country, city, history, awards);
    }

    @Override
    public String toString() {
        String awardsListString = this.description.awards.stream()
                .map(item -> "\t- " + item + "")
                .collect(Collectors.joining("\n"));
        return String.format("%s\n%d\n%d %s\n%d\n%s, %s\n%s\n%s",
                this.name, this.foundingDate, this.description.capital, this.description.capitalUnit,
                this.description.workersAmount, this.description.country, this.description.city,
                this.description.history, awardsListString);
    }

    public String getName() {
        return name;
    }

    public Integer getFoundingDate() {
        return foundingDate;
    }

    public Integer getCapital() {
        return this.description.capital;
    }

    public String getCapitalUnit() {
        return this.description.capitalUnit;
    }

    public Integer getWorkersAmount() {
        return this.description.workersAmount;
    }

    public String getCountry() {
        return this.description.country;
    }

    public String getCity() {
        return this.description.city;
    }

    public List<String> getAwards() {
        return this.description.awards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoundingDate(Integer foundingDate) {
        this.foundingDate = foundingDate;
    }

    public void setCapital(Integer capital) {
        this.description.capital = capital;
    }

    public void setCapitalUnit(String capitalUnit) {
        this.description.capitalUnit = capitalUnit;
    }

    public void setWorkersAmount(Integer workersAmount) {
        this.description.workersAmount = workersAmount;
    }

    public void setCountry(String country) {
        this.description.country = country;
    }

    public void setCity(String city) {
        this.description.city = city;
    }

    public String getHistory() {
        return this.description.history;
    }

    public void setHistory(String history) {
        this.description.history = history;
    }

    public void setAwards(List<String> awards) {
        this.description.awards = awards;
    }
}
