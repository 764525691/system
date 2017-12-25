package com.system.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邓益聪
 * Created by asus on 2017/12/20.
 */
public class EventSource {
    private List<MyListener> listenerList = new ArrayList<>();

    public void addListener(MyListener listener){
        listenerList.add(listener);
    }

    public void exitSystem(){
        //嫌疑犯所干的事
        Event event = new Event("badthing");
        //让所有的监听者(警察)知道,我干了这件事
        for(MyListener li : listenerList){
            li.exitListener(event);
        }
    }
}
