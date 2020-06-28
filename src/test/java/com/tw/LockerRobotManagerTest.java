package com.tw;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class LockerRobotManagerTest {
    @Test
    public void should_return_ticket_save_in_1st_locker_when_save_bag_given_manager_has_two_lockers_with_capacity_and_no_robots() {
        Locker firstLocker = new Locker(1);
        LockerRobotManager manager = new LockerRobotManager(asList(firstLocker, new Locker(2)), emptyList());

        Bag myBag = new Bag();
        Ticket ticket = manager.save(myBag);

        assertNotNull(ticket);
        assertSame(myBag, firstLocker.pickUp(ticket));
    }
}
