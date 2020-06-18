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

    public Bag pickUpBy(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUpBy(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
