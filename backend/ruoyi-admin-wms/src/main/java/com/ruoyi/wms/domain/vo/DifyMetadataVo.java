package com.ruoyi.wms.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Dify API响应元数据模型
 *
 * @author ruoyi
 */
@Data
public class DifyMetadataVo {
    /**
     * 注释回复
     */
    @JsonProperty("annotation_reply")
    private Object annotationReply;

    /**
     * 检索资源列表
     */
    @JsonProperty("retriever_resources")
    private List<Object> retrieverResources;

    /**
     * 使用率信息
     */
    private DifyUsageVo usage;
}
