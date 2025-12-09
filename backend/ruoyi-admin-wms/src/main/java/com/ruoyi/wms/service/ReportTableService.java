package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.ReportTableBo;
import com.ruoyi.wms.domain.entity.ReportTable;
import com.ruoyi.wms.domain.vo.ReportTableVo;
import com.ruoyi.wms.mapper.ReportTableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 报告表Service业务层处理
 *
 * @author zcc
 * @date 2024-08-01
 */
@RequiredArgsConstructor
@Service
public class ReportTableService {

    private final ReportTableMapper reportTableMapper;

    /**
     * 查询报告表(主键精准查询)
     */
    public ReportTableVo queryById(Integer reportId) {
        return reportTableMapper.selectVoById(reportId);
    }

    /**
     * 查询报告表列表（分页+模糊查询）
     */
    public TableDataInfo<ReportTableVo> queryPageList(ReportTableBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ReportTable> lqw = buildQueryWrapper(bo);
        Page<ReportTableVo> result = reportTableMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询报告表列表（模糊查询）
     */
    public List<ReportTableVo> queryList(ReportTableBo bo) {
        LambdaQueryWrapper<ReportTable> lqw = buildQueryWrapper(bo);
        return reportTableMapper.selectVoList(lqw);
    }

    /**
     * 构建查询条件
     */
    private LambdaQueryWrapper<ReportTable> buildQueryWrapper(ReportTableBo bo) {
        LambdaQueryWrapper<ReportTable> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(bo.getReportId() != null, ReportTable::getReportId, bo.getReportId());
        // 用户ID查询
        lqw.eq(bo.getUserId() != null, ReportTable::getUserId, bo.getUserId());
        // 报告类型模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getReportType()), ReportTable::getReportType, bo.getReportType());
        // 报告内容模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getContent()), ReportTable::getContent, bo.getContent());
        // 审核状态查询
        lqw.eq(bo.getAuditStatus() != null, ReportTable::getAuditStatus, bo.getAuditStatus());
        lqw.orderByDesc(BaseEntity::getCreateTime);
        return lqw;
    }

    /**
     * 新增报告表
     */
    @Transactional
    public void insertByBo(ReportTableBo bo) {
        ReportTable add = MapstructUtils.convert(bo, ReportTable.class);
        reportTableMapper.insert(add);
    }

    /**
     * 修改报告表
     */
    @Transactional
    public void updateByBo(ReportTableBo bo) {
        ReportTable update = MapstructUtils.convert(bo, ReportTable.class);
        reportTableMapper.updateById(update);
    }

    /**
     * 删除报告表
     */
    public void deleteById(Integer reportId) {
        reportTableMapper.deleteById(reportId);
    }
}
