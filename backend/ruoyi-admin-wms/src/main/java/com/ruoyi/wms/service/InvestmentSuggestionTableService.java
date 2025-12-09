package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.InvestmentSuggestionTableBo;
import com.ruoyi.wms.domain.entity.InvestmentSuggestionTable;
import com.ruoyi.wms.domain.vo.InvestmentSuggestionTableVo;
import com.ruoyi.wms.mapper.InvestmentSuggestionTableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 投资建议表Service业务层处理
 *
 * @author zcc
 * @date 2024-08-01
 */
@RequiredArgsConstructor
@Service
public class InvestmentSuggestionTableService {

    private final InvestmentSuggestionTableMapper investmentSuggestionTableMapper;

    /**
     * 查询投资建议表(主键精准查询)
     */
    public InvestmentSuggestionTableVo queryById(Integer suggestionId) {
        return investmentSuggestionTableMapper.selectVoById(suggestionId);
    }

    /**
     * 查询投资建议表列表
     */
    public TableDataInfo<InvestmentSuggestionTableVo> queryPageList(InvestmentSuggestionTableBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<InvestmentSuggestionTable> lqw = buildQueryWrapper(bo);
        Page<InvestmentSuggestionTableVo> result = investmentSuggestionTableMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询投资建议表列表
     */
    public List<InvestmentSuggestionTableVo> queryList(InvestmentSuggestionTableBo bo) {
        LambdaQueryWrapper<InvestmentSuggestionTable> lqw = buildQueryWrapper(bo);
        return investmentSuggestionTableMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<InvestmentSuggestionTable> buildQueryWrapper(InvestmentSuggestionTableBo bo) {
        LambdaQueryWrapper<InvestmentSuggestionTable> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(bo.getSuggestionId() != null, InvestmentSuggestionTable::getSuggestionId, bo.getSuggestionId());
        // 用户ID查询
        lqw.eq(bo.getUserId() != null, InvestmentSuggestionTable::getUserId, bo.getUserId());
        // 建议类型模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getSuggestionType()), InvestmentSuggestionTable::getSuggestionType, bo.getSuggestionType());
        // 建议内容详情模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getContent()), InvestmentSuggestionTable::getContent, bo.getContent());
        // 生成时间查询
        lqw.eq(bo.getGenerateTime() != null, InvestmentSuggestionTable::getGenerateTime, bo.getGenerateTime());
        // 生效时间查询
        lqw.eq(bo.getEffectiveTime() != null, InvestmentSuggestionTable::getEffectiveTime, bo.getEffectiveTime());
        // 名称模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getName()), InvestmentSuggestionTable::getName, bo.getName());
        // 简写模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getAbbreviation()), InvestmentSuggestionTable::getAbbreviation, bo.getAbbreviation());
        // 市值查询
        lqw.eq(bo.getMarkerValue() != null, InvestmentSuggestionTable::getMarkerValue, bo.getMarkerValue());
        // 价格查询
        lqw.eq(bo.getPrice() != null, InvestmentSuggestionTable::getPrice, bo.getPrice());
        // 流通供给量模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getCirculationSupply()), InvestmentSuggestionTable::getCirculationSupply, bo.getCirculationSupply());
        // 交易量（24小时）查询
        lqw.eq(bo.getVolume24h() != null, InvestmentSuggestionTable::getVolume24h, bo.getVolume24h());
        // %1小时查询
        lqw.eq(bo.getChange1h() != null, InvestmentSuggestionTable::getChange1h, bo.getChange1h());
        // %24小时查询
        lqw.eq(bo.getChange24h() != null, InvestmentSuggestionTable::getChange24h, bo.getChange24h());
        // %7天查询
        lqw.eq(bo.getChange7d() != null, InvestmentSuggestionTable::getChange7d, bo.getChange7d());
        lqw.orderByDesc(BaseEntity::getCreateTime);
        return lqw;
    }

    /**
     * 新增投资建议表
     */
    @Transactional
    public void insertByBo(InvestmentSuggestionTableBo bo) {
        InvestmentSuggestionTable add = MapstructUtils.convert(bo, InvestmentSuggestionTable.class);
        investmentSuggestionTableMapper.insert(add);
    }

    /**
     * 修改投资建议表
     */
    @Transactional
    public void updateByBo(InvestmentSuggestionTableBo bo) {
        InvestmentSuggestionTable update = MapstructUtils.convert(bo, InvestmentSuggestionTable.class);
        investmentSuggestionTableMapper.updateById(update);
    }

    /**
     * 删除投资建议表
     */
    public void deleteById(Integer suggestionId) {
        investmentSuggestionTableMapper.deleteById(suggestionId);
    }
}