package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.io.Serial;

/**
 * 持仓分析表对象 positionanalysistable
 *
 * @author student
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("positionanalysistable")
public class PositionAnalysisTable extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     * 分析记录唯一标识，自增主键
     */
    @TableId(value = "analysis_id", type = IdType.AUTO)
    private Integer analysisId;
    
    /**
     * 关联用户表 user_id
     */
    private Integer userId;
    
    /**
     * 分析类型（持仓分布、收益归因等）
     */
    private String analysisType;
    
    /**
     * 分析结果详情
     */
    private String analysisResult;
    
    /**
     * 生成时间
     */
    private LocalDateTime generateTime;

}