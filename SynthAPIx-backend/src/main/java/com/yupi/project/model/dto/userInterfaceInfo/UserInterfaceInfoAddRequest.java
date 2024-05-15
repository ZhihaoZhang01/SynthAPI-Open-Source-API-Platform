package com.yupi.project.model.dto.userInterfaceInfo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serializable;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

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

