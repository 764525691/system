package com.system.serviceimpl;

import com.system.dao.AttendanceDAO;
import com.system.dao.UserAuthorityDAO;
import com.system.dao.UserDAO;
import com.system.factory.DAOFactory;
import com.system.model.Attendance;
import com.system.model.User;
import com.system.model.User_login;
import com.system.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 * 2017.12.20-2017.12.21
 *修改信息的实现
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = DAOFactory.getUserDAOInstance();
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceDAOInstance();
    private UserAuthorityDAO userAuthorityDAO = DAOFactory.getUserAuthorityDAOInstance();

    @Override
    public Map<String, Object> userLogin(String userid, String password) {
        Map<String, Object> map = new HashMap<>();
        User_login user_login = null;
        User user = null;
        try {
            user_login = userDAO.getLogin(userid);
            user = userDAO.get(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user_login != null) {
            if (user_login.getPassword().equals(password)) {
                map.put("info", "登录成功");
                map.put("user", user);
                Map<String, List<String>> userAuthorityMap = null;
                try {
                    userAuthorityMap = userAuthorityDAO.getUserAuthority(userid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                map.put("userAuthority", userAuthorityMap);
            } else {
                map.put("info", "密码错误");
            }
        } else {
            map.put("info", "账号不存在");
        }
        return map;
    }

    @Override
    public User getUser(String userid) {
        User user = null;
        try {
            user = userDAO.get(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Attendance> getAttendance(String userid) throws SQLException {
        List<Attendance> list = null;
        list = attendanceDAO.getAttendance(userid);
        return list;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        int n = 0;
        try {
            n = userDAO.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(n == 1){
            flag = true;
        }
        return flag;
    }

    @Override
    public Map<String, Object> phoneLogin(String tel, String number, String captcha) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        User user = null;

        try {
            user = userDAO.getUser(tel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            if (number.equals(captcha)) {
                map.put("info", "登录成功");
                map.put("user", user);
                Map<String, List<String>> userAuthorityMap = null;
                try {
                    userAuthorityMap = userAuthorityDAO.getUserAuthority(user.getUserid());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                map.put("userAuthority", userAuthorityMap);
            } else {
                map.put("info", "验证码错误");
            }
        } else {
            map.put("info", "账号不存在");
        }
        return map;
    }
    }

