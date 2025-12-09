package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.InvestmentSuggestionTableBo;
import com.ruoyi.wms.domain.vo.InvestmentSuggestionTableVo;
import com.ruoyi.wms.service.InvestmentSuggestionTableService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 投资建议表控制器
 * 注：使用@SaIgnore绕过权限验证，适合学生学习环境使用
 *
 * @author student
 * @date 2024-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/investment-suggestion")
public class InvestmentSuggestionTableController extends BaseController {

    private final InvestmentSuggestionTableService investmentSuggestionTableService;

    /**
     * 查询投资建议表详情（根据ID）
     */
    @SaIgnore
    @GetMapping("/{suggestionId}")
    public R<InvestmentSuggestionTableVo> getById(@NotNull(message = "主键不能为空")
                                                  @PathVariable Integer suggestionId) {
        return R.ok(investmentSuggestionTableService.queryById(suggestionId));
    }

    /**
     * 查询投资建议表列表（分页，支持模糊查询）
     */
    @SaIgnore
    @GetMapping("/list")
    public TableDataInfo<InvestmentSuggestionTableVo> list(InvestmentSuggestionTableBo bo, PageQuery pageQuery) {
        return investmentSuggestionTableService.queryPageList(bo, pageQuery);
    }

    /**
     * 查询投资建议表列表（不分页，支持模糊查询）
     */
    @SaIgnore
    @GetMapping("/listNoPage")
    public R<List<InvestmentSuggestionTableVo>> listNoPage(InvestmentSuggestionTableBo bo) {
        return R.ok(investmentSuggestionTableService.queryList(bo));
    }

    /**
     * 新增投资建议表
     */
    @SaIgnore
    @PostMapping
    public R<Void> add(@RequestBody InvestmentSuggestionTableBo bo) {
        investmentSuggestionTableService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 修改投资建议表（根据ID）
     */
    @SaIgnore
    @PutMapping
    public R<Void> edit(@RequestBody InvestmentSuggestionTableBo bo) {
        investmentSuggestionTableService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除投资建议表（根据ID）
     */
    @SaIgnore
    @DeleteMapping("/{suggestionId}")
    public R<Void> remove(@NotNull(message = "主键不能为空")
                          @PathVariable Integer suggestionId) {
        investmentSuggestionTableService.deleteById(suggestionId);
        return R.ok();
    }
}
