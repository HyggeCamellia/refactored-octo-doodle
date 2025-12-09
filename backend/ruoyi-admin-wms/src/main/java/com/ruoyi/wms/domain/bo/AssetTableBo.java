package com.ruoyi.wms.domain.bo;

import com.ruoyi.wms.domain.entity.AssetTable;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import io.github.linpeilie.annotations.AutoMapper;

import java.math.BigDecimal;

/**
 * 数字货币资产估值业务对象 assettable
 *
 * @author zcc
 * @date 2024-08-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AssetTable.class, reverseConvertGenerate = false)
public class AssetTableBo extends BaseEntity {

    /**
     * 主键id
     */
    @NotNull(message = "主键id不能为空", groups = { EditGroup.class })
    private Long assetId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 名称
     */
    private String name;

    /**
     * 简称
     */
    private String abbreviation;

    /**
     * 流通量
     */
    private String circulationSupply;

    /**
     * 市值
     */
    private BigDecimal marketValue;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 24小时交易量
     */
    private BigDecimal volume24h;

    /**
     * 1小时涨跌幅
     */
    private BigDecimal change1h;

    /**
     * 24小时涨跌幅
     */
    private BigDecimal change24h;

    /**
     * 7天涨跌幅
     */
    private BigDecimal change7d;
}