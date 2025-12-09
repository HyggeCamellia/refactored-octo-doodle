package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.MessageTableBo;
import com.ruoyi.wms.domain.vo.MessageTableVo;
import com.ruoyi.wms.service.MessageTableService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息表控制器 - 学生学习版
 * 无权限约束，可直接访问所有接口
 *
 * @author student
 * @date 2024-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/message")
public class MessageTableController extends BaseController {

    private final MessageTableService messageTableService;

    /**
     * 根据ID查询消息详情
     */
    @SaIgnore
    @GetMapping("/{msgId}")
    public R<MessageTableVo> getMessageById(@NotNull(message = "消息ID不能为空") @PathVariable Integer msgId) {
        return R.ok(messageTableService.queryById(msgId));
    }

    /**
     * 分页查询消息列表（支持ID和内容模糊查询）
     */
    @SaIgnore
    @GetMapping("/list")
    public TableDataInfo<MessageTableVo> getMessageList(MessageTableBo bo, PageQuery pageQuery) {
        return messageTableService.queryPageList(bo, pageQuery);
    }

    /**
     * 不分页查询消息列表（支持ID和内容模糊查询）
     */
    @SaIgnore
    @GetMapping("/all")
    public R<List<MessageTableVo>> getAllMessages(MessageTableBo bo) {
        return R.ok(messageTableService.queryList(bo));
    }

    /**
     * 新增消息
     */
    @SaIgnore
    @PostMapping
    public R<Void> addMessage(@RequestBody MessageTableBo bo) {
        messageTableService.insertByBo(bo);
        return R.ok("消息新增成功");
    }

    /**
     * 根据ID修改消息
     */
    @SaIgnore
    @PutMapping
    public R<Void> updateMessage(@RequestBody MessageTableBo bo) {
        messageTableService.updateByBo(bo);
        return R.ok("消息修改成功");
    }

    /**
     * 根据ID删除消息
     */
    @SaIgnore
    @DeleteMapping("/{msgId}")
    public R<Void> deleteMessage(@NotNull(message = "消息ID不能为空") @PathVariable Integer msgId) {
        messageTableService.deleteById(msgId);
        return R.ok("消息删除成功");
    }
}
