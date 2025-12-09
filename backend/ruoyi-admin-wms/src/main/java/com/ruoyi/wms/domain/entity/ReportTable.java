package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.io.Serial;

/**
 * 报告表对象 reporttable
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("reporttable")
public class ReportTable extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     * 报告唯一标识，自增主键
     */
    @TableId(value = "report_id", type = IdType.AUTO)
    private Integer reportId;
    
    /**
     * 关联用户表 user_id
     */
    private Integer userId;
    
    /**
     * 报告类型（资产报告、行为报告等）
     */
    private String reportType;
    
    /**
     * 报告内容
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
