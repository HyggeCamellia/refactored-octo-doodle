package com.ruoyi.wms.domain.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 报告表业务对象 - 学生学习版
 * 用于报告表的增删改查操作
 *
 * @author student
 * @date 2024-08-01
 */
@Data
public class ReportTableBo {
    /**
     * 报告ID（自增主键，修改和删除时需要）
     */
    private Integer reportId;
    
    /**
     * 用户ID（关联用户表）
     */
    private Integer userId;
    
    /**
     * 报告类型（如：资产报告、行为报告等）
     */
    private String reportType;
    
    /**
     * 报告内容（支持模糊查询）
     */
    private String content;
    
    /**
     * 审核状态（0 - 待审核，1 - 通过，2 - 拒绝）
     */
    private Integer auditStatus;
    
    /**
     * 提交时间
     */
    private LocalDateTime submitTime;
    
    /**
     * 审核时间
     */
    private LocalDateTime auditTime;
    
    /**
     * 审核人
     */
    private String auditor;
}
