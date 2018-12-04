package com.sjsu.cmpe.sstreet.mirroringserver.model;

import java.util.Date;

public class TimeRange {

    private Date from;

    private Date to;

    public TimeRange() {

    }

    public TimeRange(Date from, Date to) {

        this.from = from;
        this.to = to;
    }

    public TimeRange(long from, long to) {

        this.from = new Date(from);
        this.to = new Date(to);
    }

    public Date getFrom() {

        return from;
    }

    public void setFrom(Date from) {

        this.from = from;
    }

    public Date getTo() {

        return to;
    }

    public void setTo(Date to) {

        this.to = to;
    }
}
