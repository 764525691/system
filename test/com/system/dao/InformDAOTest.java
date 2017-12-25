package com.system.dao;

import com.system.factory.DAOFactory;
import com.system.model.Inform;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 邓益聪
 * InformDAO层的测试类
 * Created by asus on 2017/12/24.
 */
public class InformDAOTest {
    private InformDAO informDAO;

    @Before
    public void setUp() throws Exception {
        informDAO = DAOFactory.getInformDAOInstance();
    }

    @Test
    public void insertInform() throws Exception {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        Inform inform = new Inform(12,currentDate,"明天放假");
        informDAO.insertInform(inform);
    }

    @Test
    public void getAll() throws Exception {
        List<Inform> informList = informDAO.getAll();
        System.out.println(informList);
    }

}