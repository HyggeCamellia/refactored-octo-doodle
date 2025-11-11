import { request } from 'umi';

// 定义接口类型
export interface NewsItem {
  id: string;
  title: string;
  content: string;
  cryptoType: string;
  sentiment: 'positive' | 'negative' | 'neutral';
  publishTime: string;
  source: string;
  isRead: boolean;
}

export interface PortfolioItem {
  id: string;
  cryptoType: string;
  amount: number;
  price: number;
  value: number;
  percentage: number;
}

export interface DailyChange {
  date: string;
  totalValue: number;
}

export interface Recommendation {
  id: string;
  title: string;
  summary: string;
  content: string;
  status: 'pending' | 'approved' | 'rejected';
  createTime: string;
  relatedNews: {
    id: string;
    title: string;
    sentiment: 'positive' | 'negative' | 'neutral';
  }[];
  cryptoSuggestions: {
    cryptoType: string;
    action: 'increase' | 'decrease' | 'hold';
    reason: string;
    currentAllocation: number;
    suggestedAllocation: number;
  }[];
}

export interface OverviewData {
  unreadNewsCount: number;
  pendingReportsCount: number;
  totalAssetsValue: number;
}

// 获取系统概览数据
export async function fetchCryptoOverview(): Promise<{ data: OverviewData }> {
  return request('/api/crypto/overview', {
    method: 'GET',
  });
}

// 获取消息列表
export async function fetchCryptoNews(params?: {
  cryptoType?: string;
  sentiment?: string;
  startDate?: string;
  endDate?: string;
  keyword?: string;
  page?: number;
  pageSize?: number;
}): Promise<{ data: { list: NewsItem[]; total: number } }> {
  return request('/api/crypto/news', {
    method: 'GET',
    params,
  });
}

// 标记消息已读
export async function markNewsAsRead(id: string): Promise<{ success: boolean }> {
  return request(`/api/crypto/news/${id}/read`, {
    method: 'PUT',
  });
}

// 获取持仓数据
export async function fetchPortfolio(): Promise<{ data: PortfolioItem[] }> {
  return request('/api/crypto/portfolio', {
    method: 'GET',
  });
}

// 获取近7日持仓变化
export async function fetchDailyChanges(): Promise<{ data: DailyChange[] }> {
  return request('/api/crypto/portfolio/changes', {
    method: 'GET',
  });
}

// 导出持仓数据
export async function exportPortfolioExcel(): Promise<{ data: { downloadUrl: string } }> {
  return request('/api/crypto/portfolio/export', {
    method: 'GET',
  });
}

// 获取建议报告列表
export async function fetchRecommendationsList(params?: {
  status?: 'pending' | 'approved' | 'rejected';
  page?: number;
  pageSize?: number;
}): Promise<{ data: { list: Recommendation[]; total: number } }> {
  return request('/api/crypto/recommendations', {
    method: 'GET',
    params,
  });
}

// 获取建议报告详情
export async function fetchRecommendationDetail(id: string): Promise<{ data: Recommendation }> {
  return request(`/api/crypto/recommendations/${id}`, {
    method: 'GET',
  });
}

// 审核建议报告
export async function auditRecommendation(
  id: string,
  status: 'approved' | 'rejected',
  comment?: string
): Promise<{ success: boolean }> {
  return request(`/api/crypto/recommendations/${id}/audit`, {
    method: 'PUT',
    data: { status, comment },
  });
}

// 更新持仓数据（审核通过后）
export async function updatePortfolioAllocation(allocation: {
  cryptoType: string;
  allocationPercentage: number;
}[]): Promise<{ success: boolean }> {
  return request('/api/crypto/portfolio/update', {
    method: 'PUT',
    data: { allocation },
  });
}

// 调用Dify API进行消息情感分析
export async function analyzeNewsSentiment(newsContent: string): Promise<{ data: { sentiment: string; confidence: number } }> {
  return request('/api/crypto/ai/analyze-sentiment', {
    method: 'POST',
    data: { newsContent },
  });
}

// 调用Dify API生成持仓建议
export async function generatePortfolioAdvice(params: {
  newsSummary: string;
  currentPortfolio: PortfolioItem[];
}): Promise<{ data: Recommendation }> {
  return request('/api/crypto/ai/generate-advice', {
    method: 'POST',
    data: params,
  });
}