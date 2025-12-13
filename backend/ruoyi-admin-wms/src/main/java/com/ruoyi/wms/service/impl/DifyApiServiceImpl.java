package com.ruoyi.wms.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.wms.config.DifyConfig;
import com.ruoyi.wms.domain.vo.DifyResponseVo;
import com.ruoyi.wms.service.IDifyApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Dify API服务实现类
 *
 * @author ruoyi
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DifyApiServiceImpl implements IDifyApiService {
    private final DifyConfig difyConfig;
    private final ObjectMapper objectMapper;

    private static final String DIFY_API_PATH = "/v1/workflows/run";
    private static final String DIFY_TASK_RESULT_PATH = "/v1/workflows/tasks/";

    @Override
    public DifyResponseVo executeTask(String requestData) {
        String apiUrl = difyConfig.getBaseUrl() + DIFY_API_PATH;
        log.info("调用Dify API执行任务，URL: {}, 请求数据: {}", apiUrl, requestData);

        try (HttpResponse response = HttpRequest.post(apiUrl)
                .header("Authorization", "Bearer " + difyConfig.getApiKey())
                .header("Content-Type", "application/json")
                .timeout(difyConfig.getTimeout())
                .body(requestData)
                .execute()) {

            if (response.isOk()) {
                String responseBody = response.body();
                log.info("Dify API执行任务响应: {}", responseBody);
                return objectMapper.readValue(responseBody, DifyResponseVo.class);
            } else {
                log.error("Dify API执行任务失败，状态码: {}, 响应: {}", response.getStatus(), response.body());
                throw new RuntimeException("Dify API执行任务失败: " + response.getStatus());
            }
        } catch (IOException e) {
            log.error("Dify API执行任务异常: {}", e.getMessage(), e);
            throw new RuntimeException("Dify API执行任务异常", e);
        }
    }

    @Override
    public DifyResponseVo fetchTaskResult(String taskId) {
        String apiUrl = difyConfig.getBaseUrl() + DIFY_TASK_RESULT_PATH + taskId;
        log.info("拉取Dify API任务结果，URL: {}", apiUrl);

        try (HttpResponse response = HttpRequest.get(apiUrl)
                .header("Authorization", "Bearer " + difyConfig.getApiKey())
                .timeout(difyConfig.getTimeout())
                .execute()) {

            if (response.isOk()) {
                String responseBody = response.body();
                log.info("Dify API任务结果响应: {}", responseBody);
                return objectMapper.readValue(responseBody, DifyResponseVo.class);
            } else {
                log.error("拉取Dify API任务结果失败，状态码: {}, 响应: {}", response.getStatus(), response.body());
                throw new RuntimeException("拉取Dify API任务结果失败: " + response.getStatus());
            }
        } catch (IOException e) {
            log.error("拉取Dify API任务结果异常: {}", e.getMessage(), e);
            throw new RuntimeException("拉取Dify API任务结果异常", e);
        }
    }

    @Override
    public List<DifyResponseVo> batchFetchTaskResults(List<String> taskIds) {
        log.info("批量拉取Dify API任务结果，任务ID列表: {}", taskIds);
        return taskIds.stream()
                .map(this::fetchTaskResult)
                .collect(Collectors.toList());
    }

    @Override
    public byte[] exportTaskResults(Map<String, Object> params) {
        log.info("导出Dify API任务结果，参数: {}", params);
        // TODO: 实现导出逻辑，这里可以根据需求生成Excel、PDF等格式的文件
        // 示例实现，返回一个空的字节数组
        return new byte[0];
    }
}
