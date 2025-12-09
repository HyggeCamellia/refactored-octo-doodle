package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.AssetTableBo;
import com.ruoyi.wms.domain.entity.AssetTable;
import com.ruoyi.wms.domain.vo.AssetTableVo;
import com.ruoyi.wms.mapper.AssetTableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数字货币资产估值Service业务层处理
 *
 * @author zcc
 * @date 2024-08-01
 */
@RequiredArgsConstructor
@Service
public class AssetTableService {

    private final AssetTableMapper assetTableMapper;

    /**
     * 查询数字货币资产估值(主键精准查询)
     */
    public AssetTableVo queryById(Long assetId) {
        return assetTableMapper.selectVoById(assetId);
    }

    /**
     * 查询数字货币资产估值列表
     */
    public TableDataInfo<AssetTableVo> queryPageList(AssetTableBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<AssetTable> lqw = buildQueryWrapper(bo);
        Page<AssetTableVo> result = assetTableMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询数字货币资产估值列表
     */
    public List<AssetTableVo> queryList(AssetTableBo bo) {
        LambdaQueryWrapper<AssetTable> lqw = buildQueryWrapper(bo);
        return assetTableMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<AssetTable> buildQueryWrapper(AssetTableBo bo) {
        LambdaQueryWrapper<AssetTable> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(bo.getAssetId() != null, AssetTable::getAssetId, bo.getAssetId());
        // 用户ID查询
        lqw.eq(bo.getUserId() != null, AssetTable::getUserId, bo.getUserId());
        // 名称模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getName()), AssetTable::getName, bo.getName());
        // 简称模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getAbbreviation()), AssetTable::getAbbreviation, bo.getAbbreviation());
        // 流通量模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getCirculationSupply()), AssetTable::getCirculationSupply, bo.getCirculationSupply());
        // 市值查询
        lqw.eq(bo.getMarketValue() != null, AssetTable::getMarketValue, bo.getMarketValue());
        // 价格查询
        lqw.eq(bo.getPrice() != null, AssetTable::getPrice, bo.getPrice());
        // 1小时涨跌幅查询
        lqw.eq(bo.getChange1h() != null, AssetTable::getChange1h, bo.getChange1h());
        // 24小时涨跌幅查询
        lqw.eq(bo.getChange24h() != null, AssetTable::getChange24h, bo.getChange24h());
        // 7天涨跌幅查询
        lqw.eq(bo.getChange7d() != null, AssetTable::getChange7d, bo.getChange7d());
        // 24小时交易量查询
        lqw.eq(bo.getVolume24h() != null, AssetTable::getVolume24h, bo.getVolume24h());
        // 最后更新时间查询
        lqw.eq(bo.getUpdateTime() != null, AssetTable::getUpdateTime, bo.getUpdateTime());
        lqw.orderByDesc(BaseEntity::getCreateTime);
        return lqw;
    }

    /**
     * 新增数字货币资产估值
     */
    @Transactional
    public void insertByBo(AssetTableBo bo) {
        AssetTable add = MapstructUtils.convert(bo, AssetTable.class);
        assetTableMapper.insert(add);
    }

    /**
     * 修改数字货币资产估值
     */
    @Transactional
    public void updateByBo(AssetTableBo bo) {
        AssetTable update = MapstructUtils.convert(bo, AssetTable.class);
        assetTableMapper.updateById(update);
    }

    /**
     * 删除数字货币资产估值
     */
    public void deleteById(Long assetId) {
        assetTableMapper.deleteById(assetId);
    }
}
