package com.ruoyi.wms.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.excel.utils.ExcelUtil;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.CoinBo;
import com.ruoyi.wms.domain.vo.CoinVo;
import com.ruoyi.wms.service.CoinService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.dev33.satoken.annotation.SaIgnore;

import java.util.List;

/**
 * 加密货币控制器
 *
 * @author zcc
 * @date 2025-12-16
 */
@Validated
@RequiredArgsConstructor
@RestController
@SaIgnore
@RequestMapping("/coin")
public class CoinController extends BaseController {

    private final CoinService coinService;

    /**
     * 查询加密货币列表
     */
    @GetMapping("/list")
    public TableDataInfo<CoinVo> list(CoinBo bo, PageQuery pageQuery) {
        return coinService.queryPageList(bo, pageQuery);
    }

    /**
     * 查询加密货币列表
     */
    @GetMapping("/listNoPage")
    public R<List<CoinVo>> listNoPage(CoinBo bo) {
        return R.ok(coinService.queryList(bo));
    }

    /**
     * 导出加密货币列表
     */
    @Log(title = "加密货币", businessType = BusinessType.EXPORT)
    @SaIgnore
    @PostMapping("/export")
    public void export(CoinBo bo, HttpServletResponse response) {
        List<CoinVo> list = coinService.queryList(bo);
        ExcelUtil.exportExcel(list, "加密货币", CoinVo.class, response);
    }

    /**
     * 获取加密货币详细信息
     */
    @GetMapping(value = "/{id}")
    public R<CoinVo> getInfo(@PathVariable("id") Long id) {
        return R.ok(coinService.queryById(id));
    }

    /**
     * 新增加密货币
     */
    @Log(title = "加密货币", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping
    public R<Void> add(@Validated @RequestBody CoinBo bo) {
        coinService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 批量导入加密货币数据（接收dify的HTTP请求）
     */
    @SaIgnore
    @Log(title = "加密货币批量导入", businessType = BusinessType.INSERT)
    @PostMapping("/importBatch")
    public R<Void> importBatch(@RequestBody List<CoinBo> boList) {
        coinService.batchInsert(boList);
        return R.ok();
    }

    /**
     * 修改加密货币
     */
    @Log(title = "加密货币", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping
    public R<Void> edit(@Validated @RequestBody CoinBo bo) {
        coinService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除加密货币
     */
    @Log(title = "加密货币", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        coinService.deleteByIds(List.of(ids));
        return R.ok();
    }
}