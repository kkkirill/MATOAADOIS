package com.kukhotskovolets.institutions;

import com.kukhotskovolets.base.Athlete;
import com.kukhotskovolets.base.Trainer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SportSchool {
    public String name;
    private BigDecimal monthlyBudget;
    public ArrayList<Trainer> trainers;
    public ArrayList<Athlete> athletes;

    public SportSchool(String name, BigDecimal monthlyBudget, Trainer... trainers) {
        this.name = name;
        this.monthlyBudget = monthlyBudget;

        this.trainers = new ArrayList<>(trainers.length);
        this.trainers.addAll(Arrays.asList(trainers));
        this.athletes = new ArrayList<>();
    }

    public void addAthletes(Athlete... athletes) {
        this.athletes.addAll(Arrays.asList(athletes));
    }

    public void train() {
        Random random = new Random();
        athletes.forEach(athlete -> trainers.get(random.nextInt(trainers.size() - 1)).train(athlete));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMonthlyBudget() {
        return monthlyBudget;
    }

    public void getFinancing(BigDecimal ca$h) {
        monthlyBudget = monthlyBudget.add(ca$h);
    }
}
