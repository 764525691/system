package com.system.factory;

import com.system.dao.*;
import com.system.daoimpl.*;

/**
 * @author 徐文倩
 */
public class DAOFactory {
    public static UserDAO getUserDAOInstance(){
        return new UserDAOImpl();
    }
    public static AttendanceDAO getAttendanceDAOInstance(){
        return new AttendanceDAOImpl();
    }

    public static UserAuthorityDAO getUserAuthorityDAOInstance() {
        return new UserAuthorityDAOImpl();
    }
    public static ApplyDAO getApplyDAOInstance(){
        return new ApplyDAOImpl();
    }
    public static InformDAO getInformDAOInstance(){
        return  new InformDAOImpl();
    }
}
