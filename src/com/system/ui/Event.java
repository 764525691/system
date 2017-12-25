package com.system.ui;

/**
 * @author 邓益聪
 * Created by asus on 2017/12/20.
 */
public class Event {
    private Object source;

    public Event(Object source){
        this.source = source;
    }

    public Object getSource(){
        return this.source;
    }
}
