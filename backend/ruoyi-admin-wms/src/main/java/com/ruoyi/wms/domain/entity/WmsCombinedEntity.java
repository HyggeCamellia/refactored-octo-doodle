package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * WMS系统统一实体类 - 学生学习版
 * 整合了资产、投资建议、消息、持仓分析、报告和用户的所有字段
 *
 * @author student
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_combined_entity")
public class WmsCombinedEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    // ==================== 资产表相关字段 ====================

    /**
     * 资产记录唯一标识，自增主键
     */
    @TableId(value = "asset_id", type = IdType.AUTO)
    private Long assetId;

    /**
     * 资产关联用户表 user_id
     */
    private Long assetUserId;

    /**
     * 资产名称（如 Bitcoin）
     */
    private String assetName;

    /**
     * 资产简写（如比特币）
     */
    private String assetAbbreviation;

    /**
     * 资产市值
     */
    private BigDecimal assetMarketValue;

    /**
     * 资产价格
     */
    private BigDecimal assetPrice;

    /**
     * 资产流通供给量（如 19,956,521 BTC）
     */
    private String assetCirculationSupply;

    /**
     * 资产交易量（24 小时）
     */
    private BigDecimal assetVolume24h;

    /**
     * 资产%1 小时（涨跌幅）
     */
    private BigDecimal assetChange1h;

    /**
     * 资产%24 小时（涨跌幅）
     */
    private BigDecimal assetChange24h;

    /**
     * 资产%7 天（涨跌幅）
     */
    private BigDecimal assetChange7d;

    // ==================== 投资建议表相关字段 ====================

    /**
     * 建议记录唯一标识，自增主键
     */
    private Integer suggestionId;

    /**
     * 投资建议关联用户表 user_id
     */
    private Integer suggestionUserId;

    /**
     * 投资建议类型（买入、卖出、持仓等）
     */
    private String suggestionType;

    /**
     * 投资建议内容详情
     */
    private String suggestionContent;

    /**
     * 投资建议生成时间
     */
    private LocalDateTime suggestionGenerateTime;

    /**
     * 投资建议生效时间
     */
    private LocalDateTime suggestionEffectiveTime;

    /**
     * 投资建议资产名称（如 Bitcoin）
     */
    private String suggestionName;

    /**
     * 投资建议资产简写（如 BTC）
     */
    private String suggestionAbbreviation;

    /**
     * 投资建议资产市值
     */
    private BigDecimal suggestionMarkerValue;

    /**
     * 投资建议资产价格
     */
    private BigDecimal suggestionPrice;

    /**
     * 投资建议资产流通供给量
     */
    private String suggestionCirculationSupply;

    /**
     * 投资建议资产交易量（24 小时）
     */
    private BigDecimal suggestionVolume24h;

    /**
     * 投资建议资产%1 小时
     */
    private BigDecimal suggestionChange1h;

    /**
     * 投资建议资产%24 小时
     */
    private BigDecimal suggestionChange24h;

    /**
     * 投资建议资产%7 天
     */
    private BigDecimal suggestionChange7d;

    // ==================== 消息表相关字段 ====================

    /**
     * 消息唯一标识，自增主键
     */
    private Integer msgId;

    /**
     * 消息关联用户表 user_id
     */
    private Integer msgUserId;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 消息类型（系统通知、业务提醒等）
     */
    private String msgType;

    /**
     * 消息已读状态（0 - 未读，1 - 已读）
     */
    private Integer msgIsRead;

    /**
     * 消息发送时间
     */
    private LocalDateTime msgSendTime;

    // ==================== 持仓分析表相关字段 ====================

    /**
     * 持仓分析记录唯一标识，自增主键
     */
    private Integer analysisId;

    /**
     * 持仓分析关联用户表 user_id
     */
    private Integer analysisUserId;

    /**
     * 持仓分析类型（持仓分布、收益归因等）
     */
    private String analysisType;

    /**
     * 持仓分析结果详情
     */
    private String analysisResult;

    /**
     * 持仓分析生成时间
     */
    private LocalDateTime analysisGenerateTime;

    // ==================== 报告表相关字段 ====================

    /**
     * 报告唯一标识，自增主键
     */
    private Integer reportId;

    /**
     * 报告关联用户表 user_id
     */
    private Integer reportUserId;

    /**
     * 报告类型（资产报告、行为报告等）
     */
    private String reportType;

    /**
     * 报告内容
     */
    private String reportContent;

    /**
     * 报告审核状态（0 - 待审核，1 - 通过，2 - 拒绝）
     */
    private Integer reportAuditStatus;

    /**
     * 报告提交时间
     */
    private LocalDateTime reportSubmitTime;

    /**
     * 报告审核时间
     */
    private LocalDateTime reportAuditTime;

    /**
     * 报告审核人
     */
    private String reportAuditor;

    // ==================== 用户表相关字段 ====================

    /**
     * 用户唯一标识，自增主键
     */
    private Integer userId;

    /**
     * 用户名，唯一
     */
    private String username;

    /**
     * 密码（加密存储）
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态（1 - 正常，0 - 禁用）
     */
    private Integer userStatus;
}