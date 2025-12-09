package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.PositionAnalysisTableBo;
import com.ruoyi.wms.domain.vo.PositionAnalysisTableVo;
import com.ruoyi.wms.service.PositionAnalysisTableService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 持仓分析表控制器 - 学生学习版
 * 无权限约束，可直接访问所有接口
 *
 * @author student
 * @date 2024-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/position-analysis")
public class PositionAnalysisTableController extends BaseController {

    private final PositionAnalysisTableService positionAnalysisTableService;

    /**
     * 根据ID查询持仓分析详情
     */
    @SaIgnore
    @GetMapping("/{analysisId}")
    public R<PositionAnalysisTableVo> getPositionAnalysisById(@NotNull(message = "分析ID不能为空") @PathVariable Integer analysisId) {
        return R.ok(positionAnalysisTableService.queryById(analysisId));
    }

    /**
     * 分页查询持仓分析列表（支持ID、分析类型和结果模糊查询）
     */
    @SaIgnore
    @GetMapping("/list")
    public TableDataInfo<PositionAnalysisTableVo> getPositionAnalysisList(PositionAnalysisTableBo bo, PageQuery pageQuery) {
        return positionAnalysisTableService.queryPageList(bo, pageQuery);
    }

    /**
     * 不分页查询持仓分析列表（支持ID、分析类型和结果模糊查询）
     */
    @SaIgnore
    @GetMapping("/all")
    public R<List<PositionAnalysisTableVo>> getAllPositionAnalysis(PositionAnalysisTableBo bo) {
        return R.ok(positionAnalysisTableService.queryList(bo));
    }

    /**
     * 新增持仓分析
     */
    @SaIgnore
    @PostMapping
    public R<Void> addPositionAnalysis(@RequestBody PositionAnalysisTableBo bo) {
        positionAnalysisTableService.insertByBo(bo);
        return R.ok("持仓分析新增成功");
    }

    /**
     * 根据ID修改持仓分析
     */
    @SaIgnore
    @PutMapping
    public R<Void> updatePositionAnalysis(@RequestBody PositionAnalysisTableBo bo) {
        positionAnalysisTableService.updateByBo(bo);
        return R.ok("持仓分析修改成功");
    }

    /**
     * 根据ID删除持仓分析
     */
    @SaIgnore
    @DeleteMapping("/{analysisId}")
    public R<Void> deletePositionAnalysis(@NotNull(message = "分析ID不能为空") @PathVariable Integer analysisId) {
        positionAnalysisTableService.deleteById(analysisId);
        return R.ok("持仓分析删除成功");
    }
}