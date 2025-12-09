package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.MessageTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 消息表视图对象 messagetable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = MessageTable.class)
public class MessageTableVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 消息唯一标识，自增主键
     */
    @ExcelProperty(value = "消息ID")
    private Integer msgId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 消息内容
     */
    @ExcelProperty(value = "消息内容")
    private String content;

    /**
     * 消息类型（系统通知、业务提醒等）
     */
    @ExcelProperty(value = "消息类型")
    private String type;

    /**
     * 已读状态（0 - 未读，1 - 已读）
     */
    @ExcelProperty(value = "已读状态")
    private Integer isRead;

    /**
     * 发送时间
     */
    @ExcelProperty(value = "发送时间")
    private LocalDateTime sendTime;

}
