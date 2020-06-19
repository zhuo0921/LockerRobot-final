package com.tw.robot;

import com.tw.Bag;
import com.tw.Locker;
import com.tw.Ticket;
import com.tw.exception.LockerIsFullException;
import com.tw.robot.AbstractLockerRobot;

import java.util.List;

public class PrimaryLockerRobot extends AbstractLockerRobot {

    PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
