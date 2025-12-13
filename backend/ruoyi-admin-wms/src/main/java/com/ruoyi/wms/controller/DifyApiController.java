package com.ruoyi.wms.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.vo.DifyResponseVo;
import com.ruoyi.wms.service.IDifyApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Dify API控制器
 * 用于调用Dify API执行任务并获取结果
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dify")
public class DifyApiController extends BaseController {
    private final IDifyApiService difyApiService;

    /**
     * 调用Dify API执行任务
     *
     * @param requestData 请求数据（JSON格式）
     * @return 执行结果
     */
    @PostMapping("/execute")
    public R<DifyResponseVo> executeTask(@RequestBody String requestData) {
        try {
            DifyResponseVo response = difyApiService.executeTask(requestData);
            return R.ok(response);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 获取Dify API任务执行结果
     *
     * @param taskId 任务ID
     * @return 任务执行结果
     */
    @GetMapping("/result/{taskId}")
    public R<DifyResponseVo> fetchTaskResult(@PathVariable String taskId) {
        try {
            DifyResponseVo response = difyApiService.fetchTaskResult(taskId);
            return R.ok(response);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 批量获取Dify API任务执行结果
     *
     * @param taskIds 任务ID列表
     * @return 任务执行结果列表
     */
    @PostMapping("/result/batch")
    public R<List<DifyResponseVo>> batchFetchTaskResults(@RequestBody List<String> taskIds) {
        try {
            List<DifyResponseVo> responses = difyApiService.batchFetchTaskResults(taskIds);
            return R.ok(responses);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    /**
     * 导出Dify API任务执行结果
     *
     * @param params 导出参数
     * @return 导出结果（文件）
     */
    @PostMapping(value = "/result/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] exportTaskResults(@RequestBody Map<String, Object> params) {
        try {
            return difyApiService.exportTaskResults(params);
        } catch (Exception e) {
            // 这里可以根据需要处理导出异常
            return new byte[0];
        }
    }
}
