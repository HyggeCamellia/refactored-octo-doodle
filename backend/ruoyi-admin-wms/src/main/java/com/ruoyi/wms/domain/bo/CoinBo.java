package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.ruoyi.wms.domain.entity.Coin;
import lombok.EqualsAndHashCode;

/**
 * 加密货币业务对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Coin.class, reverseConvertGenerate = false)
public class CoinBo extends BaseEntity {
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;
    
    @NotBlank(message = "货币名称不能为空")
    private String name;
    
    @NotBlank(message = "货币符号不能为空")
    private String symbol;
}