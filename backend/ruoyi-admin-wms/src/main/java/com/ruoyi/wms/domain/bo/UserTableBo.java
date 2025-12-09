package com.ruoyi.wms.domain.bo;

import com.ruoyi.wms.domain.entity.UserTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

/**
 * 用户表业务对象 - 学生学习版
 * 用于用户表的增删改查操作
 *
 * @author student
 * @date 2024-08-01
 */
@Data
@AutoMapper(target = UserTable.class, reverseConvertGenerate = false)
public class UserTableBo {
    /**
     * 用户唯一标识，自增主键
     */
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