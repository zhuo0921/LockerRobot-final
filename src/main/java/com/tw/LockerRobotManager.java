package com.tw;

import com.tw.exception.LockerIsFullException;
import com.tw.robot.LockerRobot;

import java.util.List;

public class LockerRobotManager {

    private final List<Locker> lockers;
    private final List<LockerRobot> robots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> robots) {
        this.lockers = lockers;
        this.robots = robots;
    }

    public Ticket save(Bag bag) {
        if (!robots.isEmpty()) {
            return robots.get(0).save(bag);
        }

        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
