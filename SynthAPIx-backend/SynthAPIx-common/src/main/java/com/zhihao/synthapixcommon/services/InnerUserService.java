package com.zhihao.synthapixcommon.services;

import com.zhihao.synthapixcommon.model.entity.User;

/**
 * 用户服务
 *
 * @author Zhihao Zhang
 */
public interface InnerUserService {
    User getInvokeUser(String accessKey);
}
