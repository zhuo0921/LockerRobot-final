package com.tw;

import java.util.List;

public class SmartLockerRobot {
    private final List<Locker> lockers;

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        lockers.sort((o1, o2) -> o2.getAvailableCapacity() - o1.getAvailableCapacity());
        return lockers.get(0).save(bag);
    }
}
