import React, { useEffect } from 'react';
import { ProForm, ProFormText, ProFormSelect, ProFormDateTimePicker, ProFormDigit } from '@ant-design/pro-components';
import { Form, Drawer, Button } from 'antd';

export type CombinedFormData = Record<string, unknown> & Partial<any>;

export type EditDrawerProps = {
  onSubmit: (values: CombinedFormData) => Promise<void>;
  onClose: () => void;
  visible: boolean;
  values: Partial<any>;
};

const EditDrawer: React.FC<EditDrawerProps> = (props) => {
  const [form] = Form.useForm();
  
  useEffect(() => {
    form.resetFields();
    form.setFieldsValue({
      // 资产表字段
      assetId: props.values.assetId,
      assetUserId: props.values.assetUserId,
      assetName: props.values.assetName,
      assetAbbreviation: props.values.assetAbbreviation,
      assetMarketValue: props.values.assetMarketValue,
      assetPrice: props.values.assetPrice,
      assetCirculationSupply: props.values.assetCirculationSupply,
      assetVolume24h: props.values.assetVolume24h,
      assetChange1h: props.values.assetChange1h,
      assetChange24h: props.values.assetChange24h,
      assetChange7d: props.values.assetChange7d,
      
      // 投资建议表字段
      suggestionId: props.values.suggestionId,
      suggestionUserId: props.values.suggestionUserId,
      suggestionType: props.values.suggestionType,
      suggestionContent: props.values.suggestionContent,
      suggestionGenerateTime: props.values.suggestionGenerateTime,
      suggestionEffectiveTime: props.values.suggestionEffectiveTime,
      suggestionName: props.values.suggestionName,
      suggestionAbbreviation: props.values.suggestionAbbreviation,
      suggestionMarkerValue: props.values.suggestionMarkerValue,
      suggestionPrice: props.values.suggestionPrice,
      suggestionCirculationSupply: props.values.suggestionCirculationSupply,
      suggestionVolume24h: props.values.suggestionVolume24h,
      suggestionChange1h: props.values.suggestionChange1h,
      suggestionChange24h: props.values.suggestionChange24h,
      suggestionChange7d: props.values.suggestionChange7d,
      
      // 消息表字段
      msgId: props.values.msgId,
      msgUserId: props.values.msgUserId,
      msgContent: props.values.msgContent,
      msgType: props.values.msgType,
      msgIsRead: props.values.msgIsRead,
      msgSendTime: props.values.msgSendTime,
      
      // 持仓分析表字段
      analysisId: props.values.analysisId,
      analysisUserId: props.values.analysisUserId,
      analysisType: props.values.analysisType,
      analysisResult: props.values.analysisResult,
      analysisGenerateTime: props.values.analysisGenerateTime,
      
      // 报告表字段
      reportId: props.values.reportId,
      reportUserId: props.values.reportUserId,
      reportType: props.values.reportType,
      reportContent: props.values.reportContent,
      reportAuditStatus: props.values.reportAuditStatus,
      reportSubmitTime: props.values.reportSubmitTime,
      reportAuditTime: props.values.reportAuditTime,
      reportAuditor: props.values.reportAuditor,
      
      // 用户表字段
      userId: props.values.userId,
      username: props.values.username,
      password: props.values.password,
      phone: props.values.phone,
      email: props.values.email,
      status: props.values.status,
    });
  }, [form, props]);

  const handleFinish = async (values: Record<string, any>) => {
    props.onSubmit(values as CombinedFormData);
  };

  return (
    <Drawer
      width={800}
      title={props.values.assetId ? '修改合并数据' : '新增合并数据'}
      open={props.visible}
      onClose={props.onClose}
      destroyOnClose
      footer={
        <div style={{ textAlign: 'right' }}>
          <Button onClick={props.onClose} style={{ marginRight: 8 }}>
            取消
          </Button>
          <Button type="primary" onClick={() => form.submit()}>
            确定
          </Button>
        </div>
      }
    >
      <ProForm 
        form={form}
        submitter={false}
        layout="horizontal"
        onFinish={handleFinish}
      >
        {/* 资产表字段 */}
        <ProFormText
          name="assetId"
          label="资产ID"
          hidden
          disabled
        />
        <ProFormText
          name="assetName"
          label="资产名称"
          width="xl"
          placeholder="请输入资产名称"
        />
        <ProFormText
          name="assetAbbreviation"
          label="资产简写"
          width="xl"
          placeholder="请输入资产简写"
        />
        <ProFormDigit
          name="assetPrice"
          label="资产价格"
          width="xl"
          placeholder="请输入资产价格"
        />
        <ProFormDigit
          name="assetMarketValue"
          label="资产市值"
          width="xl"
          placeholder="请输入资产市值"
        />
        
        {/* 投资建议表字段 */}
        <ProFormText
          name="suggestionType"
          label="建议类型"
          width="xl"
          placeholder="请输入建议类型（买入、卖出、持仓等）"
        />
        <ProFormText
          name="suggestionContent"
          label="建议内容"
          width="xl"
          placeholder="请输入建议内容详情"
        />
        <ProFormDateTimePicker
          name="suggestionGenerateTime"
          label="生成时间"
          width="xl"
        />
        <ProFormDateTimePicker
          name="suggestionEffectiveTime"
          label="生效时间"
          width="xl"
        />
        
        {/* 消息表字段 */}
        <ProFormText
          name="msgContent"
          label="消息内容"
          width="xl"
          placeholder="请输入消息内容"
        />
        <ProFormText
          name="msgType"
          label="消息类型"
          width="xl"
          placeholder="请输入消息类型（系统通知、业务提醒等）"
        />
        <ProFormSelect
          name="msgIsRead"
          label="已读状态"
          width="xl"
          options={[
            { label: '未读', value: 0 },
            { label: '已读', value: 1 },
          ]}
        />
        
        {/* 用户表字段 */}
        <ProFormText
          name="username"
          label="用户名"
          width="xl"
          placeholder="请输入用户名"
        />
        <ProFormText
          name="phone"
          label="手机号"
          width="xl"
          placeholder="请输入手机号"
        />
        <ProFormText
          name="email"
          label="邮箱"
          width="xl"
          placeholder="请输入邮箱"
        />
        <ProFormSelect
          name="status"
          label="用户状态"
          width="xl"
          options={[
            { label: '正常', value: 1 },
            { label: '禁用', value: 0 },
          ]}
        />
      </ProForm>
    </Drawer>
  );
};

export default EditDrawer;
