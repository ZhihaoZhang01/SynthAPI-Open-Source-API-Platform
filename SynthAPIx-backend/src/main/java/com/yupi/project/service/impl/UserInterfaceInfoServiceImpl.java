package com.yupi.project.service.impl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.service.UserInterfaceInfoService;
import com.zhihao.synthapixcommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author Zhihao Zhang
* @description 针对表【user_interface_info(user_interface_info)】的数据库操作Service实现
* @createDate 2024-04-17 23:43:50
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

        @Override
        public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
            if (userInterfaceInfo == null) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
            // 创建时，检查用户和接口是否存在
            if (add) {
                if (userInterfaceInfo.getUserId()<=0 || userInterfaceInfo.getInterfaceInfoId()<=0) {
                    throw new BusinessException(ErrorCode.PARAMS_ERROR);
                }
            }
            if (userInterfaceInfo.getLeftNum()<0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "left num can't less than 0");
            }
        }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId<=0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        updateWrapper.gt("LeftNum",0);
        updateWrapper.setSql("leftNum = leftNum - 1,totalNum = totalNum + 1");

        return this.update(updateWrapper);
    }

}




