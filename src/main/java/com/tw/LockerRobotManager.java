package com.tw;

import com.tw.robot.LockerRobot;

import java.util.List;

public class LockerRobotManager {

    private final List<Locker> lockers;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> robots) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        return null;
    }
}
