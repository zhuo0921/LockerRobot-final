package com.tw;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<LockerTicket, Bag> storedBags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;

    }

    public LockerTicket store(Bag bag) {
        if (storedBags.size() >= capacity) {
            throw new LockerAlreadyFullException();
        }
        LockerTicket ticket = new LockerTicket();
        storedBags.put(ticket, bag);
        return ticket;
    }

    public Bag fetch(LockerTicket ticket) {
        return storedBags.remove(ticket);
    }
}
