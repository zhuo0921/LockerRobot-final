package com.tw;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

//## primary locker robot
//        1. Given robot管理两个locker，两个locker都有可用容量; When robot存包; Then 成功存入第一个locker，返回票据
//        2. Given robot管理两个locker，第一个locker已经存满，第二个locker有可用容量; When robot存包; Then 成功存入第二个locker，返回票据
//        3. Given robot管理两个locker，两个locker都没有可用容量; When robot存包; Then 存包失败，提示储物柜已满
//        4. Given robot管理两个locker，拿到一张有效的票; When robot取包; Then 取包成功
//        5. Given robot管理两个locker，拿到一张伪造的票; When robot取包; Then 取包失败，提示非法票据
public class PrimaryLockerRobotTest {
    @Test
    void should_store_in_1st_locker_and_return_ticket_when_store_bag_given_robot_manage_two_lockers_and_both_have_capacity() {
        Locker firstLocker = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(asList(firstLocker, new Locker(15)));
        Bag myBag = new Bag();
        Ticket ticket = robot.store(myBag);

        assertNotNull(ticket);
        Bag bag = firstLocker.fetch(ticket);
        assertSame(myBag, bag);
    }
}
