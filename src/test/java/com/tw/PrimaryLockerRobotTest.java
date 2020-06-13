package com.tw;

//1. Given robot管理两个locker，两个locker都有可用容量; When robot存包; Then 成功存入第一个locker，返回票据
//        2. Given robot管理两个locker，第一个locker已经存满，第二个locker有可用容量; When robot存包; Then 成功存入第二个locker，返回票据
//        3. Given robot管理两个locker，两个locker都没有可用容量; When robot存包; Then 存包失败，提示储物柜已满
//        4. Given robot管理两个locker，拿到一张有效的票; When robot取包; Then 取包成功
//        5. Given robot管理两个locker，拿到一张伪造的票; When robot取包; Then 取包失败，提示非法票据

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrimaryLockerRobotTest {
    @Test
    void should_return_ticket_and_store_in_1st_locker_when_store_bag_given_both_lockers_have_capacity() {
        Locker firstLocker = new Locker(5);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker, new Locker(10)));
        Bag myBag = new Bag();
        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        Bag bag = firstLocker.fetch(ticket);
        assertSame(myBag, bag);
    }

    @Test
    void should_return_ticket_and_store_in_2nd_locker_when_store_bag_given_1st_locker_is_full_and_2nd_has_capacity() {
        Locker secondLocker = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(new Locker(0), secondLocker));
        Bag myBag = new Bag();
        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        assertSame(myBag, secondLocker.fetch(ticket));
    }
}
