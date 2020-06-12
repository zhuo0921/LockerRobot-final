package com.tw;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Bag> storedBags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;

    }

    public Ticket store(Bag bag) {
        if (storedBags.size() >= capacity) {
            throw new LockerAlreadyFullException();
        }
        Ticket ticket = new Ticket();
        storedBags.put(ticket, bag);
        return ticket;
    }

    public Bag fetch(Ticket ticket) {
        return storedBags.remove(ticket);
    }

    public boolean isFull() {
        return capacity == storedBags.size();
    }
}
