package com.system.ui;

/**
 * @author 邓益聪
 * Created by asus on 2017/12/20.
 */
public class MyListenerImpl implements MyListener{

    @Override
    public void exitListener(Event event) {
        System.exit(0);
    }
}
