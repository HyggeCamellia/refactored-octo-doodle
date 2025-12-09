package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.io.Serial;

/**
 * 消息表对象 messagetable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("messagetable")
public class MessageTable extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     * 消息唯一标识，自增主键
     */
    @TableId(value = "msg_id", type = IdType.AUTO)
    private Integer msgId;
    
    /**
     * 关联用户表 user_id
     */
    private Integer userId;
    
    /**
     * 消息内容
     */
    private String content;
    
    /**
     * 消息类型（系统通知、业务提醒等）
     */
    private String type;
    
    /**
     * 已读状态（0 - 未读，1 - 已读）
     */
    private Integer isRead;
    
    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

}
