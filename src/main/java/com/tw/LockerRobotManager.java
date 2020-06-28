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
        for (LockerRobot robot : robots) {
            if (!robot.isFull()) {
                return robot.save(bag);
            }
        }

        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
