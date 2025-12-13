import { request } from '@umijs/max';

// 查询合并数据列表
export async function listCombined(params?: any) {
  return request<any>('/api/wms/data/list', {
    method: 'GET',
    params
  });
}

// 获取合并数据详细信息
export function getCombined(id: string) {
  return request<any>(`/api/wms/data/${id}`, {
    method: 'GET'
  });
}

// 新增合并数据
export async function addCombined(params: any) {
  return request<any>('/api/wms/data', {
    method: 'POST',
    data: params
  });
}

// 修改合并数据
export async function updateCombined(params: any) {
  return request<any>('/api/wms/data', {
    method: 'PUT',
    data: params
  });
}

// 删除合并数据
export async function delCombined(id: string) {
  return request<any>(`/api/wms/data/${id}`, {
    method: 'DELETE'
  });
}
