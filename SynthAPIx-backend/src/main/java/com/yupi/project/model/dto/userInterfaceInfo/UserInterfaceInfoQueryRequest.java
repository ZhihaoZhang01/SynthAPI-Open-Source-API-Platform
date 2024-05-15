package com.yupi.project.model.dto.userInterfaceInfo;

import com.yupi.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * primary key
     */
    private Long id;

    /**
     * User id
     */
    private Long userId;

    /**
     * interface id
     */
    private Long interfaceInfoId;

    /**
     * total call nums
     */
    private Integer totalNum;

    /**
     * left call nums
     */
    private Integer leftNum;

    /**
     * 0-inactive, 1-active
     */
    private Integer status;

}
