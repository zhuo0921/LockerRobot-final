package com.tw;

import com.tw.exception.InvalidTicketException;

import java.util.List;

public abstract class AbstractLockerRobot implements LockerRobot {
    final List<Locker> lockers;

    AbstractLockerRobot(List<Locker> lockers) {
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
