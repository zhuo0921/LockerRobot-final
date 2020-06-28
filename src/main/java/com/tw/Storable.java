package com.tw;

public interface Storable {
    Ticket save(Bag bag);

    Bag pickUp(Ticket ticket);

    boolean isFull();
}
