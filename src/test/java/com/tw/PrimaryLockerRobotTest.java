package com.tw;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class PrimaryLockerRobotTest {
    @Test
    public void should_return_ticket_and_save_in_1st_locker_when_save_bag_given_robot_manage_two_lockers_both_have_capacity() {
        Locker firstLocker = new Locker(6);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(asList(firstLocker, new Locker(10)));

        Bag myBag = new Bag();
        Ticket ticket = robot.save(myBag);

        assertNotNull(ticket);
        assertSame(myBag, firstLocker.pickUpBy(ticket));
    }
}
