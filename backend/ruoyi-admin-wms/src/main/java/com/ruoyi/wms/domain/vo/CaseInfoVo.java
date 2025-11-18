package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import com.ruoyi.wms.domain.entity.CaseInfo;

import java.io.Serial;
import java.io.Serializable;

/**
 * 教学案例信息视图对象 case_info
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CaseInfo.class)
public class CaseInfoVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 案例编码
     */
    @ExcelProperty(value = "案例编码")
    private String caseCode;

    /**
     * 单位名称
     */
    @ExcelProperty(value = "单位名称")
    private String caseName;

    /**
     * 承办单位
     */
    @ExcelProperty(value = "承办单位")
    private String undertakingUnit;

    /**
     * 案件类型（以AULX_开头的代码）
     */
    @ExcelProperty(value = "案件类型")
    private String caseType;

    /**
     * 案件来源（以AULX_开头的代码）
     */
    @ExcelProperty(value = "案件来源")
    private String caseSource;

    /**
     * 描述或备注
     */
    @ExcelProperty(value = "描述或备注")
    private String caseRemark;

    /**
     * 过期/激活/删除等标志
     */
    @ExcelProperty(value = "状态标志")
    private Integer unitStatus;
}