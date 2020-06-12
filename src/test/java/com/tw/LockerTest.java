package com.tw;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    public void should_return_ticket_when_store_bag_given_locker_has_capacity() {
        Locker locker = new Locker(10);
        Ticket ticket = locker.store(new Bag());
        assertNotNull(ticket);
    }

    @Test
    public void should_prompt_failure_when_store_bag_given_locker_is_full() {
        Locker locker = new Locker(1);
        Ticket ticket = locker.store(new Bag());
        assertNotNull(ticket);

        assertThrows(LockerAlreadyFullException.class, () -> locker.store(new Bag()));
    }

    @Test
    public void should_get_bag_when_fetch_bag_given_valid_ticket() {
        Locker locker = new Locker(10);
        Bag myBag = new Bag();
        Ticket ticket = locker.store(myBag);

        Bag bag = locker.fetch(ticket);
        assertEquals(myBag, bag);
    }

    @Test
    public void should_not_get_bag_when_fetch_bag_given_fake_ticket() {
        Locker locker = new Locker(10);
        locker.store(new Bag());

        Bag bag = locker.fetch(new Ticket());
        assertNull(bag);
    }

    @Test
    public void should_not_get_bag_when_fetch_bag_given_ticket_already_used() {
        Locker locker = new Locker(10);
        Bag myBag = new Bag();
        Ticket ticket = locker.store(myBag);

        Bag bag = locker.fetch(ticket);
        assertEquals(myBag, bag);

        assertNull(locker.fetch(ticket));
    }
}
