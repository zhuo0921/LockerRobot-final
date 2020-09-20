package com.tw;

import com.tw.exception.InvalidTicketException;
import com.tw.exception.LockerIsFullException;

import java.util.HashMap;

public class Locker {
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private Integer capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (this.getAvailableSpaceNumber() == 0) {
            throw new LockerIsFullException();
        } else {
            Ticket ticket = new Ticket();
            bagMap.put(ticket, bag);
            return ticket;
        }
    }

    public Integer getAvailableSpaceNumber() {
        return this.capacity - bagMap.size();

    }
    public Bag getBag(Ticket ticket) {
        if (bagMap.isEmpty()) {
            throw new InvalidTicketException();
        } else {
            if (bagMap.containsKey(ticket)) {
                return bagMap.remove(ticket);
            } else {
                throw new InvalidTicketException();
            }
        }
    }

    public boolean exist(Ticket ticket) {
        return bagMap.containsKey(ticket);
    }
}
