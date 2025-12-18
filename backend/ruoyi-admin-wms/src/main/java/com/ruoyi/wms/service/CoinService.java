package com.ruoyi.wms.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.CoinBo;
import com.ruoyi.wms.domain.entity.Coin;
import com.ruoyi.wms.domain.vo.CoinVo;
import com.ruoyi.wms.mapper.CoinMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CoinService {

    private final CoinMapper coinMapper;

    /**
     * 根据主键查询加密货币
     */
    public CoinVo queryById(Long id) {
        return coinMapper.selectVoById(id);
    }

    /**
     * 分页查询加密货币列表（支持模糊查询）
     */
    public TableDataInfo<CoinVo> queryPageList(CoinBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Coin> lqw = buildQueryWrapper(bo);
        Page<CoinVo> result = coinMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询加密货币列表（支持模糊查询）
     */
    public List<CoinVo> queryList(CoinBo bo) {
        LambdaQueryWrapper<Coin> lqw = buildQueryWrapper(bo);
        return coinMapper.selectVoList(lqw);
    }

    /**
     * 构建查询条件（支持模糊查询）
     */
    private LambdaQueryWrapper<Coin> buildQueryWrapper(CoinBo bo) {
        LambdaQueryWrapper<Coin> lqw = Wrappers.lambdaQuery();
        // 支持根据id进行精准查询
        lqw.eq(bo.getId() != null, Coin::getId, bo.getId());
        // 支持根据名称进行模糊查询
        lqw.like(StrUtil.isNotBlank(bo.getName()), Coin::getName, bo.getName());
        // 支持根据符号进行模糊查询
        lqw.like(StrUtil.isNotBlank(bo.getSymbol()), Coin::getSymbol, bo.getSymbol());
        return lqw;
    }

    /**
     * 新增加密货币
     */
    public void insertByBo(CoinBo bo) {
        Coin add = MapstructUtils.convert(bo, Coin.class);
        coinMapper.insert(add);
    }

    /**
     * 批量新增加密货币
     */
    public void batchInsert(List<CoinBo> boList) {
        List<Coin> coins = MapstructUtils.convert(boList, Coin.class);
        coinMapper.insertBatch(coins);
    }

    /**
     * 修改加密货币
     */
    public void updateByBo(CoinBo bo) {
        Coin update = MapstructUtils.convert(bo, Coin.class);
        coinMapper.updateById(update);
    }

    /**
     * 根据主键删除加密货币
     */
    public void deleteById(Long id) {
        coinMapper.deleteById(id);
    }

    /**
     * 批量删除加密货币
     */
    public void deleteByIds(Collection<Long> ids) {
        coinMapper.deleteBatchIds(ids);
    }
}