package com.tw;

import java.util.List;

public abstract class AbstractLockerRobot implements LockerRobot {
    protected final List<Locker> lockers;

    public AbstractLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
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
