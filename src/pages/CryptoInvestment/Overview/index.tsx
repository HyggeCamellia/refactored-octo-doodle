import React, { useState, useEffect } from 'react';
import { Card, Statistic, Row, Col, Button, message } from 'antd';
import { BellOutlined, FileTextOutlined, PieChartOutlined, DollarOutlined } from '@ant-design/icons';
import type { CardProps } from 'antd';
import { Link } from 'umi';

interface OverviewData {
  unreadNewsCount: number;
  pendingReportsCount: number;
  totalAssetsValue: number;
}

const CryptoOverview: React.FC = () => {
  const [overviewData, setOverviewData] = useState<OverviewData>({
    unreadNewsCount: 0,
    pendingReportsCount: 0,
    totalAssetsValue: 0,
  });
  const [loading, setLoading] = useState<boolean>(true);

  // 模拟获取数据
  const fetchOverviewData = async () => {
    try {
      setLoading(true);
      // 这里应该调用真实API
      // const response = await fetchCryptoOverview();
      // 模拟数据
      setTimeout(() => {
        setOverviewData({
          unreadNewsCount: 12,
          pendingReportsCount: 3,
          totalAssetsValue: 15689.50,
        });
        setLoading(false);
      }, 500);
    } catch (error) {
      message.error('获取数据失败');
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchOverviewData();
  }, []);

  const cardItems: CardProps[] = [
    {
      title: '未读消息',
      icon: <BellOutlined style={{ color: '#1890ff' }} />,
      count: overviewData.unreadNewsCount,
      color: '#1890ff',
      suffix: '条',
      route: '/crypto/news-list',
    },
    {
      title: '待审核报告',
      icon: <FileTextOutlined style={{ color: '#f5222d' }} />,
      count: overviewData.pendingReportsCount,
      color: '#f5222d',
      suffix: '份',
      route: '/crypto/recommendations',
    },
    {
      title: '总资产估值',
      icon: <DollarOutlined style={{ color: '#52c41a' }} />,
      count: overviewData.totalAssetsValue,
      color: '#52c41a',
      precision: 2,
      prefix: '¥',
      route: '/crypto/portfolio',
    },
  ];

  return (
    <div style={{ padding: 24 }}>
      <h1 style={{ marginBottom: 24 }}>数字货币投资辅助系统</h1>
      
      <Row gutter={[16, 16]}>
        {cardItems.map((card, index) => (
          <Col xs={24} sm={12} md={8} key={index}>
            <Card>
              <Statistic
                title={card.title}
                value={card.count}
                prefix={card.icon}
                suffix={card.suffix}
                precision={card.precision}
                valueStyle={{ color: card.color }}
                loading={loading}
              />
              <div style={{ marginTop: 16, textAlign: 'center' }}>
                <Link to={card.route}>
                  <Button type="primary" size="small">
                    查看详情
                  </Button>
                </Link>
              </div>
            </Card>
          </Col>
        ))}
      </Row>

      <Row gutter={[16, 16]} style={{ marginTop: 24 }}>
        <Col xs={24} sm={8}>
          <Card title="快速入口">
            <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
              <Link to="/crypto/news-list">
                <Button type="default" icon={<BellOutlined />} block>
                  消息管理
                </Button>
              </Link>
              <Link to="/crypto/portfolio">
                <Button type="default" icon={<PieChartOutlined />} block>
                  持仓分析
                </Button>
              </Link>
              <Link to="/crypto/recommendations">
                <Button type="default" icon={<FileTextOutlined />} block>
                  投资建议
                </Button>
              </Link>
            </div>
          </Card>
        </Col>
        <Col xs={24} sm={16}>
          <Card title="系统状态">
            <div style={{ padding: 20 }}>
              <p style={{ margin: 0, fontSize: 16 }}>最近更新: 2025-11-11 16:30</p>
              <p style={{ margin: '12 0', fontSize: 16 }}>AI分析引擎: 正常运行</p>
              <p style={{ margin: 0, fontSize: 16 }}>数据同步状态: 已同步</p>
            </div>
          </Card>
        </Col>
      </Row>
    </div>
  );
};

export default CryptoOverview;