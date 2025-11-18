# 数字货币投资辅助系统

## 系统概述

本系统是一套AI驱动的数字货币投资辅助系统，采用"AI智能层+后端服务层+前端展示层"的三层架构，旨在为投资者提供自动化、智能化的投资决策支持。

## 系统功能

### 1. 自动化数据采集
- 每日定时采集主流数字货币的利好、利空消息
- 无需人工干预的全自动化流程

### 2. 智能化分析
- 结合市场消息与当前持仓
- 使用AI分析资产配置合理性
- 生成个性化投资建议

### 3. 可视化展示
- 清晰的调整建议报告
- 数据可视化图表
- 支持管理员在线审核

### 4. 流程化管理
- 审核通过后自动更新持仓数据
- 确保数据一致性
- 完整的操作日志记录

## 技术栈

### 前端展示层
- React 18
- Ant Design 5
- UmiJS 4
- TypeScript
- Ant Design Pro Components
- Ant Design Charts

### 后端服务层
- Node.js
- Express/Koa
- MySQL数据库

### AI智能层
- Dify平台（大语言模型集成）
- 消息情感分析
- 持仓建议生成

## 系统架构

### 核心流程
1. 定时任务触发
2. Dify智能体执行消息采集
3. AI第一次分析消息（情感分析）
4. 访问后端获取当前持仓资产种类和数量
5. AI生成持仓建议报告
6. 前端展示报告供审核
7. 审核通过后后端更新持仓数据

## 页面结构

### 1. 系统概览页
- 汇总展示核心指标：未读消息数、待审核报告数、当前总资产估值
- 提供各功能模块的快速入口
- 系统状态显示

### 2. 消息列表页
- 按时间倒序展示消息
- 支持按"数字货币类型"和"利好/利空"筛选
- 消息详情查看
- 已读/未读状态管理

### 3. 持仓数据页
- 饼图展示当前资产占比
- 折线图展示近7日持仓变化
- 详细持仓列表
- 支持导出数据为Excel

### 4. 建议报告页
- AI建议核心内容展示
- 关联展示对应的原始消息
- 审核操作（批准/拒绝）
- 状态管理（待审核/已通过/已拒绝）

## 目录结构

```
src/
├── pages/
│   └── CryptoInvestment/
│       ├── Overview/        # 系统概览页
│       ├── NewsList/        # 消息列表页
│       ├── Portfolio/       # 持仓数据页
│       └── Recommendations/ # 建议报告页
├── services/
│   └── crypto.ts           # 加密货币相关API服务
└── types/
    └── crypto/             # 类型定义（可扩展）
```

## API接口设计

### 1. 系统概览
- `GET /api/crypto/overview` - 获取系统概览数据

### 2. 消息管理
- `GET /api/crypto/news` - 获取消息列表
- `PUT /api/crypto/news/{id}/read` - 标记消息已读

### 3. 持仓管理
- `GET /api/crypto/portfolio` - 获取持仓数据
- `GET /api/crypto/portfolio/changes` - 获取近7日持仓变化
- `GET /api/crypto/portfolio/export` - 导出持仓数据
- `PUT /api/crypto/portfolio/update` - 更新持仓数据

### 4. 建议报告
- `GET /api/crypto/recommendations` - 获取建议报告列表
- `GET /api/crypto/recommendations/{id}` - 获取建议报告详情
- `PUT /api/crypto/recommendations/{id}/audit` - 审核建议报告

### 5. AI分析接口
- `POST /api/crypto/ai/analyze-sentiment` - 消息情感分析
- `POST /api/crypto/ai/generate-advice` - 生成持仓建议

## 数据库设计

### 1. 消息表（crypto_news）
- id: 主键
- title: 标题
- content: 内容
- crypto_type: 数字货币类型
- sentiment: 情感倾向（positive/negative/neutral）
- publish_time: 发布时间
- source: 消息来源
- is_read: 是否已读
- created_at: 创建时间

### 2. 持仓表（crypto_portfolio）
- id: 主键
- crypto_type: 数字货币类型
- amount: 持有数量
- price: 当前价格
- value: 持仓价值
- percentage: 占比
- updated_at: 更新时间

### 3. 持仓变化历史表（crypto_portfolio_history）
- id: 主键
- date: 日期
- total_value: 总资产价值
- created_at: 创建时间

### 4. 建议报告表（crypto_recommendations）
- id: 主键
- title: 标题
- summary: 摘要
- content: 内容
- status: 状态（pending/approved/rejected）
- create_time: 创建时间
- audit_time: 审核时间
- audit_comment: 审核意见

### 5. 建议详情表（crypto_recommendation_details）
- id: 主键
- recommendation_id: 报告ID
- crypto_type: 数字货币类型
- action: 操作建议（increase/decrease/hold）
- reason: 原因说明
- current_allocation: 当前配置
- suggested_allocation: 建议配置

### 6. 报告关联消息表（crypto_recommendation_news）
- id: 主键
- recommendation_id: 报告ID
- news_id: 消息ID

## 部署说明

### 前端部署
1. 安装依赖：`npm install`
2. 构建项目：`npm run build`
3. 部署dist目录到Web服务器

### 后端部署
1. 配置数据库连接
2. 启动后端服务
3. 配置定时任务

### AI智能层配置
1. 在Dify平台创建智能体
2. 配置API密钥和访问地址
3. 设置Prompt模板

## 安全措施

1. 接口认证和权限控制
2. 数据加密传输
3. SQL注入防护
4. 敏感信息保护
5. 请求频率限制

## 未来优化方向

1. 增加更多类型的加密货币支持
2. 完善AI分析算法，提高预测准确性
3. 添加市场行情实时监控
4. 开发移动端适配版本
5. 增加投资组合回测功能