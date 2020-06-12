package com.tw;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) {
        Locker firstAvailableLocker = lockers.stream()
                .filter(locker -> !locker.isFull())
                .findFirst().get();
        return firstAvailableLocker.store(bag);
    }
}
