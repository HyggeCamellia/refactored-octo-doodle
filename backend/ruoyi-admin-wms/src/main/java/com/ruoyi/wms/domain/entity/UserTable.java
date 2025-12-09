package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.io.Serial;

/**
 * 用户表对象 usertable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("usertable")
public class UserTable extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     * 用户唯一标识，自增主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    
    /**
     * 用户名，唯一
     */
    private String username;
    
    /**
     * 密码（加密存储）
     */
    private String password;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 用户状态（1 - 正常，0 - 禁用）
     */
    private Integer status;

}
