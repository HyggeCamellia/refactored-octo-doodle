package com.ruoyi.wms.domain.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 持仓分析表业务对象 - 学生学习版
 * 用于持仓分析记录的增删改查操作
 * 简化实现，适合学生学习和测试
 *
 * @author student
 * @date 2024-08-01
 */
@Data
public class PositionAnalysisTableBo {
    /**
     * 分析记录唯一标识，自增主键（修改和删除时必须提供）
     */
    private Integer analysisId;
    
    /**
     * 关联用户表 user_id（必填）
     */
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
    
    /**
     * 分析类型（持仓分布、收益归因等）
     */
    @NotBlank(message = "分析类型不能为空")
    @Size(max = 50, message = "分析类型长度不能超过50个字符")
    private String analysisType;
    
    /**
     * 分析结果详情（支持模糊查询）
     */
    private String analysisResult;
    
    /**
     * 生成时间
     */
    private LocalDateTime generateTime;
}