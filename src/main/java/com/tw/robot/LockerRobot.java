package com.tw.robot;

import com.tw.Bag;
import com.tw.Ticket;

public interface LockerRobot {

    Bag pickUpBy(Ticket ticket);
    Ticket save(Bag ticket);
}
