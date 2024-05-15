package com.zhihao.synthapixcommon.services;


import com.zhihao.synthapixcommon.model.entity.InterfaceInfo;


/**
* @author Zhihao Zhang
* @description 针对表【interface_info(interface_info)】的数据库操作Service
* @createDate 2024-04-14 00:08:51
*/
public interface InnerInterfaceInfoService {
    InterfaceInfo getInterfaceInfo(String path, String method);
}
