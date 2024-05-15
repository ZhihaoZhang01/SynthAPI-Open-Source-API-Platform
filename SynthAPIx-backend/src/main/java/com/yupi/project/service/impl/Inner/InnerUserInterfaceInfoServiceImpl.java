package com.yupi.project.service.impl.Inner;
import com.yupi.project.service.impl.UserInterfaceInfoServiceImpl;
import com.zhihao.synthapixcommon.services.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author Zhihao Zhang
 * @description TODO
 * @date 2024-05-01 12:08 AM
 */

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoServiceImpl userInterfaceInfoService;
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId,userId);
    }
}
