package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.UserTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 用户表视图对象 usertable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = UserTable.class)
public class UserTableVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识，自增主键
     */
    @ExcelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 用户名，唯一
     */
    @ExcelProperty(value = "用户名")
    private String username;

    /**
     * 密码（加密存储）
     * 注意：实际应用中密码不应在视图对象中暴露
     */
    @ExcelProperty(value = "密码")
    private String password;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 用户状态（1 - 正常，0 - 禁用）
     */
    @ExcelProperty(value = "用户状态")
    private Integer status;

}
