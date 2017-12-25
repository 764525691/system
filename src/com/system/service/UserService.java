package com.system.service;

import com.system.model.Attendance;
import com.system.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 * 2017.12.19-2017.12.20
 */
public interface UserService {
    /**
     * 用户登录
     * @param userid
     * @param password
     * @return
     */
    Map<String, Object> userLogin(String userid, String password) throws SQLException;

    /**
     * 获取员工信息
     * @param userid
     * @return
     */
    User getUser(String userid) throws SQLException;

    /**
     * 获取某个员工的考勤信息列表
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Attendance> getAttendance(String userid) throws SQLException;

    /**
     * 修改员工信息
     * @param user
     * @return boolean
     */
    boolean updateUser(User user) throws SQLException;

    /**
     * 手机验证码登录
     * @param tel
     * @param number
     * @param captcha
     * @return
     * @throws SQLException
     */
    Map<String, Object> phoneLogin(String tel, String number, String captcha) throws SQLException;

}
