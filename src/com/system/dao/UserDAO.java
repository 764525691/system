package com.system.dao;

import com.system.model.Apply;
import com.system.model.Attendance;
import com.system.model.User;
import com.system.model.User_login;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 邓益聪
 * UserDAO的接口创建
 * Created by asus on 2017/12/19.
 */
public interface UserDAO {


    /**
     * 根据工号查询信息
     * @param user_id
     * @return
     * @throws SQLException
     */
    User get(String user_id) throws SQLException;


    /**
     * 登录
     * @param account
     * @return
     * @throws SQLException
     */
    User_login getLogin(String account)throws SQLException;

    /**
     * 手机验证码登录
     * @param tel
     * @return
     * @throws SQLException
     */
    User getUser(String tel) throws SQLException;


    /**
     * 更新员工信息
     * @param user
     * @return
     * @throws SQLException
     */
    int update(User user) throws SQLException;
    /**
     * 获取所有员工信息
     * @return
     * @throws SQLException
     */
    List<User> getAll() throws SQLException;

    /**
     * 员工签到新增考勤信息
     * @param attendance
     * @return
     * @throws SQLException
     */
    int insert(Attendance attendance) throws SQLException;

}
