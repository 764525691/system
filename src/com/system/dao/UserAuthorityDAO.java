package com.system.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 邓益聪
 * Created by asus on 2017/12/19.
 */
public interface UserAuthorityDAO {


    /**
     * 根据员工工号查询权限
     * @param user_id
     * @return
     * @throws SQLException
     */

    Map<String, List<String>> getUserAuthority(String user_id) throws SQLException;

}
