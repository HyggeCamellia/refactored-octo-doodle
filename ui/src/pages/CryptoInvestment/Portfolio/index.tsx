import React, { useState, useEffect } from 'react';
import { Card, Row, Col, Button, message, Table } from 'antd';
import { PieChartOutlined, LineChartOutlined, DownloadOutlined } from '@ant-design/icons';
import { Pie, Line } from '@ant-design/plots';
import type { ColumnsType } from 'antd/es/table';

interface PortfolioItem {
  id: string;
  cryptoType: string;
  amount: number;
  price: number;
  value: number;
  percentage: number;
}

interface DailyChange {
  date: string;
  totalValue: number;
}

const Portfolio: React.FC = () => {
  const [portfolioData, setPortfolioData] = useState<PortfolioItem[]>([]);
  const [dailyChanges, setDailyChanges] = useState<DailyChange[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  // 模拟数据
  const mockPortfolioData: PortfolioItem[] = [
    {
      id: '1',
      cryptoType: '比特币',
      amount: 0.5,
      price: 100000,
      value: 50000,
      percentage: 50,
    },
    {
      id: '2',
      cryptoType: '以太坊',
      amount: 5,
      price: 5000,
      value: 25000,
      percentage: 25,
    },
    {
      id: '3',
      cryptoType: 'Solana',
      amount: 100,
      price: 200,
      value: 20000,
      percentage: 20,
    },
    {
      id: '4',
      cryptoType: '其他',
      amount: 0,
      price: 0,
      value: 5000,
      percentage: 5,
    },
  ];

  const mockDailyChanges: DailyChange[] = [
    { date: '2025-11-05', totalValue: 95000 },
    { date: '2025-11-06', totalValue: 98000 },
    { date: '2025-11-07', totalValue: 97500 },
    { date: '2025-11-08', totalValue: 102000 },
    { date: '2025-11-09', totalValue: 103000 },
    { date: '2025-11-10', totalValue: 104000 },
    { date: '2025-11-11', totalValue: 100000 },
  ];

  // 获取持仓数据
  const fetchPortfolioData = async () => {
    try {
      setLoading(true);
      // 这里应该调用真实API
      // const portfolioResponse = await fetchPortfolio();
      // const changesResponse = await fetchDailyChanges();
      // 模拟数据
      setTimeout(() => {
        setPortfolioData(mockPortfolioData);
        setDailyChanges(mockDailyChanges);
        setLoading(false);
      }, 500);
    } catch (error) {
      message.error('获取持仓数据失败');
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchPortfolioData();
  }, []);

  // 导出Excel功能
  const handleExportExcel = () => {
    // 这里应该实现真实的导出逻辑
    message.success('数据导出成功');
  };

  // 饼图配置
  const pieConfig = {
    data: portfolioData.map(item => ({
      type: item.cryptoType,
      value: item.value,
    })),
    angleField: 'value',
    colorField: 'type',
    radius: 0.8,
    label: {
      type: 'outer',
      content: '{name} {percentage}',
    },
    interactions: [
      {
        type: 'element-selected',
      },
      {
        type: 'element-active',
      },
    ],
  };

  // 折线图配置
  const lineConfig = {
    data: dailyChanges,
    xField: 'date',
    yField: 'totalValue',
    point: {
      size: 5,
      shape: 'diamond',
    },
    tooltip: {
      formatter: (datum: DailyChange) => {
        return {
          name: '总资产估值',
          value: `¥${datum.totalValue.toLocaleString()}`,
        };
      },
    },
  };

  // 表格列配置
  const columns: ColumnsType<PortfolioItem> = [
    {
      title: '数字货币类型',
      dataIndex: 'cryptoType',
      key: 'cryptoType',
    },
    {
      title: '持有数量',
      dataIndex: 'amount',
      key: 'amount',
      render: (amount) => amount.toFixed(4),
    },
    {
      title: '当前价格 (¥)',
      dataIndex: 'price',
      key: 'price',
      render: (price) => price.toLocaleString(),
    },
    {
      title: '持仓价值 (¥)',
      dataIndex: 'value',
      key: 'value',
      render: (value) => value.toLocaleString(),
    },
    {
      title: '占比',
      dataIndex: 'percentage',
      key: 'percentage',
      render: (percentage) => `${percentage}%`,
    },
  ];

  // 计算总资产
  const totalAssets = portfolioData.reduce((sum, item) => sum + item.value, 0);

  return (
    <div style={{ padding: 24 }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 24 }}>
        <h1>持仓数据分析</h1>
        <Button type="primary" icon={<DownloadOutlined />} onClick={handleExportExcel}>
          导出Excel
        </Button>
      </div>

      <Row gutter={[16, 16]}>
        <Col xs={24} md={12}>
          <Card title="资产分布占比" extra={<PieChartOutlined />} loading={loading}>
            <div style={{ height: 400 }}>
              <Pie {...pieConfig} />
            </div>
          </Card>
        </Col>
        <Col xs={24} md={12}>
          <Card title="近7日持仓变化" extra={<LineChartOutlined />} loading={loading}>
            <div style={{ height: 400 }}>
              <Line {...lineConfig} />
            </div>
          </Card>
        </Col>
      </Row>

      <Card title="持仓明细" style={{ marginTop: 24 }} loading={loading}>
        <div style={{ marginBottom: 16 }}>
          <strong>总资产估值：</strong>
          <span style={{ fontSize: 24, color: '#1890ff' }}>¥{totalAssets.toLocaleString()}</span>
        </div>
        <Table
          columns={columns}
          dataSource={portfolioData}
          rowKey="id"
          pagination={false}
        />
      </Card>
    </div>
  );
};

export default Portfolio;