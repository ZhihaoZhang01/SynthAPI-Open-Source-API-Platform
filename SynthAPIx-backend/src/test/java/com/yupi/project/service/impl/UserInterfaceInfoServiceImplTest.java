package com.yupi.project.service.impl;


import com.zhihao.synthapixcommon.services.UserInterfaceInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author Zhihao Zhang
 * @description TODO
 * @date 2024-04-18 12:51 AM
 */
@SpringBootTest
public class UserInterfaceInfoServiceImplTest {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService = new UserInterfaceInfoServiceImpl();
    @Test
    public void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1L,1L);
        Assertions.assertTrue(b);
    }
}