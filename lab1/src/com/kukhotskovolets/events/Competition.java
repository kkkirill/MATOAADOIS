package com.kukhotskovolets.events;

import com.kukhotskovolets.base.Sport;

import java.util.Date;

public class Competition extends BaseSportEvent {

    public Competition(String name, Date startDate, Date endDate, Sport sportType) {
        super(name, startDate, endDate, sportType);
    }
}
