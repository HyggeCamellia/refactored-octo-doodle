package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 教学案例信息对象 case_info
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("case_info")
public class CaseInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 案例编码
     */
    @TableId(value = "case_code")
    private String caseCode;

    /**
     * 单位名称
     */
    private String caseName;

    /**
     * 承办单位
     */
    private String undertakingUnit;

    /**
     * 案件类型（以AULX_开头的代码）
     */
    private String caseType;

    /**
     * 案件来源（以AULX_开头的代码）
     */
    private String caseSource;

    /**
     * 描述或备注
     */
    private String caseRemark;

    /**
     * 过期/激活/删除等标志
     */
    private Integer unitStatus;
}