package com.tw;


import com.tw.exception.InvalidTicketException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class LockerTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_lockerA_capacity_is_12_when_store_a_bag_then_store_successfully_and_get_valid_ticketA() {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag(Size.SMALL);
        Ticket ticketA = lockerA.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_lockerA_stored_bagA_when_get_bag_with_valid_ticket_then_get_bagA() {
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag(Size.SMALL);
        Ticket ticketA = lockerA.store(bagA);

        Bag bagFromLocker = lockerA.getBag(ticketA);

        assertNotNull(bagFromLocker);
        assertEquals(bagA, bagFromLocker);
    }

    @Test
    public void given_lockerA_stored_bagA_and_bagB_and_ticketA_has_been_used_to_get_bagA_when_get_bag_with_ticketA_again_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag(Size.SMALL);
        Bag bagB = new Bag(Size.SMALL);
        Ticket ticketA = lockerA.store(bagA);
        lockerA.store(bagB);
        lockerA.getBag(ticketA);

        expectedEx.expect(InvalidTicketException.class);
        lockerA.getBag(ticketA);
    }
}
