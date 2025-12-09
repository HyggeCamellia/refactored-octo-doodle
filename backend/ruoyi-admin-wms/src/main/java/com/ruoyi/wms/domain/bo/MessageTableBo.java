package com.ruoyi.wms.domain.bo;

import com.ruoyi.wms.domain.entity.MessageTable;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 消息表业务对象 - 学生学习版
 * 用于消息的增删改查操作
 *
 * @author student
 * @date 2024-08-01
 */
@Data
@AutoMapper(target = MessageTable.class, reverseConvertGenerate = false)
public class MessageTableBo {
    /**
     * 消息ID（自增主键，修改和删除时需要）
     */
    private Integer msgId;
    
    /**
     * 用户ID（关联用户表）
     */
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
    
    /**
     * 消息内容（支持模糊查询）
     */
    private String content;
    
    /**
     * 消息类型（如：系统通知、业务提醒等）
     */
    @NotBlank(message = "消息类型不能为空")
    @Size(max = 20, message = "消息类型长度不能超过20个字符")
    private String type;
    
    /**
     * 已读状态（0：未读，1：已读）
     */
    @NotNull(message = "已读状态不能为空")
    private Integer isRead;
    
    /**
     * 发送时间
     */
    @NotNull(message = "发送时间不能为空")
    private LocalDateTime sendTime;
}
