package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import com.ruoyi.wms.domain.entity.CaseInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 案例信息业务对象 case_info（精简版）
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CaseInfo.class)
public class CaseInfoBo extends BaseEntity {

    /**
     * 案例编码（主键）
     */
    @NotBlank(message = "案例编码不能为空", groups = {AddGroup.class, EditGroup.class})
    private String caseCode;

    /**
     * 单位名称（支持模糊查询）
     */
    @NotBlank(message = "单位名称不能为空", groups = {AddGroup.class})
    private String caseName;

    /**
     * 承办单位（支持模糊查询）
     */
    @NotBlank(message = "承办单位不能为空", groups = {AddGroup.class})
    private String undertakingUnit;

    /**
     * 案件类型（以AULX_开头的代码，支持模糊查询）
     */
    @NotBlank(message = "案件类型不能为空", groups = {AddGroup.class})
    private String caseType;

    /**
     * 案件来源（以AULX_开头的代码，支持模糊查询）
     */
    @NotBlank(message = "案件来源不能为空", groups = {AddGroup.class})
    private String caseSource;

    /**
     * 描述或备注
     */
    private String caseRemark;

    /**
     * 状态标志（过期/激活/删除等）
     */
    @NotNull(message = "状态标志不能为空", groups = {AddGroup.class, EditGroup.class})
    private Integer unitStatus;

    // 可选：用于前端查询的额外字段不需要再单独定义，
    // Service 的 buildQueryWrapper(bo) 会对上述字符串字段进行 like 模糊匹配，
    // 对 unitStatus 等数值字段进行 eq 精准匹配。
}