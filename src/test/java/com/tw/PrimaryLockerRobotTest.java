package com.tw;

import com.tw.exception.LockerIsFullException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimaryLockerRobotTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void given_PrimaryLockerRobot_manages_LockerA_and_lockerA_has_one_available_space_when_PrimaryLockerRobot_stores_bagA_then_store_successfully_and_get_valid_ticketA() {
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag(Size.MEDIUM);

        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Ticket ticketA = primaryLockerRobot.store(bagA);
        assertNotNull(ticketA);
    }


    @Test
    public void given_primaryLockerRobot_manages_LockerA_and_lockerA_has_no_available_space_when_PrimaryLockerRobot_stores_bagA_then_get_error_message() throws LockerIsFullException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag(Size.MEDIUM));
        Bag bagA = new Bag(Size.MEDIUM);


        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));

        expectedException.expect(LockerIsFullException.class);
        primaryLockerRobot.store(bagA);
    }

    @Test
    public void given_PrimaryLockerRobot_manage_LockerA_and_LockerB_both_lockers_have_available_spaces_when_PrimaryLockerRobot_stores_bagA_then_get_valid_ticketA_and_bagA_is_stored_in_LockerA() {
        Locker lockerA = new Locker(12);
        Locker lockerB = new Locker(12);
        Bag bagA = new Bag(Size.MEDIUM);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));
        Ticket ticketA = primaryLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }
}
