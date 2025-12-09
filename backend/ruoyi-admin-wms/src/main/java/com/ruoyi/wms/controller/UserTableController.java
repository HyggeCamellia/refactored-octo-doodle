package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.UserTableBo;
import com.ruoyi.wms.domain.vo.UserTableVo;
import com.ruoyi.wms.service.UserTableService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户表控制器 - 学生学习版
 * 无权限约束，可直接访问所有接口
 *
 * @author student
 * @date 2024-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/user")
public class UserTableController extends BaseController {

    private final UserTableService userTableService;

    /**
     * 根据ID查询用户详情
     */
    @SaIgnore
    @GetMapping("/{userId}")
    public R<UserTableVo> getUserById(@NotNull(message = "用户ID不能为空") @PathVariable Integer userId) {
        return R.ok(userTableService.queryById(userId));
    }

    /**
     * 分页查询用户列表（支持ID、用户名、手机号、邮箱的模糊查询）
     */
    @SaIgnore
    @GetMapping("/list")
    public TableDataInfo<UserTableVo> getUserList(UserTableBo bo, PageQuery pageQuery) {
        return userTableService.queryPageList(bo, pageQuery);
    }

    /**
     * 不分页查询用户列表（支持ID、用户名、手机号、邮箱的模糊查询）
     */
    @SaIgnore
    @GetMapping("/all")
    public R<List<UserTableVo>> getAllUsers(UserTableBo bo) {
        return R.ok(userTableService.queryList(bo));
    }

    /**
     * 新增用户
     */
    @SaIgnore
    @PostMapping
    public R<Void> addUser(@RequestBody UserTableBo bo) {
        userTableService.insertByBo(bo);
        return R.ok("用户新增成功");
    }

    /**
     * 根据ID修改用户
     */
    @SaIgnore
    @PutMapping
    public R<Void> updateUser(@RequestBody UserTableBo bo) {
        userTableService.updateByBo(bo);
        return R.ok("用户修改成功");
    }

    /**
     * 根据ID删除用户
     */
    @SaIgnore
    @DeleteMapping("/{userId}")
    public R<Void> deleteUser(@NotNull(message = "用户ID不能为空") @PathVariable Integer userId) {
        userTableService.deleteById(userId);
        return R.ok("用户删除成功");
    }
}
