package com.system.ui;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 邓益聪
 * 2017.12.19
 * 自定义监听的测试类
 * Created by asus on 2017/12/20.
 */
public class MyListenerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void onMyEvent() throws Exception {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new MyListenerImpl());

        eventSource.exitSystem();
    }


}