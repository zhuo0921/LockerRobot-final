package com.tw;

import com.tw.exception.InvalidTicketException;
import com.tw.exception.LockerIsFullException;

import java.util.HashMap;

class Locker {
    private int availableCapacity;
    private HashMap<Ticket, Bag> savedBags = new HashMap<>();

    Locker(int capacity) {
        this.availableCapacity = capacity;
    }

    Ticket save(Bag bag) {
        if (availableCapacity <= 0) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        savedBags.put(ticket, bag);
        availableCapacity--;
        return ticket;
    }

    Bag pickUpBy(Ticket ticket) {
        Bag bag = savedBags.remove(ticket);
        if (bag == null) {
            throw new InvalidTicketException();
        }
        return bag;
    }

    boolean isFull() {
        return availableCapacity == 0;
    }

    boolean contains(Ticket ticket) {
        return savedBags.containsKey(ticket);
    }

    int getAvailableCapacity() {
        return availableCapacity;
    }
}
