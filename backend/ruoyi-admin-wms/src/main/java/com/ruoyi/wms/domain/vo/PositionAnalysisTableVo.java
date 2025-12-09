package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.PositionAnalysisTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 持仓分析表视图对象 positionanalysistable
 *
 * @author student
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = PositionAnalysisTable.class)
public class PositionAnalysisTableVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分析记录唯一标识，自增主键
     */
    @ExcelProperty(value = "分析ID")
    private Integer analysisId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 分析类型（持仓分布、收益归因等）
     */
    @ExcelProperty(value = "分析类型")
    private String analysisType;

    /**
     * 分析结果详情
     */
    @ExcelProperty(value = "分析结果详情")
    private String analysisResult;

    /**
     * 生成时间
     */
    @ExcelProperty(value = "生成时间")
    private LocalDateTime generateTime;

}