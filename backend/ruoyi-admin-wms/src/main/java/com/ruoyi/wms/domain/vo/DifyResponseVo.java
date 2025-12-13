package com.ruoyi.wms.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Dify API响应数据模型
 *
 * @author ruoyi
 */
@Data
public class DifyResponseVo {
    /**
     * 事件类型
     */
    private String event;

    /**
     * 任务ID
     */
    @JsonProperty("task_id")
    private String taskId;

    /**
     * 消息ID
     */
    private String id;

    /**
     * 消息ID(同id)
     */
    @JsonProperty("message_id")
    private String messageId;

    /**
     * 会话ID
     */
    @JsonProperty("conversation_id")
    private String conversationId;

    /**
     * 模式
     */
    private String mode;

    /**
     * 消息内容
     */
    private String answer;

    /**
     * 元数据
     */
    private DifyMetadataVo metadata;

    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private Date createdAt;
}
