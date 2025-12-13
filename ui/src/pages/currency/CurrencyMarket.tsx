import React, { useState, useRef } from 'react';
import { useIntl } from '@umijs/max';
import { Button, message, Modal } from 'antd';
import { ActionType, FooterToolbar, PageContainer, ProColumns, ProTable } from '@ant-design/pro-components';
import { PlusOutlined, DeleteOutlined, ExclamationCircleOutlined } from '@ant-design/icons';
import { listCombined, delCombined, addCombined, updateCombined } from '@/services/wms/combined';
import EditDrawer from '@/pages/Demo/Page2/edit';

const handleAdd = async (fields: any) => {
  const hide = message.loading('正在添加');
  try {
    const resp = await addCombined({ ...fields });
    hide();
    if (resp.code === 200) {
      message.success('添加成功');
    } else {
      message.error(resp.msg);
    }
    return true;
  } catch (error) {
    hide();
    message.error('添加失败请重试！');
    return false;
  }
};

const handleUpdate = async (fields: any) => {
  const hide = message.loading('正在更新');
  try {
    const resp = await updateCombined(fields);
    hide();
    if (resp.code === 200) {
      message.success('更新成功');
    } else {
      message.error(resp.msg);
    }
    return true;
  } catch (error) {
    hide();
    message.error('更新失败请重试！');
    return false;
  }
};

const handleRemove = async (selectedRows: any[]) => {
  const hide = message.loading('正在删除');
  if (!selectedRows) return true;
  try {
    // 由于后端可能只支持单个删除，这里循环删除
    for (const row of selectedRows) {
      await delCombined(String(row.assetId));
    }
    hide();
    message.success('删除成功，即将刷新');
    return true;
  } catch (error) {
    hide();
    message.error('删除失败，请重试');
    return false;
  }
};

const CurrencyMarket: React.FC = () => {
  const [drawerVisible, setDrawerVisible] = useState<boolean>(false);
  const actionRef = useRef<ActionType>();
  const [currentRow, setCurrentRow] = useState<any>();
  const [selectedRows, setSelectedRows] = useState<any[]>([]);

  const columns: ProColumns<any>[] = [
    // 资产表字段 - 虚拟货币行情相关
    {
      title: '资产ID',
      dataIndex: 'assetId',
      valueType: 'text',
      width: 80,
    },
    {
      title: '虚拟货币名称',
      dataIndex: 'assetName',
      valueType: 'text',
      search: true,
    },
    {
      title: '货币简写',
      dataIndex: 'assetAbbreviation',
      valueType: 'text',
    },
    {
      title: '当前价格',
      dataIndex: 'assetPrice',
      valueType: 'text',
    },
    {
      title: '市值',
      dataIndex: 'assetMarketValue',
      valueType: 'text',
    },
    {
      title: '24小时涨跌幅',
      dataIndex: 'assetChange24h',
      valueType: 'text',
      render: (_, record) => {
        const value = record.assetChange24h;
        if (!value) return '-';
        return (
          <span style={{ color: value > 0 ? '#f5222d' : value < 0 ? '#52c41a' : '#8c8c8c' }}>
            {value > 0 ? '+' : ''}{value}%
          </span>
        );
      },
    },
    // 投资建议表字段
    {
      title: '投资建议类型',
      dataIndex: 'suggestionType',
      valueType: 'text',
    },
    {
      title: '建议内容',
      dataIndex: 'suggestionContent',
      valueType: 'text',
      ellipsis: true,
      width: 200,
    },
    // 用户表字段
    {
      title: '用户名',
      dataIndex: 'username',
      valueType: 'text',
      search: true,
    },
    {
      title: '手机号',
      dataIndex: 'phone',
      valueType: 'text',
    },
    {
      title: '用户状态',
      dataIndex: 'status',
      valueType: 'select',
      valueEnum: {
        1: { text: '正常', status: 'Success' },
        0: { text: '禁用', status: 'Default' },
      },
    },
    // 操作列
    {
      title: '操作',
      dataIndex: 'option',
      width: '180px',
      valueType: 'option',
      render: (_, record) => [
        <Button
          type="link"
          size="small"
          key="edit"
          onClick={() => {
            setCurrentRow(record);
            setDrawerVisible(true);
          }}
        >
          修改
        </Button>,
        <Button
          type="link"
          size="small"
          danger
          key="delete"
          onClick={async () => {
            Modal.confirm({
              title: '删除',
              content: `确认删除虚拟货币【${record.assetName}】吗？`,
              okText: '确认',
              cancelText: '取消',
              onOk: async () => {
                const success = await handleRemove([record]);
                if (success && actionRef.current) {
                  actionRef.current.reload();
                }
              },
            });
          }}
        >
          删除
        </Button>,
      ],
    },
  ];

  return (
    <PageContainer title="虚拟货币行情管理">
      <ProTable<any>
        actionRef={actionRef}
        rowKey="assetId"
        search={{
          labelWidth: 120,
        }}
        toolBarRender={() => [
          <Button
            type="primary"
            key="add"
            onClick={() => {
              setCurrentRow(undefined);
              setDrawerVisible(true);
            }}
          >
            <PlusOutlined /> 新增虚拟货币
          </Button>,
        ]}
        request={async (params) => {
          const res = await listCombined({
            ...params,
            current: String(params.current),
            pageSize: String(params.pageSize),
          });
          return {
            data: res.rows || [],
            total: res.total || 0,
            success: true,
          };
        }}
        columns={columns}
        rowSelection={{
          onChange: (_, selectedRows) => {
            setSelectedRows(selectedRows);
          },
        }}
      />

      {selectedRows?.length > 0 && (
        <FooterToolbar
          extra={
            <div>
              已选择 <a style={{ fontWeight: 600 }}>{selectedRows.length}</a> 项
            </div>
          }
        >
          <Button
            danger
            key="batchRemove"
            onClick={async () => {
              Modal.confirm({
                title: '是否确认删除所选数据项?',
                icon: <ExclamationCircleOutlined />,
                content: '请谨慎操作',
                async onOk() {
                  const success = await handleRemove(selectedRows);
                  if (success) {
                    setSelectedRows([]);
                    actionRef.current?.reloadAndRest?.();
                  }
                },
                onCancel() { },
              });
            }}
          >
            <DeleteOutlined /> 批量删除
          </Button>
        </FooterToolbar>
      )}

      <EditDrawer
        onSubmit={async (values) => {
          let success = false;
          if (values.assetId) {
            success = await handleUpdate(values);
          } else {
            success = await handleAdd(values);
          }
          if (success) {
            setDrawerVisible(false);
            setCurrentRow(undefined);
            if (actionRef.current) {
              actionRef.current.reload();
            }
          }
        }}
        onClose={() => {
          setDrawerVisible(false);
          setCurrentRow(undefined);
        }}
        visible={drawerVisible}
        values={currentRow || {}}
      />
    </PageContainer>
  );
};

export default CurrencyMarket;