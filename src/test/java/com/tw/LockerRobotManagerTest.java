package com.tw;

import com.tw.exception.LockerIsFullException;
import com.tw.robot.PrimaryLockerRobot;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
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

    @Test
    public void should_return_ticket_save_in_2nd_locker_when_save_bag_given_manager_has_two_lockers_1st_is_full_2nd_has_capacity_and_no_robots() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(2);
        LockerRobotManager manager = new LockerRobotManager(asList(firstLocker, secondLocker), emptyList());
        firstLocker.save(new Bag());

        Bag myBag = new Bag();
        Ticket ticket = manager.save(myBag);

        assertNotNull(ticket);
        assertSame(myBag, secondLocker.pickUp(ticket));
    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_save_bag_given_manager_has_two_lockers_both_are_full_and_no_robots() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);
        LockerRobotManager manager = new LockerRobotManager(asList(firstLocker, secondLocker), emptyList());
        firstLocker.save(new Bag());
        secondLocker.save(new Bag());

        manager.save(new Bag());
    }

    @Test
    public void should_return_ticket_and_save_to_1st_robots_when_save_bag_given_manager_has_two_robots_with_capacity_and_no_lockers() {
        Locker firstRobotLocker = new Locker(1);
        LockerRobotManager manager = new LockerRobotManager(emptyList(),
                asList(new PrimaryLockerRobot(singletonList(firstRobotLocker)),
                        new PrimaryLockerRobot(singletonList(new Locker(2)))));

        Bag myBag = new Bag();
        Ticket ticket = manager.save(myBag);

        assertNotNull(ticket);
        assertSame(myBag, firstRobotLocker.pickUp(ticket));
    }
}
