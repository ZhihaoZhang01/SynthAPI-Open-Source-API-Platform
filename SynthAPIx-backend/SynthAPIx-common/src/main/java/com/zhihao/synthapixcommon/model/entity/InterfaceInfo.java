package com.zhihao.synthapixcommon.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * interface_info
 * @TableName interface_info
 */
@TableName(value ="interface_info")
@Data
public class InterfaceInfo implements Serializable {
    /**
     * primary key
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * interface_url
     */
    private String url;

    /**
     * request_reader
     */
    private String requestHeader;

    /**
     * response_header
     */
    private String responseHeader;

    /**
     * status (0-close, 1-open)
     */
    private Integer status;

    /**
     * request method
     */
    private String method;

    /**
     * create user_id
     */
    private Long userId;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * update_time
     */
    private Date updateTime;

    /**
     * is_delete(0-not_deleted, 1- is_deleted)
     */
    private Integer isDelete;

    /**
     *
     */
    private String requestParams;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}