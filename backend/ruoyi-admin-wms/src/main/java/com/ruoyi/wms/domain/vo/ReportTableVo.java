package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.ReportTable;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 报告表视图对象 reporttable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ReportTable.class)
public class ReportTableVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 报告唯一标识，自增主键
     */
    @ExcelProperty(value = "报告ID")
    private Integer reportId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 报告类型（资产报告、行为报告等）
     */
    @ExcelProperty(value = "报告类型")
    private String reportType;

    /**
     * 报告内容
     */
    @ExcelProperty(value = "报告内容")
    private String content;

    /**
     * 审核状态（0 - 待审核，1 - 通过，2 - 拒绝）
     */
    @ExcelProperty(value = "审核状态")
    private Integer auditStatus;

    /**
     * 提交时间
     */
    @ExcelProperty(value = "提交时间")
    private LocalDateTime submitTime;

    /**
     * 审核时间
     */
    @ExcelProperty(value = "审核时间")
    private LocalDateTime auditTime;

    /**
     * 审核人
     */
    @ExcelProperty(value = "审核人")
    private String auditor;

}
