package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serial;

/**
 * 投资建议表对象 investmentsuggestiontable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("investmentsuggestiontable")
public class InvestmentSuggestionTable extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     * 建议记录唯一标识，自增主键
     */
    @TableId(value = "suggestion_id", type = IdType.AUTO)
    private Integer suggestionId;
    /**
     * 关联用户表 user_id
     */
    private Integer userId;
    /**
     * 建议类型（买入、卖出、持仓等）
     */
    private String suggestionType;
    /**
     * 建议内容详情
     */
    private String content;
    /**
     * 生成时间
     */
    private LocalDateTime generateTime;
    /**
     * 生效时间
     */
    private LocalDateTime effectiveTime;
    /**
     * 名称（如 Bitcoin）
     */
    private String name;
    /**
     * 简写（如 BTC）
     */
    private String abbreviation;
    /**
     * 市值
     */
    private BigDecimal markerValue;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 流通供给量
     */
    private String circulationSupply;
    /**
     * 交易量（24 小时）
     */
    private BigDecimal volume24h;
    /**
     * %1 小时
     */
    private BigDecimal change1h;
    /**
     * %24 小时
     */
    private BigDecimal change24h;
    /**
     * %7 天
     */
    private BigDecimal change7d;

}