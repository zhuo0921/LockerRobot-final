package com.tw.robot;

import com.tw.Bag;
import com.tw.Locker;
import com.tw.Ticket;
import com.tw.exception.InvalidTicketException;

import java.util.List;

public abstract class AbstractLockerRobot {
    final List<Locker> lockers;

    AbstractLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Bag pickUpBy(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.contains(ticket)) {
                return locker.pickUp(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
