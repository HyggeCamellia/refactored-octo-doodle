import React, { useState, useEffect } from 'react';
import { Card, Button, message, Tabs, List, Modal, Tag, Timeline } from 'antd';
import { CheckOutlined, CloseOutlined, FileTextOutlined, BellOutlined } from '@ant-design/icons';
import type { TabsProps } from 'antd';

interface Recommendation {
  id: string;
  title: string;
  summary: string;
  content: string;
  status: 'pending' | 'approved' | 'rejected';
  createTime: string;
  relatedNews: NewsItem[];
  cryptoSuggestions: CryptoSuggestion[];
}

interface NewsItem {
  id: string;
  title: string;
  sentiment: 'positive' | 'negative' | 'neutral';
}

interface CryptoSuggestion {
  cryptoType: string;
  action: 'increase' | 'decrease' | 'hold';
  reason: string;
  currentAllocation: number;
  suggestedAllocation: number;
}

const { TabPane } = Tabs;

const Recommendations: React.FC = () => {
  const [recommendations, setRecommendations] = useState<Recommendation[]>([]);
  const [selectedTab, setSelectedTab] = useState<string>('pending');
  const [loading, setLoading] = useState<boolean>(true);
  const [detailModalVisible, setDetailModalVisible] = useState<boolean>(false);
  const [currentReport, setCurrentReport] = useState<Recommendation | null>(null);

  // 模拟数据
  const mockRecommendations: Recommendation[] = [
    {
      id: '1',
      title: '市场利好因素分析与持仓调整建议',
      summary: '基于最新市场消息，建议增加比特币持仓比例，减少以太坊持仓。',
      content: '根据近期市场数据分析和消息情感分析，比特币突破10万美元大关，市场情绪整体向好。建议将比特币持仓比例从50%提高到60%，以太坊从25%减少到20%，保持Solana持仓不变。这一调整旨在抓住比特币的上涨趋势，同时降低以太坊因网络升级延迟带来的短期风险。',
      status: 'pending',
      createTime: '2025-11-11 10:30:00',
      relatedNews: [
        { id: '1', title: '比特币突破10万美元大关，创历史新高', sentiment: 'positive' },
        { id: '2', title: '以太坊网络升级延迟，社区担忧', sentiment: 'negative' },
      ],
      cryptoSuggestions: [
        {
          cryptoType: '比特币',
          action: 'increase',
          reason: '突破历史新高，机构资金持续流入',
          currentAllocation: 50,
          suggestedAllocation: 60,
        },
        {
          cryptoType: '以太坊',
          action: 'decrease',
          reason: '网络升级延迟，短期可能面临回调',
          currentAllocation: 25,
          suggestedAllocation: 20,
        },
        {
          cryptoType: 'Solana',
          action: 'hold',
          reason: '生态系统稳定发展，保持现有配置',
          currentAllocation: 20,
          suggestedAllocation: 20,
        },
      ],
    },
    {
      id: '2',
      title: '监管政策变化应对策略',
      summary: '针对新发布的监管框架草案，建议调整资产配置以降低监管风险。',
      content: '鉴于监管机构发布的加密货币监管框架草案，我们需要重新评估投资组合的风险敞口。建议增加合规性较高的大型加密货币占比，同时关注监管友好型项目的发展机会。',
      status: 'pending',
      createTime: '2025-11-10 16:45:00',
      relatedNews: [
        { id: '3', title: '监管机构发布加密货币监管框架草案', sentiment: 'neutral' },
      ],
      cryptoSuggestions: [
        {
          cryptoType: '比特币',
          action: 'increase',
          reason: '监管明确性提高，机构认可度增强',
          currentAllocation: 50,
          suggestedAllocation: 55,
        },
        {
          cryptoType: '以太坊',
          action: 'hold',
          reason: '监管态度相对中立，保持现有配置',
          currentAllocation: 25,
          suggestedAllocation: 25,
        },
        {
          cryptoType: '其他',
          action: 'decrease',
          reason: '合规风险较高，建议降低配置',
          currentAllocation: 25,
          suggestedAllocation: 20,
        },
      ],
    },
    {
      id: '3',
      title: 'Solana生态系统发展机遇分析',
      summary: 'Solana网络活跃度增长，建议适度增加配置。',
      content: 'Solana生态系统近期表现活跃，日活跃地址数和交易量均呈现增长趋势。DeFi和NFT项目数量稳步增加，开发者活跃度提升。建议适度增加Solana的持仓比例，把握生态系统发展机遇。',
      status: 'approved',
      createTime: '2025-11-09 14:20:00',
      relatedNews: [
        { id: '4', title: 'Solana生态系统活跃度持续增长', sentiment: 'positive' },
      ],
      cryptoSuggestions: [
        {
          cryptoType: 'Solana',
          action: 'increase',
          reason: '生态系统活跃度高，发展潜力大',
          currentAllocation: 15,
          suggestedAllocation: 20,
        },
      ],
    },
  ];

  // 获取建议报告列表
  const fetchRecommendations = async () => {
    try {
      setLoading(true);
      // 这里应该调用真实API
      // const response = await fetchRecommendationsList();
      // 模拟数据
      setTimeout(() => {
        setRecommendations(mockRecommendations);
        setLoading(false);
      }, 500);
    } catch (error) {
      message.error('获取建议报告失败');
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchRecommendations();
  }, []);

  // 审核操作
  const handleAudit = async (id: string, status: 'approved' | 'rejected') => {
    try {
      // 这里应该调用真实API
      // await auditRecommendation(id, status);
      // 更新本地状态
      const updatedRecommendations = recommendations.map(item =>
        item.id === id ? { ...item, status } : item
      );
      setRecommendations(updatedRecommendations);
      
      if (currentReport?.id === id) {
        setCurrentReport({ ...currentReport, status });
      }
      
      message.success(
        status === 'approved' ? '报告已通过审核' : '报告已拒绝'
      );
    } catch (error) {
      message.error('审核操作失败');
    }
  };

  // 查看报告详情
  const handleViewDetail = (report: Recommendation) => {
    setCurrentReport(report);
    setDetailModalVisible(true);
  };

  // 关闭详情模态框
  const handleCloseDetail = () => {
    setDetailModalVisible(false);
    setCurrentReport(null);
  };

  // 根据标签过滤报告
  const filteredRecommendations = recommendations.filter(
    item => item.status === selectedTab
  );

  // 获取状态标签颜色
  const getStatusColor = (status: string) => {
    switch (status) {
      case 'pending':
        return 'orange';
      case 'approved':
        return 'green';
      case 'rejected':
        return 'red';
      default:
        return 'default';
    }
  };

  // 获取状态文本
  const getStatusText = (status: string) => {
    switch (status) {
      case 'pending':
        return '待审核';
      case 'approved':
        return '已通过';
      case 'rejected':
        return '已拒绝';
      default:
        return status;
    }
  };

  // 获取操作标签颜色
  const getActionColor = (action: string) => {
    switch (action) {
      case 'increase':
        return 'green';
      case 'decrease':
        return 'red';
      case 'hold':
        return 'blue';
      default:
        return 'default';
    }
  };

  // 获取操作文本
  const getActionText = (action: string) => {
    switch (action) {
      case 'increase':
        return '增加';
      case 'decrease':
        return '减少';
      case 'hold':
        return '保持';
      default:
        return action;
    }
  };

  return (
    <div style={{ padding: 24 }}>
      <h1 style={{ marginBottom: 24 }}>AI投资建议报告</h1>
      
      <Tabs activeKey={selectedTab} onChange={setSelectedTab}>
        <TabPane tab="待审核" key="pending">
          <List
            loading={loading}
            dataSource={filteredRecommendations}
            renderItem={(item) => (
              <List.Item>
                <Card
                  title={
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                      <span>{item.title}</span>
                      <Tag color={getStatusColor(item.status)}>{getStatusText(item.status)}</Tag>
                    </div>
                  }
                  extra={
                    <Button type="link" onClick={() => handleViewDetail(item)}>
                      查看详情
                    </Button>
                  }
                >
                  <p>{item.summary}</p>
                  <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 12 }}>
                    <span>生成时间：{item.createTime}</span>
                    <div>
                      <Button
                        type="primary"
                        size="small"
                        icon={<CheckOutlined />}
                        style={{ marginRight: 8 }}
                        onClick={() => handleAudit(item.id, 'approved')}
                      >
                        批准
                      </Button>
                      <Button
                        danger
                        size="small"
                        icon={<CloseOutlined />}
                        onClick={() => handleAudit(item.id, 'rejected')}
                      >
                        拒绝
                      </Button>
                    </div>
                  </div>
                </Card>
              </List.Item>
            )}
          />
        </TabPane>
        <TabPane tab="已通过" key="approved">
          <List
            loading={loading}
            dataSource={filteredRecommendations}
            renderItem={(item) => (
              <List.Item>
                <Card
                  title={
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                      <span>{item.title}</span>
                      <Tag color={getStatusColor(item.status)}>{getStatusText(item.status)}</Tag>
                    </div>
                  }
                  extra={
                    <Button type="link" onClick={() => handleViewDetail(item)}>
                      查看详情
                    </Button>
                  }
                >
                  <p>{item.summary}</p>
                  <div style={{ marginTop: 12 }}>
                    <span>生成时间：{item.createTime}</span>
                  </div>
                </Card>
              </List.Item>
            )}
          />
        </TabPane>
        <TabPane tab="已拒绝" key="rejected">
          <List
            loading={loading}
            dataSource={filteredRecommendations}
            renderItem={(item) => (
              <List.Item>
                <Card
                  title={
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                      <span>{item.title}</span>
                      <Tag color={getStatusColor(item.status)}>{getStatusText(item.status)}</Tag>
                    </div>
                  }
                  extra={
                    <Button type="link" onClick={() => handleViewDetail(item)}>
                      查看详情
                    </Button>
                  }
                >
                  <p>{item.summary}</p>
                  <div style={{ marginTop: 12 }}>
                    <span>生成时间：{item.createTime}</span>
                  </div>
                </Card>
              </List.Item>
            )}
          />
        </TabPane>
      </Tabs>

      {/* 报告详情模态框 */}
      <Modal
        title={currentReport?.title}
        open={detailModalVisible}
        onCancel={handleCloseDetail}
        footer={
          currentReport?.status === 'pending'
            ? [
                <Button key="reject" danger onClick={() => handleAudit(currentReport.id, 'rejected')}>
                  拒绝
                </Button>,
                <Button key="approve" type="primary" onClick={() => handleAudit(currentReport.id, 'approved')}>
                  批准
                </Button>,
              ]
            : [
                <Button key="close" onClick={handleCloseDetail}>
                  关闭
                </Button>,
              ]
        }
        width={900}
      >
        {currentReport && (
          <div>
            <div style={{ marginBottom: 20 }}>
              <p><strong>生成时间：</strong>{currentReport.createTime}</p>
              <p><strong>状态：</strong>
                <Tag color={getStatusColor(currentReport.status)}>{getStatusText(currentReport.status)}</Tag>
              </p>
            </div>

            <div style={{ marginBottom: 20 }}>
              <h3>建议摘要</h3>
              <p>{currentReport.summary}</p>
            </div>

            <div style={{ marginBottom: 20 }}>
              <h3>详细分析</h3>
              <p>{currentReport.content}</p>
            </div>

            <div style={{ marginBottom: 20 }}>
              <h3>具体调整建议</h3>
              <Timeline
                items={currentReport.cryptoSuggestions.map((suggestion, index) => ({
                  color: getActionColor(suggestion.action),
                  children: (
                    <div>
                      <strong>{suggestion.cryptoType}：</strong>
                      <Tag color={getActionColor(suggestion.action)}>{getActionText(suggestion.action)}</Tag>
                      <p>理由：{suggestion.reason}</p>
                      <p>
                        配置变化：{suggestion.currentAllocation}% → {suggestion.suggestedAllocation}%
                      </p>
                    </div>
                  ),
                }))}
              />
            </div>

            <div>
              <h3>关联消息</h3>
              <List
                dataSource={currentReport.relatedNews}
                renderItem={(news) => (
                  <List.Item>
                    <BellOutlined style={{ marginRight: 8 }} />
                    <span>{news.title}</span>
                    <Tag
                      style={{ marginLeft: 8 }}
                      color={
                        news.sentiment === 'positive'
                          ? 'green'
                          : news.sentiment === 'negative'
                          ? 'red'
                          : 'blue'
                      }
                    >
                      {news.sentiment === 'positive' ? '利好' : news.sentiment === 'negative' ? '利空' : '中性'}
                    </Tag>
                  </List.Item>
                )}
              />
            </div>
          </div>
        )}
      </Modal>
    </div>
  );
};

export default Recommendations;