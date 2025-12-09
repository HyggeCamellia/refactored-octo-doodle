package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 投资建议表业务对象 investmentsuggestiontable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
public class InvestmentSuggestionTableBo {
    /**
     * 建议记录唯一标识，自增主键
     */
    private Integer suggestionId;
    /**
     * 关联用户表 user_id
     */
    @NotNull(message = "关联用户ID不能为空")
    private Integer userId;
    /**
     * 建议类型（买入、卖出、持仓等）
     */
    @NotBlank(message = "建议类型不能为空")
    @Size(max = 50, message = "建议类型长度不能超过50个字符")
    private String suggestionType;
    /**
     * 建议内容详情
     */
    @NotBlank(message = "建议内容详情不能为空")
    private String content;
    /**
     * 生成时间
     */
    @NotNull(message = "生成时间不能为空")
    private LocalDateTime generateTime;
    /**
     * 生效时间
     */
    @NotNull(message = "生效时间不能为空")
    private LocalDateTime effectiveTime;
    /**
     * 名称（如 Bitcoin）
     */
    @NotBlank(message = "名称不能为空")
    @Size(max = 100, message = "名称长度不能超过100个字符")
    private String name;
    /**
     * 简写（如 BTC）
     */
    @NotBlank(message = "简写不能为空")
    @Size(max = 20, message = "简写长度不能超过20个字符")
    private String abbreviation;
    /**
     * 市值
     */
    @NotNull(message = "市值不能为空")
    private BigDecimal markerValue;
    /**
     * 价格
     */
    @NotNull(message = "价格不能为空")
    private BigDecimal price;
    /**
     * 流通供给量
     */
    @NotBlank(message = "流通供给量不能为空")
    @Size(max = 50, message = "流通供给量长度不能超过50个字符")
    private String circulationSupply;
    /**
     * 交易量（24 小时）
     */
    @NotNull(message = "24小时交易量不能为空")
    private BigDecimal volume24h;
    /**
     * %1 小时
     */
    @NotNull(message = "1小时涨跌幅不能为空")
    private BigDecimal change1h;
    /**
     * %24 小时
     */
    @NotNull(message = "24小时涨跌幅不能为空")
    private BigDecimal change24h;
    /**
     * %7 天
     */
    @NotNull(message = "7天涨跌幅不能为空")
    private BigDecimal change7d;
}
