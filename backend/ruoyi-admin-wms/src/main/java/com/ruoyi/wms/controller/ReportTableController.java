package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.ReportTableBo;
import com.ruoyi.wms.domain.vo.ReportTableVo;
import com.ruoyi.wms.service.ReportTableService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报告表控制器 - 学生学习版
 * 无权限约束，可直接访问所有接口
 *
 * @author student
 * @date 2024-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/report")
public class ReportTableController extends BaseController {

    private final ReportTableService reportTableService;

    /**
     * 根据ID查询报告详情
     */
    @SaIgnore
    @GetMapping("/{reportId}")
    public R<ReportTableVo> getReportById(@NotNull(message = "报告ID不能为空") @PathVariable Integer reportId) {
        return R.ok(reportTableService.queryById(reportId));
    }

    /**
     * 分页查询报告列表（支持ID和内容模糊查询）
     */
    @SaIgnore
    @GetMapping("/list")
    public TableDataInfo<ReportTableVo> getReportList(ReportTableBo bo, PageQuery pageQuery) {
        return reportTableService.queryPageList(bo, pageQuery);
    }

    /**
     * 不分页查询报告列表（支持ID和内容模糊查询）
     */
    @SaIgnore
    @GetMapping("/all")
    public R<List<ReportTableVo>> getAllReports(ReportTableBo bo) {
        return R.ok(reportTableService.queryList(bo));
    }

    /**
     * 新增报告
     */
    @SaIgnore
    @PostMapping
    public R<Void> addReport(@RequestBody ReportTableBo bo) {
        reportTableService.insertByBo(bo);
        return R.ok("报告新增成功");
    }

    /**
     * 根据ID修改报告
     */
    @SaIgnore
    @PutMapping
    public R<Void> updateReport(@RequestBody ReportTableBo bo) {
        reportTableService.updateByBo(bo);
        return R.ok("报告修改成功");
    }

    /**
     * 根据ID删除报告
     */
    @SaIgnore
    @DeleteMapping("/{reportId}")
    public R<Void> deleteReport(@NotNull(message = "报告ID不能为空") @PathVariable Integer reportId) {
        reportTableService.deleteById(reportId);
        return R.ok("报告删除成功");
    }
}
