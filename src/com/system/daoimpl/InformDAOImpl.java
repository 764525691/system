package com.system.daoimpl;

import com.system.dao.InformDAO;
import com.system.model.Inform;
import com.system.utils.JDBCUtil;

import java.sql.SQLException;

/**
 * Created by asus on 2017/12/24.
 */
public class InformDAOImpl implements InformDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public int insertInform(Inform inform) throws SQLException {
        String sql = " INSERT INTO t_inform VALUES (?,?,?) ";
        Object[]params = {inform.getInformid(),inform.getInformtime(),inform.getInforminfo()};
        int n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }
}
