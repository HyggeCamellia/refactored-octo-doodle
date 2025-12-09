package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.InvestmentSuggestionTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 投资建议表视图对象 investmentsuggestiontable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = InvestmentSuggestionTable.class)
public class InvestmentSuggestionTableVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 建议记录唯一标识，自增主键
     */
    @ExcelProperty(value = "建议记录唯一标识")
    private Integer suggestionId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 建议类型（买入、卖出、持仓等）
     */
    @ExcelProperty(value = "建议类型")
    private String suggestionType;

    /**
     * 建议内容详情
     */
    @ExcelProperty(value = "建议内容详情")
    private String content;

    /**
     * 生成时间
     */
    @ExcelProperty(value = "生成时间")
    private LocalDateTime generateTime;

    /**
     * 生效时间
     */
    @ExcelProperty(value = "生效时间")
    private LocalDateTime effectiveTime;

    /**
     * 名称（如 Bitcoin）
     */
    @ExcelProperty(value = "资产名称")
    private String name;

    /**
     * 简写（如 BTC）
     */
    @ExcelProperty(value = "资产简写")
    private String abbreviation;

    /**
     * 市值
     */
    @ExcelProperty(value = "市值")
    private BigDecimal markerValue;

    /**
     * 价格
     */
    @ExcelProperty(value = "价格")
    private BigDecimal price;

    /**
     * 流通供给量
     */
    @ExcelProperty(value = "流通供给量")
    private String circulationSupply;

    /**
     * 交易量（24 小时）
     */
    @ExcelProperty(value = "24小时交易量")
    private BigDecimal volume24h;

    /**
     * %1 小时
     */
    @ExcelProperty(value = "1小时涨跌幅")
    private BigDecimal change1h;

    /**
     * %24 小时
     */
    @ExcelProperty(value = "24小时涨跌幅")
    private BigDecimal change24h;

    /**
     * %7 天
     */
    @ExcelProperty(value = "7天涨跌幅")
    private BigDecimal change7d;

}
