package com.yupi.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhihao.synthapixcommon.model.entity.InterfaceInfo;

/**
* @author Zhihao Zhang
* @description 针对表【interface_info(interface_info)】的数据库操作Service
* @createDate 2024-04-14 00:08:51
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
