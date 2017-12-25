package com.system.factory;

import com.system.model.Apply;
import com.system.model.Inform;
import com.system.service.ApplyService;
import com.system.service.InformService;
import com.system.service.UserService;
import com.system.serviceimpl.ApplyServiceImpl;
import com.system.serviceimpl.InformServiceImpl;
import com.system.serviceimpl.UserServiceImpl;

/**
 * @author 邓益聪
 */
public class ServiceFactory {
    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }
    public static ApplyService getApplyServiceInstance(){
        return new ApplyServiceImpl();
    }
    public static InformService getInformServiceInstance(){
        return  new InformServiceImpl();
    }
}
