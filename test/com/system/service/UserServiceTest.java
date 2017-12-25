package com.system.service;

import com.system.factory.ServiceFactory;
import com.system.model.Attendance;
import com.system.model.User;
import com.system.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author 徐文倩
 * 2017.12.20-2017.12.21
 * UserService的测试类
 */
public class UserServiceTest {
    private UserService userService;
    @Before
    public void setUp() throws Exception {
        userService = ServiceFactory.getUserServiceInstance();
    }

    @Test
    public void userLogin() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
        User user = userService.getUser("101001");
        System.out.println(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = userService.getUser("101008");
        user.setTel("13951011567");
        boolean flag = userService.updateUser(user);
        assertEquals(true,flag);
    }

    @Test
    public void getAttendance() throws Exception{
        List<Attendance> list = userService.getAttendance("101001");
        list.forEach(attendance -> System.out.println(attendance));
    }

}