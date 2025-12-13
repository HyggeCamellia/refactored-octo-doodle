package com.ruoyi.wms.mapper;

import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;
import com.ruoyi.wms.domain.entity.WmsCombinedEntity;
import com.ruoyi.wms.domain.vo.WmsCombinedVo;

/**
 * WMS系统统一Mapper接口
 * 整合了资产、投资建议、消息、持仓分析、报告和用户的所有CRUD功能
 *
 * @author zcc
 * @date 2024-08-01
 */
public interface WmsCombinedMapper extends BaseMapperPlus<WmsCombinedEntity, WmsCombinedVo> {

}
