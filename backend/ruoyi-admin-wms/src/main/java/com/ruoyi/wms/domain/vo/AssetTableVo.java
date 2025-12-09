package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.AssetTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 数字货币资产表视图对象 assettable
 *
 * @author [自动生成]
 * @date [当前日期]
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AssetTable.class)
public class AssetTableVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 资产记录唯一标识，自增主键
     */
    @ExcelProperty(value = "资产记录唯一标识")
    private Long assetId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "用户ID")
    private Long userId;



    /**
     * 名称（如 Bitcoin）
     */
    @ExcelProperty(value = "资产名称")
    private String name;

    /**
     * 简写（如比特币）
     */
    @ExcelProperty(value = "资产简写")
    private String abbreviation;

    /**
     * 市值
     */
    @ExcelProperty(value = "市值")
    private BigDecimal marketValue;

    /**
     * 价格（替代原current_price）
     */
    @ExcelProperty(value = "价格")
    private BigDecimal price;

    /**
     * 流通供给量（如 19,956,521 BTC）
     */
    @ExcelProperty(value = "流通供给量")
    private String circulationSupply;

    /**
     * 交易量（24 小时）
     */
    @ExcelProperty(value = "24小时交易量")
    private BigDecimal volume24h;

    /**
     * %1 小时（涨跌幅）
     */
    @ExcelProperty(value = "1小时涨跌幅")
    private BigDecimal change1h;

    /**
     * %24 小时（涨跌幅）
     */
    @ExcelProperty(value = "24小时涨跌幅")
    private BigDecimal change24h;

    /**
     * %7 天（涨跌幅）
     */
    @ExcelProperty(value = "7天涨跌幅")
    private BigDecimal change7d;

}
