package com.kukhotskovolets.events;

import com.kukhotskovolets.base.Athlete;
import com.kukhotskovolets.base.Sport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class Olympiad extends BaseSportEvent {

    public Olympiad(String name, Date startDate, Date endDate, Sport... sportTypes) {
        super(name, startDate, endDate, sportTypes);
    }

    @Override
    public ArrayList<Athlete> registerParticipants(Athlete... athletes) {
        participants.addAll(Arrays.stream(athletes)
                .filter(athlete -> this.sportTypes.contains(athlete.sportType) && athlete.isMemberOfNationalTeam())
                .collect(Collectors.toList())
        );
        return participants;
    }
}
