package com.system.daoimpl;

import com.system.dao.InformDAO;
import com.system.model.Inform;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 通知类DAO的实现层
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

    @Override
    public List<Inform> getAll() throws SQLException {
        String sql = " SELECT * FROM t_inform  ";
        List<Object>list = jdbcUtil.excuteQuery(sql,null);
        List<Inform> informs = new ArrayList<>();
        for (Object object :list){
            Map<String, Object> map = (Map<String, Object>) object;
            Inform inform = new Inform((Integer)map.get("informid"),(Date)map.get("informtime"),map.get("informinfo").toString());
            inform.setInformid((Integer)map.get("informid"));
            informs.add(inform);
        }
        return informs;
    }
}
