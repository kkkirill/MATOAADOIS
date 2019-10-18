package com.kukhotskovolets.base;

import com.kukhotskovolets.base.human.Gender;
import com.kukhotskovolets.base.human.Human;

import java.util.Date;
import java.util.Random;

public class Trainer extends Athlete {

    public Trainer(String name, String surname, String secondName, Gender gender, Integer age, Date birthDate, Sport sportType) {
        super(name, surname, secondName, gender, age, birthDate, sportType);
        this.qualificationLevel = 100;
    }

    public Trainer(Athlete athlete) {
        super(athlete, athlete.sportType);
        this.qualificationLevel = 100;
    }

    public void train(Athlete... athletes) {
        Random random = new Random();
        for (Athlete a : athletes) {
            a.train(1 + random.nextInt(10));
        }
    }

    @Override
    public void train(int boostFactor) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Trainer is already trained!");
    }

    @Override
    public void compete() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Trainer cannot compete");
    }
}
