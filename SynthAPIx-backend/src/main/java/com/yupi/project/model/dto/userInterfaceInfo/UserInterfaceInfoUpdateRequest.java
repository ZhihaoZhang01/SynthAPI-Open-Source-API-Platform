package com.yupi.project.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @TableName product
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    /**
     * primary key
     */
    private Long id;


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

    private static final long serialVersionUID = 1L;
}
