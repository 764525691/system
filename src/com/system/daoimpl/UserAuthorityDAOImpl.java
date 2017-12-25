package com.system.daoimpl;

import com.system.dao.UserAuthorityDAO;
import com.system.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author 邓益聪
 * Created by asus on 2017/12/19.
 */
public class UserAuthorityDAOImpl implements UserAuthorityDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();


    @Override
    public Map<String, List<String>> getUserAuthority(String user_id) throws SQLException {
        Map<String, List<String>> permissionMap = new HashMap<>();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`groupname`,t2.`itemname` FROM t_authority_group t1\n" +
                "INNER JOIN t_authority_item t2\n" +
                "ON t1.`groupid` = t2.`groupid`\n" +
                "INNER JOIN t_authority t3\n" +
                "ON t2.`itemid` = t3.`itemid`\n" +
                "WHERE t3.`userid`= ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user_id);
        ResultSet rs = ps.executeQuery();
        List<String> itemList1 = new ArrayList<>();
        List<String> itemList2 = new ArrayList<>();
        List<String> itemList3 = new ArrayList<>();
        List<String> itemList4 = new ArrayList<>();
        List<String> itemList5 = new ArrayList<>();
        List<String> itemList6 = new ArrayList<>();
        List<String> itemList7 = new ArrayList<>();
        List<String> itemList8 = new ArrayList<>();

        Set<String> nameSet = new HashSet<>();
        while (rs.next()) {
            String groupname = rs.getString("groupname");
            nameSet.add(groupname);
            String itemname = rs.getString("itemname");
            if (itemname.contains("考勤")) {
                itemList1.add(itemname);
            }
            if (itemname.contains("工资")) {
                itemList2.add(itemname);
            }
            if (itemname.contains("员工")) {
                itemList3.add(itemname);
            }
            if (itemname.contains("通知")) {
                itemList4.add(itemname);
            }
            if (itemname.contains("权限")) {
                itemList5.add(itemname);
            }
            if (itemname.contains("部门")) {
                itemList6.add(itemname);
            }
            if (itemname.contains("个人")) {
                itemList7.add(itemname);
            }
            if (itemname.contains("申请")) {
                itemList8.add(itemname);
            }
        }
        List<String>[] lists = new List[]{itemList1, itemList2, itemList3, itemList4, itemList5,
                itemList6, itemList7, itemList8};
        for (int i = 0, j = 0; i < lists.length; i++) {
            if (lists[i].size() != 0) {
                String name = nameSet.toArray()[j].toString();
                permissionMap.put(name, lists[i]);
                j++;
            } else {
                continue;
            }
        }
        return permissionMap;
    }
    }

