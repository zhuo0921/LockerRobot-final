package com.tw;

import com.tw.exception.InvalidTicketException;
import com.tw.exception.LockerIsFullException;

import java.util.HashMap;

public class Locker implements Storable {
    private final int capacity;
    private final HashMap<Ticket, Bag> savedBags = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Ticket save(Bag bag) {
        if (isFull()) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        savedBags.put(ticket, bag);
        return ticket;
    }

    @Override
    public Bag pickUp(Ticket ticket) {
        Bag bag = savedBags.remove(ticket);
        if (bag == null) {
            throw new InvalidTicketException();
        }
        return bag;
    }

    @Override
    public boolean isFull() {
        return getAvailableCapacity() == 0;
    }

    public int getAvailableCapacity() {
        return capacity - savedBags.size();
    }

    @Override
    public boolean contains(Ticket ticket) {
        return savedBags.containsKey(ticket);
    }
}
