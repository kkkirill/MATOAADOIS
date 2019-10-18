package com.kukhotskovolets.institutions;

import com.kukhotskovolets.base.Athlete;
import com.kukhotskovolets.base.Sport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MinistryOfSport {
    private BigDecimal budget;
    private ArrayList<SportSchool> schools;

    public MinistryOfSport(BigDecimal budget) {
        this.budget = budget;
        this.schools = new ArrayList<>(10);
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public ArrayList<SportSchool> getSchools() {
        return schools;
    }

    public void addSchools(SportSchool... schools) {
        this.schools.addAll(Arrays.stream(schools)
                .filter(sportSchool -> !this.schools.contains(sportSchool))
                .collect(Collectors.toList())
        );
    }

    public void finance() {
        schools.forEach(sportSchool -> {
            budget = budget.subtract(sportSchool.getMonthlyBudget());
            sportSchool.getFinancing(sportSchool.getMonthlyBudget());
        });
    }

    public void chooseNationalAthletes() {
        schools.forEach(sportSchool ->
            sportSchool.athletes
                    .stream()
                    .sorted(Comparator.comparing(Athlete::getQualificationLevel).reversed())
                    .limit(10)
                    .forEach(athlete -> athlete.setMemberOfNationalTeam(true))
        );
    }
}
