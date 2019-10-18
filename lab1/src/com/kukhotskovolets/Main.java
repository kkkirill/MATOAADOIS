package com.kukhotskovolets;

import com.kukhotskovolets.base.Athlete;
import com.kukhotskovolets.base.Sport;
import com.kukhotskovolets.base.Trainer;
import com.kukhotskovolets.base.human.Gender;
import com.kukhotskovolets.base.human.Human;
import com.kukhotskovolets.events.Competition;
import com.kukhotskovolets.events.Olympiad;
import com.kukhotskovolets.institutions.MinistryOfSport;
import com.kukhotskovolets.institutions.SportSchool;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Human humanSteve = new Human.Builder()
                .setName("Steve")
                .setSurname("Stevenson")
                .setSecondName("S")
                .setAge(30)
                .setDate(new GregorianCalendar(1989, Calendar.NOVEMBER, 23).getTime())
                .setGender(Gender.MALE)
                .build();
        Human humanNatasha = new Human.Builder()
                .setName("Natasha")
                .setSurname("Natashevna")
                .setSecondName("N")
                .setAge(23)
                .setDate(new GregorianCalendar(1996, Calendar.MARCH, 15).getTime())
                .setGender(Gender.FEMALE)
                .build();
        Human humanSergey = new Human.Builder()
                .setName("Sergey")
                .setSurname("Sergeevich")
                .setSecondName("S")
                .setAge(26)
                .setDate(new GregorianCalendar(1993, Calendar.MAY, 1).getTime())
                .setGender(Gender.MALE)
                .build();
        Human humanVadim = new Human.Builder()
                .setName("Vadim")
                .setSurname("Vadimovich")
                .setSecondName("V")
                .setAge(24)
                .setDate(new GregorianCalendar(1995, Calendar.SEPTEMBER, 4).getTime())
                .setGender(Gender.MALE)
                .build();
        Human humanJohn = new Human.Builder()
                .setName("John")
                .setSurname("Gawwer")
                .setSecondName("J")
                .setAge(30)
                .setDate(new GregorianCalendar(1989, Calendar.FEBRUARY, 15).getTime())
                .setGender(Gender.MALE)
                .build();

        Athlete athleteSergey = new Athlete(humanSergey, Sport.BIATHLON);
        Athlete athleteNatasha = new Athlete(humanNatasha, Sport.SKIING);
        Athlete athleteSteve = new Athlete(humanSteve, Sport.SKIJUMPING);

        Trainer trainerVadim = new Trainer(new Athlete(humanVadim, Sport.BIATHLON));
        Trainer trainerJohn = new Trainer(new Athlete(humanJohn, Sport.SKIING));

        SportSchool sportSchool = new SportSchool("VeryGoodSchool", new BigDecimal(4000), trainerVadim, trainerJohn);
        SportSchool anotherSportSchool = new SportSchool("AnotherVeryGoodSchool", new BigDecimal(3000),
                trainerVadim, trainerJohn);
        sportSchool.addAthletes(athleteSergey, athleteNatasha);
        sportSchool.addAthletes(athleteSteve);
        for (int i = 0; i < 20; i++) {
            sportSchool.train();
            anotherSportSchool.train();
        }

        MinistryOfSport ministryOfSport = new MinistryOfSport(new BigDecimal(20_000_000));
        ministryOfSport.addSchools(sportSchool, anotherSportSchool);
        ministryOfSport.finance();
        ministryOfSport.chooseNationalAthletes();

        Date startDate = new GregorianCalendar(2019, Calendar.NOVEMBER, 11).getTime();
        Date endDate = new GregorianCalendar(2019, Calendar.NOVEMBER, 20).getTime();

        Competition competition = new Competition("Skiing competition", startDate, endDate, Sport.SKIING);
        competition.registerParticipants(athleteNatasha, athleteSergey, athleteSteve);
        competition.begin();
        competition.end();

        Date olympiadStartDate = new GregorianCalendar(2020, Calendar.JANUARY, 11).getTime();
        Date olympiadEndDate = new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime();

        Olympiad olympiad = new Olympiad("Mega Olympiad", olympiadStartDate, olympiadEndDate,
                Sport.BIATHLON, Sport.SKIING, Sport.SKIJUMPING);
        olympiad.registerParticipants(athleteNatasha, athleteSergey, athleteSteve);
        olympiad.begin();
        olympiad.end();
    }
}
