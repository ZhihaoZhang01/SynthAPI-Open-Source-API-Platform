package com.zhihao.synthapixcommon.services;

import com.zhihao.synthapixcommon.model.entity.UserInterfaceInfo;

/**
* @author Zhihao Zhang
*/
public interface InnerUserInterfaceInfoService {
    //3. 接口调用次数+1invokeCount（）
    boolean invokeCount(long InterfaceInfoId, long userId);
}
