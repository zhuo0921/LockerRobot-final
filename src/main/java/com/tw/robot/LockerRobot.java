package com.tw.robot;

import com.tw.Bag;
import com.tw.Locker;
import com.tw.Ticket;
import com.tw.exception.InvalidTicketException;

import java.util.List;
import java.util.function.Predicate;

public abstract class LockerRobot {
    final List<Locker> lockers;

    LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket save(Bag bag);

    public Bag pickUpBy(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public boolean isFull() {
        return lockers.stream().allMatch(Locker::isFull);
    }
}
