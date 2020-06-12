package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LockerTest {
    @Test
    public void should_return_ticket_when_store_bag_given_locker_has_capacity() {
        Locker locker = new Locker(10);
        LockerTicket ticket = locker.store(new Bag());
        assertNotNull(ticket);
    }

    @Test(expected = LockerAlreadyFullException.class)
    public void should_prompt_failure_when_store_bag_given_locker_is_full() {
        Locker locker = new Locker(1);
        LockerTicket ticket = locker.store(new Bag());
        assertNotNull(ticket);

        locker.store(new Bag());
    }

    @Test
    public void should_get_bag_when_fetch_bag_given_valid_ticket() {
        Locker locker = new Locker(10);
        Bag myBag = new Bag();
        LockerTicket ticket = locker.store(myBag);

        Bag bag = locker.fetch(ticket);
        assertEquals(myBag, bag);
    }
}
