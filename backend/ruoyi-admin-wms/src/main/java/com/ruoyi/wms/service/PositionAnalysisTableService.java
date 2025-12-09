package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.PositionAnalysisTableBo;
import com.ruoyi.wms.domain.entity.PositionAnalysisTable;
import com.ruoyi.wms.domain.vo.PositionAnalysisTableVo;
import com.ruoyi.wms.mapper.PositionAnalysisTableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 持仓分析表Service业务层处理
 *
 * @author student
 * @date 2024-08-01
 */
@RequiredArgsConstructor
@Service
public class PositionAnalysisTableService {

    private final PositionAnalysisTableMapper positionAnalysisTableMapper;

    /**
     * 查询持仓分析表(主键精准查询)
     */
    public PositionAnalysisTableVo queryById(Integer analysisId) {
        return positionAnalysisTableMapper.selectVoById(analysisId);
    }

    /**
     * 查询持仓分析表列表(分页)
     */
    public TableDataInfo<PositionAnalysisTableVo> queryPageList(PositionAnalysisTableBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<PositionAnalysisTable> lqw = buildQueryWrapper(bo);
        Page<PositionAnalysisTableVo> result = positionAnalysisTableMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询持仓分析表列表(不分页)
     */
    public List<PositionAnalysisTableVo> queryList(PositionAnalysisTableBo bo) {
        LambdaQueryWrapper<PositionAnalysisTable> lqw = buildQueryWrapper(bo);
        return positionAnalysisTableMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<PositionAnalysisTable> buildQueryWrapper(PositionAnalysisTableBo bo) {
        LambdaQueryWrapper<PositionAnalysisTable> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(bo.getAnalysisId() != null, PositionAnalysisTable::getAnalysisId, bo.getAnalysisId());
        // 用户ID查询
        lqw.eq(bo.getUserId() != null, PositionAnalysisTable::getUserId, bo.getUserId());
        // 分析类型模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getAnalysisType()), PositionAnalysisTable::getAnalysisType, bo.getAnalysisType());
        // 分析结果详情模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getAnalysisResult()), PositionAnalysisTable::getAnalysisResult, bo.getAnalysisResult());
        // 生成时间查询
        lqw.eq(bo.getGenerateTime() != null, PositionAnalysisTable::getGenerateTime, bo.getGenerateTime());
        lqw.orderByDesc(BaseEntity::getCreateTime);
        return lqw;
    }

    /**
     * 新增持仓分析表
     */
    @Transactional
    public void insertByBo(PositionAnalysisTableBo bo) {
        PositionAnalysisTable add = MapstructUtils.convert(bo, PositionAnalysisTable.class);
        positionAnalysisTableMapper.insert(add);
    }

    /**
     * 修改持仓分析表
     */
    @Transactional
    public void updateByBo(PositionAnalysisTableBo bo) {
        PositionAnalysisTable update = MapstructUtils.convert(bo, PositionAnalysisTable.class);
        positionAnalysisTableMapper.updateById(update);
    }

    /**
     * 删除持仓分析表
     */
    public void deleteById(Integer analysisId) {
        positionAnalysisTableMapper.deleteById(analysisId);
    }
}