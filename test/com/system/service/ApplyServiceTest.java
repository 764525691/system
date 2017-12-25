package com.system.service;

import com.system.factory.ServiceFactory;
import com.system.model.Apply;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 邓益聪
 * ApplyService的测试类
 * Created by asus on 2017/12/24.
 */
public class ApplyServiceTest {
    private ApplyService applyService;

    @Before
    public void setUp() throws Exception {
        applyService = ServiceFactory.getApplyServiceInstance();
    }

    @Test
    public void update() throws Exception {
        Apply apply = applyService.getApply("101003");
        apply.setExamination("通过");
        boolean flag = applyService.update(apply);
        System.out.println(apply);
        assertEquals(true,flag);

    }

}