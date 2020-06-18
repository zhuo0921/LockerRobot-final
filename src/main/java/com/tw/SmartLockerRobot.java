package com.tw;

import java.util.List;

public class SmartLockerRobot extends AbstractLockerRobot {

    SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket save(Bag bag) {
        lockers.sort((o1, o2) -> o2.getAvailableCapacity() - o1.getAvailableCapacity());
        return lockers.get(0).save(bag);
    }
}
