package com.thoughtworks.reactiveatddworkshop.domain;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Status implements Serializable {

    private AtomicInteger numberOfStatusRequests;
    @Getter
    private LocalTime startTimestamp;

    public Status() {
        this.startTimestamp = LocalTime.now();
        this.numberOfStatusRequests = new AtomicInteger();
    }

    public int getNumberOfStatusRequests() {
        return numberOfStatusRequests.incrementAndGet();
    }
}
