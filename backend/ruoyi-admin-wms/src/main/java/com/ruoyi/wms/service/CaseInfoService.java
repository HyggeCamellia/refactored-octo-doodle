package com.ruoyi.wms.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.CaseInfoBo;
import com.ruoyi.wms.domain.entity.CaseInfo;
import com.ruoyi.wms.domain.vo.CaseInfoVo;
import com.ruoyi.wms.mapper.CaseInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 教学案例信息 Service 业务层处理
 */
@RequiredArgsConstructor
@Service
public class CaseInfoService {

    private final CaseInfoMapper caseInfoMapper;

    /**
     * 主键精准查询（case_code）
     */
    public CaseInfoVo queryByCode(String caseCode) {
        return caseInfoMapper.selectVoById(caseCode);
    }

    /**
     * 分页查询（支持模糊查询）
     */
    public TableDataInfo<CaseInfoVo> queryPageList(CaseInfoBo bo, PageQuery pageQuery) {
        CaseInfo filter = MapstructUtils.convert(bo, CaseInfo.class);
        LambdaQueryWrapper<CaseInfo> lqw = buildQueryWrapper(filter);
        Page<CaseInfoVo> result = caseInfoMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 列表查询（支持模糊查询）
     */
    public List<CaseInfoVo> queryList(CaseInfoBo bo) {
        CaseInfo filter = MapstructUtils.convert(bo, CaseInfo.class);
        LambdaQueryWrapper<CaseInfo> lqw = buildQueryWrapper(filter);
        return caseInfoMapper.selectVoList(lqw);
    }

    /**
     * 新增
     */
    public void insert(CaseInfoBo bo) {
        CaseInfo entity = MapstructUtils.convert(bo, CaseInfo.class);
        caseInfoMapper.insert(entity);
    }

    /**
     * 修改（按主键 case_code 更新）
     */
    public void update(CaseInfoBo bo) {
        CaseInfo entity = MapstructUtils.convert(bo, CaseInfo.class);
        caseInfoMapper.updateById(entity);
    }

    /**
     * 根据主键删除（单个）
     */
    public void deleteByCode(String caseCode) {
        caseInfoMapper.deleteById(caseCode);
    }

    /**
     * 根据主键批量删除
     */
    public void deleteByCodes(Collection<String> caseCodes) {
        caseInfoMapper.deleteBatchIds(caseCodes);
    }

    /**
     * 构建查询条件（支持模糊/精准）
     */
    private LambdaQueryWrapper<CaseInfo> buildQueryWrapper(CaseInfo filter) {
        LambdaQueryWrapper<CaseInfo> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(StrUtil.isNotBlank(filter.getCaseCode()), CaseInfo::getCaseCode, filter.getCaseCode());
        // 模糊查询：单位名称、承办单位、案件类型、案件来源、备注
        lqw.like(StrUtil.isNotBlank(filter.getCaseName()), CaseInfo::getCaseName, filter.getCaseName());
        lqw.like(StrUtil.isNotBlank(filter.getUndertakingUnit()), CaseInfo::getUndertakingUnit, filter.getUndertakingUnit());
        lqw.like(StrUtil.isNotBlank(filter.getCaseType()), CaseInfo::getCaseType, filter.getCaseType());
        lqw.like(StrUtil.isNotBlank(filter.getCaseSource()), CaseInfo::getCaseSource, filter.getCaseSource());
        lqw.like(StrUtil.isNotBlank(filter.getCaseRemark()), CaseInfo::getCaseRemark, filter.getCaseRemark());
        // 精准查询：状态
        lqw.eq(filter.getUnitStatus() != null, CaseInfo::getUnitStatus, filter.getUnitStatus());
        return lqw;
    }
}