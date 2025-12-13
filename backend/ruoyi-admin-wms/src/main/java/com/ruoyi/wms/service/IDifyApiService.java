package com.ruoyi.wms.service;

import com.ruoyi.wms.domain.vo.DifyResponseVo;

import java.util.List;
import java.util.Map;

/**
 * Dify API服务接口
 *
 * @author ruoyi
 */
public interface IDifyApiService {
    /**
     * 调用Dify API执行任务
     *
     * @param requestData 请求数据
     * @return Dify API响应数据
     */
    DifyResponseVo executeTask(String requestData);

    /**
     * 拉取Dify API任务结果
     *
     * @param taskId 任务ID
     * @return Dify API响应数据
     */
    DifyResponseVo fetchTaskResult(String taskId);

    /**
     * 批量拉取Dify API任务结果
     *
     * @param taskIds 任务ID列表
     * @return Dify API响应数据列表
     */
    List<DifyResponseVo> batchFetchTaskResults(List<String> taskIds);

    /**
     * 导出Dify API任务结果
     *
     * @param params 导出参数
     * @return 导出文件字节数组
     */
    byte[] exportTaskResults(Map<String, Object> params);
}
