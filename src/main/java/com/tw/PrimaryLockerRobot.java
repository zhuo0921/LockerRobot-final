package com.tw;

import java.util.List;
import java.util.function.Supplier;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws Throwable {
        Locker firstAvailableLocker = lockers.stream()
                .filter(locker -> !locker.isFull())
                .findFirst().orElseThrow((Supplier<Throwable>) LockerAlreadyFullException::new);
        return firstAvailableLocker.store(bag);
    }
}
