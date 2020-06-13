package com.tw;

import java.util.List;

public class PrimaryLockerRobot {

    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.store(bag);
            }
        }
        throw new LockerAlreadyFullException();
    }
}
