package com.ruoyi.wms.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Dify API响应使用率信息模型
 *
 * @author ruoyi
 */
@Data
public class DifyUsageVo {
    /**
     * 提示令牌数
     */
    @JsonProperty("prompt_tokens")
    private int promptTokens;

    /**
     * 提示单价
     */
    @JsonProperty("prompt_unit_price")
    private String promptUnitPrice;

    /**
     * 提示价格单位
     */
    @JsonProperty("prompt_price_unit")
    private String promptPriceUnit;

    /**
     * 提示价格
     */
    @JsonProperty("prompt_price")
    private String promptPrice;

    /**
     * 完成令牌数
     */
    @JsonProperty("completion_tokens")
    private int completionTokens;

    /**
     * 完成单价
     */
    @JsonProperty("completion_unit_price")
    private String completionUnitPrice;

    /**
     * 完成价格单位
     */
    @JsonProperty("completion_price_unit")
    private String completionPriceUnit;

    /**
     * 完成价格
     */
    @JsonProperty("completion_price")
    private String completionPrice;

    /**
     * 总令牌数
     */
    @JsonProperty("total_tokens")
    private int totalTokens;

    /**
     * 总价格
     */
    @JsonProperty("total_price")
    private String totalPrice;

    /**
     * 货币类型
     */
    private String currency;

    /**
     * 延迟时间(秒)
     */
    private double latency;

    /**
     * 首令牌时间(秒)
     */
    @JsonProperty("time_to_first_token")
    private double timeToFirstToken;

    /**
     * 生成时间(秒)
     */
    @JsonProperty("time_to_generate")
    private double timeToGenerate;
}
