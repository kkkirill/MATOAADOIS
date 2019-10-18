package com.kukhotskovolets.events;

import com.kukhotskovolets.base.Athlete;
import com.kukhotskovolets.base.Sport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public abstract class BaseSportEvent {
    public String name;
    public Date startDate;
    public Date endDate;
    public ArrayList<Sport> sportTypes;
    public ArrayList<Athlete> participants;

    public BaseSportEvent(String name, Date startDate, Date endDate, Sport... sportTypes) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;

        this.sportTypes = new ArrayList<>(sportTypes.length);
        this.sportTypes.addAll(Arrays.asList(sportTypes));
        this.participants = new ArrayList<>(10);
    }

    public ArrayList<Athlete> registerParticipants(Athlete... athletes) {
        participants.addAll(Arrays.stream(athletes)
                .filter(athlete -> this.sportTypes.contains(athlete.sportType) && athlete.qualificationLevel >= 70)
                .collect(Collectors.toList())
        );
        return participants;
    }

    public void begin() {
        if (!participants.isEmpty())
            System.out.println(String.format("%s started!", name));
        else {
            System.out.println("No participants! Closing event");
            end();
        }
    }

    public void end() {
        System.out.println(String.format("%s ended!", name));
        awardWinners();
    }

    private void awardWinners() {
        System.out.println("Awarding winners");
    }
}
