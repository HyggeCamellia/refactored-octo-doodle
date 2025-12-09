package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * 数字货币资产表对象 assettable
 * 存储数字货币资产估值数据，包含币种、持仓量、当前估值、更新时间等
 *
 * @author [自动生成]
 * @date [当前日期]
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("assettable")
public class AssetTable extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 资产记录唯一标识，自增主键
     */
    @TableId(value = "asset_id", type = IdType.AUTO)
    private Long assetId;

    /**
     * 关联用户表 user_id
     */
    private Long userId;

    /**
     * 名称（如 Bitcoin）
     */
    private String name;

    /**
     * 简写（如比特币）
     */
    private String abbreviation;

    /**
     * 市值
     */
    private BigDecimal marketValue;

    /**
     * 价格（替代原current_price）
     */
    private BigDecimal price;

    /**
     * 流通供给量（如 19,956,521 BTC）
     */
    private String circulationSupply;

    /**
     * 交易量（24 小时）
     */
    private BigDecimal volume24h;

    /**
     * %1 小时（涨跌幅）
     */
    private BigDecimal change1h;

    /**
     * %24 小时（涨跌幅）
     */
    private BigDecimal change24h;

    /**
     * %7 天（涨跌幅）
     */
    private BigDecimal change7d;

}
