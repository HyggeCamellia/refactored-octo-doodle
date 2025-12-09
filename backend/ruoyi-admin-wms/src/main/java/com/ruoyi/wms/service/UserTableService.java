package com.ruoyi.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.UserTableBo;
import com.ruoyi.wms.domain.entity.UserTable;
import com.ruoyi.wms.domain.vo.UserTableVo;
import com.ruoyi.wms.mapper.UserTableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户表Service业务层处理
 *
 * @author zcc
 * @date 2024-08-01
 */
@RequiredArgsConstructor
@Service
public class UserTableService {

    private final UserTableMapper userTableMapper;

    /**
     * 查询用户表(主键精准查询)
     */
    public UserTableVo queryById(Integer userId) {
        return userTableMapper.selectVoById(userId);
    }

    /**
     * 查询用户表列表（分页+模糊查询）
     */
    public TableDataInfo<UserTableVo> queryPageList(UserTableBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<UserTable> lqw = buildQueryWrapper(bo);
        Page<UserTableVo> result = userTableMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询用户表列表（模糊查询）
     */
    public List<UserTableVo> queryList(UserTableBo bo) {
        LambdaQueryWrapper<UserTable> lqw = buildQueryWrapper(bo);
        return userTableMapper.selectVoList(lqw);
    }

    /**
     * 构建查询条件
     */
    private LambdaQueryWrapper<UserTable> buildQueryWrapper(UserTableBo bo) {
        LambdaQueryWrapper<UserTable> lqw = Wrappers.lambdaQuery();
        // 主键精准查询
        lqw.eq(bo.getUserId() != null, UserTable::getUserId, bo.getUserId());
        // 用户名模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getUsername()), UserTable::getUsername, bo.getUsername());
        // 手机号模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getPhone()), UserTable::getPhone, bo.getPhone());
        // 邮箱模糊查询
        lqw.like(StringUtils.isNotBlank(bo.getEmail()), UserTable::getEmail, bo.getEmail());
        // 用户状态查询
        lqw.eq(bo.getStatus() != null, UserTable::getStatus, bo.getStatus());
        lqw.orderByDesc(BaseEntity::getCreateTime);
        return lqw;
    }

    /**
     * 新增用户表
     */
    @Transactional
    public void insertByBo(UserTableBo bo) {
        UserTable add = MapstructUtils.convert(bo, UserTable.class);
        userTableMapper.insert(add);
    }

    /**
     * 修改用户表
     */
    @Transactional
    public void updateByBo(UserTableBo bo) {
        UserTable update = MapstructUtils.convert(bo, UserTable.class);
        userTableMapper.updateById(update);
    }

    /**
     * 删除用户表
     */
    public void deleteById(Integer userId) {
        userTableMapper.deleteById(userId);
    }
}