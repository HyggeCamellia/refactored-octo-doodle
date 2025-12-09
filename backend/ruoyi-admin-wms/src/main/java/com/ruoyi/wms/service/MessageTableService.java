package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.MessageTableBo;
import com.ruoyi.wms.domain.entity.MessageTable;
import com.ruoyi.wms.domain.vo.MessageTableVo;
import com.ruoyi.wms.mapper.MessageTableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 消息表Service业务层处理
 *
 * @author zcc
 * @date 2024-08-01
 */
@RequiredArgsConstructor
@Service
public class MessageTableService {

    private final MessageTableMapper messageTableMapper;

    /**
     * 查询消息表(主键精准查询)
     */
    public MessageTableVo queryById(Integer msgId) {
        return messageTableMapper.selectVoById(msgId);
    }

    /**
     * 查询消息表列表
     */
    public TableDataInfo<MessageTableVo> queryPageList(MessageTableBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MessageTable> lqw = buildQueryWrapper(bo);
        Page<MessageTableVo> result = messageTableMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询消息表列表
     */
    public List<MessageTableVo> queryList(MessageTableBo bo) {
        LambdaQueryWrapper<MessageTable> lqw = buildQueryWrapper(bo);
        return messageTableMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MessageTable> buildQueryWrapper(MessageTableBo bo) {
        LambdaQueryWrapper<MessageTable> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(bo.getMsgId() != null, MessageTable::getMsgId, bo.getMsgId());
        // 用户ID查询
        lqw.eq(bo.getUserId() != null, MessageTable::getUserId, bo.getUserId());
        // 消息内容模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getContent()), MessageTable::getContent, bo.getContent());
        // 消息类型查询
        lqw.eq(StringUtils.isNotBlank(bo.getType()), MessageTable::getType, bo.getType());
        // 已读状态查询
        lqw.eq(bo.getIsRead() != null, MessageTable::getIsRead, bo.getIsRead());
        // 发送时间查询
        lqw.eq(bo.getSendTime() != null, MessageTable::getSendTime, bo.getSendTime());
        lqw.orderByDesc(BaseEntity::getCreateTime);
        return lqw;
    }

    /**
     * 新增消息表
     */
    @Transactional
    public void insertByBo(MessageTableBo bo) {
        MessageTable add = MapstructUtils.convert(bo, MessageTable.class);
        messageTableMapper.insert(add);
    }

    /**
     * 修改消息表
     */
    @Transactional
    public void updateByBo(MessageTableBo bo) {
        MessageTable update = MapstructUtils.convert(bo, MessageTable.class);
        messageTableMapper.updateById(update);
    }

    /**
     * 删除消息表
     */
    public void deleteById(Integer msgId) {
        messageTableMapper.deleteById(msgId);
    }
}
