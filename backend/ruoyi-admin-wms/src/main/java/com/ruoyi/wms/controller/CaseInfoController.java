package com.ruoyi.wms.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.CaseInfoBo;
import com.ruoyi.wms.domain.vo.CaseInfoVo;
import com.ruoyi.wms.service.CaseInfoService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 案例信息Controller（精简版，无权限与导出）
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/caseInfo")
public class CaseInfoController extends BaseController {

    private final CaseInfoService caseInfoService;

    /**
     * 分页模糊查询
     */
    @GetMapping("/list")
    public TableDataInfo<CaseInfoVo> list(CaseInfoBo bo, PageQuery pageQuery) {
        return caseInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 根据ID（caseCode）精准查询
     */
    @GetMapping("/{code}")
    public R<CaseInfoVo> getInfo(@PathVariable("code") String code) {
        return R.ok(caseInfoService.queryByCode(code));
    }

    /**
     * 新增
     */
    @PostMapping
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CaseInfoBo bo) {
        caseInfoService.insert(bo);
        return R.ok();
    }

    /**
     * 修改（依据ID）
     */
    @PutMapping
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CaseInfoBo bo) {
        caseInfoService.update(bo);
        return R.ok();
    }

    /**
     * 删除单个（依据ID）
     */
    @DeleteMapping("/{code}")
    public R<Void> remove(@PathVariable("code") String code) {
        caseInfoService.deleteByCode(code);
        return R.ok();
    }

    /**
     * 批量删除（依据ID）
     */
    @DeleteMapping("/batch")
    public R<Void> removeBatch(@RequestBody @NotEmpty List<String> codes) {
        caseInfoService.deleteByCodes(codes);
        return R.ok();
    }
}