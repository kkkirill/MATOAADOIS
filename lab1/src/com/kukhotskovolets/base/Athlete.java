package com.kukhotskovolets.base;

import com.kukhotskovolets.base.human.Gender;
import com.kukhotskovolets.base.human.Human;

import java.util.Date;

public class Athlete extends Human implements IAthlete {
    public Sport sportType;
    public int qualificationLevel;
    private boolean isMemberOfNationalTeam;

    public Athlete(String name, String surname, String secondName, Gender gender, Integer age, Date birthDate,
                   Sport sportType) {
        super(name, surname, secondName, gender, age, birthDate);
        this.sportType = sportType;
    }

    public Athlete(Human human, Sport sportType) {
        super(human);
        this.sportType = sportType;
    }

    public void setMemberOfNationalTeam(boolean isMemberOfNationalTeam) {
        this.isMemberOfNationalTeam = isMemberOfNationalTeam;
    }

    public boolean isMemberOfNationalTeam() {
        return isMemberOfNationalTeam;
    }

    public Sport getSportType() {
        return sportType;
    }

    public int getQualificationLevel() {
        return qualificationLevel;
    }

    @Override
    public void train(int boostFactor) {
        qualificationLevel += boostFactor;
        System.out.println(String.format("%s is training", this.getName()));
    }

    @Override
    public void compete() {
        System.out.println("Compete");
    }
}
