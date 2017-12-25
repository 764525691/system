package com.system.dao;

import com.system.factory.DAOFactory;
import com.system.model.Apply;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 邓益聪
 * ApplyDAO层的测试
 * Created by asus on 2017/12/24.
 */
public class ApplyDAOTest {
    private ApplyDAO applyDAO;

    @Before
    public void setUp() throws Exception {
        applyDAO = DAOFactory.getApplyDAOInstance();
    }

    @Test
    public void getApply() throws Exception {
        Apply apply = applyDAO.getApply("101005");
        System.out.println(apply);
    }

    @Test
    public void getAllApply() throws Exception {
        List<Apply> applyList = applyDAO.getAllApply();
        System.out.println(applyList);
    }

    @Test
    public void queryFilter() throws Exception {
        String condition = "出差";
        System.out.println(applyDAO.queryFilter(condition));
    }

    @Test
    public void queryLike() throws Exception {
        System.out.println(applyDAO.queryLike("出差"));
    }

}