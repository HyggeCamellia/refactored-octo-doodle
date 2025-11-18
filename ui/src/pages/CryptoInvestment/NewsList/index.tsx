import React, { useState, useEffect } from 'react';
import { Table, Card, Row, Col, Select, DatePicker, Tag, Button, Modal, message } from 'antd';
import { SearchOutlined, FileTextOutlined, CalendarOutlined, FilterOutlined } from '@ant-design/icons';
import type { ColumnsType } from 'antd/es/table';
import type { RangePickerProps } from 'antd/es/date-picker';
import dayjs from 'dayjs';

interface NewsItem {
  id: string;
  title: string;
  content: string;
  cryptoType: string;
  sentiment: 'positive' | 'negative' | 'neutral';
  publishTime: string;
  source: string;
  isRead: boolean;
}

const { RangePicker } = DatePicker;
const { Option } = Select;

const NewsList: React.FC = () => {
  const [newsList, setNewsList] = useState<NewsItem[]>([]);
  const [filteredList, setFilteredList] = useState<NewsItem[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [selectedCrypto, setSelectedCrypto] = useState<string>('');
  const [selectedSentiment, setSelectedSentiment] = useState<string>('');
  const [dateRange, setDateRange] = useState<RangePickerProps['value']>([]);
  const [searchText, setSearchText] = useState<string>('');
  const [detailModalVisible, setDetailModalVisible] = useState<boolean>(false);
  const [currentNews, setCurrentNews] = useState<NewsItem | null>(null);

  // 模拟数据
  const mockNewsData: NewsItem[] = [
    {
      id: '1',
      title: '比特币突破10万美元大关，创历史新高',
      content: '据市场数据显示，比特币价格在今日突破10万美元大关，创下历史新高。分析师认为，机构投资者的持续入场和宏观经济因素是推动价格上涨的主要原因。',
      cryptoType: '比特币',
      sentiment: 'positive',
      publishTime: '2025-11-11 10:30:00',
      source: 'CoinDesk',
      isRead: false,
    },
    {
      id: '2',
      title: '以太坊网络升级延迟，社区担忧',
      content: '原定于下周进行的以太坊网络升级因技术问题被推迟，社区对此表示担忧。部分开发者认为这可能影响ETH的短期价格表现。',
      cryptoType: '以太坊',
      sentiment: 'negative',
      publishTime: '2025-11-11 09:15:00',
      source: 'CryptoSlate',
      isRead: false,
    },
    {
      id: '3',
      title: '监管机构发布加密货币监管框架草案',
      content: '某国监管机构今日发布加密货币监管框架草案，旨在规范市场秩序，保护投资者权益。业内人士认为这将有助于行业长期健康发展。',
      cryptoType: '全部',
      sentiment: 'neutral',
      publishTime: '2025-11-10 16:45:00',
      source: '监管公告',
      isRead: true,
    },
    {
      id: '4',
      title: 'Solana生态系统活跃度持续增长',
      content: 'Solana网络的日活跃地址数和交易量均呈现增长趋势，生态系统中的DeFi和NFT项目数量也在稳步增加。',
      cryptoType: 'Solana',
      sentiment: 'positive',
      publishTime: '2025-11-10 14:20:00',
      source: 'Blockworks',
      isRead: true,
    },
    {
      id: '5',
      title: '央行数字货币研究取得新进展',
      content: '多国央行在数字货币研究方面取得新进展，部分国家已进入试点阶段。专家表示这可能对私人加密货币市场产生深远影响。',
      cryptoType: '全部',
      sentiment: 'neutral',
      publishTime: '2025-11-09 11:50:00',
      source: '金融时报',
      isRead: false,
    },
  ];

  // 获取消息列表
  const fetchNewsList = async () => {
    try {
      setLoading(true);
      // 这里应该调用真实API
      // const response = await fetchCryptoNews();
      // 模拟数据
      setTimeout(() => {
        setNewsList(mockNewsData);
        setFilteredList(mockNewsData);
        setLoading(false);
      }, 500);
    } catch (error) {
      message.error('获取消息列表失败');
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchNewsList();
  }, []);

  // 筛选功能
  useEffect(() => {
    let filtered = [...newsList];

    // 按加密货币类型筛选
    if (selectedCrypto) {
      filtered = filtered.filter(item => item.cryptoType === selectedCrypto || item.cryptoType === '全部');
    }

    // 按情感倾向筛选
    if (selectedSentiment) {
      filtered = filtered.filter(item => item.sentiment === selectedSentiment);
    }

    // 按日期范围筛选
    if (dateRange && dateRange.length === 2) {
      const startDate = dayjs(dateRange[0]).startOf('day');
      const endDate = dayjs(dateRange[1]).endOf('day');
      filtered = filtered.filter(item => {
        const itemDate = dayjs(item.publishTime);
        return itemDate.isAfter(startDate) && itemDate.isBefore(endDate);
      });
    }

    // 按搜索文本筛选
    if (searchText) {
      const text = searchText.toLowerCase();
      filtered = filtered.filter(
        item => item.title.toLowerCase().includes(text) || item.content.toLowerCase().includes(text)
      );
    }

    setFilteredList(filtered);
  }, [newsList, selectedCrypto, selectedSentiment, dateRange, searchText]);

  // 查看消息详情
  const handleViewDetail = (record: NewsItem) => {
    setCurrentNews(record);
    setDetailModalVisible(true);
    // 标记为已读
    if (!record.isRead) {
      const updatedList = newsList.map(item => 
        item.id === record.id ? { ...item, isRead: true } : item
      );
      setNewsList(updatedList);
    }
  };

  // 关闭详情模态框
  const handleCloseDetail = () => {
    setDetailModalVisible(false);
    setCurrentNews(null);
  };

  // 列配置
  const columns: ColumnsType<NewsItem> = [
    {
      title: '标题',
      dataIndex: 'title',
      key: 'title',
      render: (title, record) => (
        <span style={{ fontWeight: record.isRead ? 'normal' : 'bold' }} onClick={() => handleViewDetail(record)}>
          {title}
        </span>
      ),
    },
    {
      title: '数字货币类型',
      dataIndex: 'cryptoType',
      key: 'cryptoType',
    },
    {
      title: '情感倾向',
      dataIndex: 'sentiment',
      key: 'sentiment',
      render: (sentiment) => {
        let color = '';
        let text = '';
        switch (sentiment) {
          case 'positive':
            color = 'green';
            text = '利好';
            break;
          case 'negative':
            color = 'red';
            text = '利空';
            break;
          default:
            color = 'blue';
            text = '中性';
        }
        return <Tag color={color}>{text}</Tag>;
      },
    },
    {
      title: '发布时间',
      dataIndex: 'publishTime',
      key: 'publishTime',
    },
    {
      title: '来源',
      dataIndex: 'source',
      key: 'source',
    },
    {
      title: '操作',
      key: 'action',
      render: (_, record) => (
        <Button type="link" onClick={() => handleViewDetail(record)}>
          查看详情
        </Button>
      ),
    },
  ];

  return (
    <div style={{ padding: 24 }}>
      <h1 style={{ marginBottom: 24 }}>数字货币消息列表</h1>
      
      <Card>
        <Row gutter={[16, 16]}>
          <Col xs={24} sm={8} md={6}>
            <Select
              placeholder="选择数字货币类型"
              allowClear
              style={{ width: '100%' }}
              value={selectedCrypto}
              onChange={setSelectedCrypto}
            >
              <Option value="比特币">比特币</Option>
              <Option value="以太坊">以太坊</Option>
              <Option value="Solana">Solana</Option>
              <Option value="全部">全部</Option>
            </Select>
          </Col>
          <Col xs={24} sm={8} md={6}>
            <Select
              placeholder="选择情感倾向"
              allowClear
              style={{ width: '100%' }}
              value={selectedSentiment}
              onChange={setSelectedSentiment}
            >
              <Option value="positive">利好</Option>
              <Option value="negative">利空</Option>
              <Option value="neutral">中性</Option>
            </Select>
          </Col>
          <Col xs={24} sm={8} md={8}>
            <RangePicker
              placeholder={['开始日期', '结束日期']}
              style={{ width: '100%' }}
              value={dateRange}
              onChange={(dates) => setDateRange(dates)}
            />
          </Col>
        </Row>
      </Card>

      <Table
        columns={columns}
        dataSource={filteredList}
        rowKey="id"
        loading={loading}
        pagination={{ pageSize: 10 }}
        style={{ marginTop: 24 }}
      />

      {/* 消息详情模态框 */}
      <Modal
        title={currentNews?.title}
        open={detailModalVisible}
        onCancel={handleCloseDetail}
        footer={[
          <Button key="close" onClick={handleCloseDetail}>
            关闭
          </Button>,
        ]}
        width={800}
      >
        {currentNews && (
          <div>
            <p><strong>发布时间：</strong>{currentNews.publishTime}</p>
            <p><strong>来源：</strong>{currentNews.source}</p>
            <p><strong>数字货币类型：</strong>{currentNews.cryptoType}</p>
            <p><strong>情感倾向：</strong>
              {currentNews.sentiment === 'positive' && <Tag color="green">利好</Tag>}
              {currentNews.sentiment === 'negative' && <Tag color="red">利空</Tag>}
              {currentNews.sentiment === 'neutral' && <Tag color="blue">中性</Tag>}
            </p>
            <div style={{ marginTop: 20 }}>
              <h3>内容详情</h3>
              <p>{currentNews.content}</p>
            </div>
          </div>
        )}
      </Modal>
    </div>
  );
};

export default NewsList;