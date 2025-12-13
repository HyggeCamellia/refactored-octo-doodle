package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 合并后的WMS系统视图对象
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
public class WmsCombinedVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

    // ========== 资产表字段 ==========
    /**
     * 资产记录唯一标识，自增主键
     */
    @ExcelProperty(value = "资产记录唯一标识")
    private Long assetId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "资产表用户ID")
    private Long assetUserId;

    /**
     * 名称（如 Bitcoin）
     */
    @ExcelProperty(value = "资产名称")
    private String assetName;

    /**
     * 简写（如比特币）
     */
    @ExcelProperty(value = "资产简写")
    private String assetAbbreviation;

    /**
     * 市值
     */
    @ExcelProperty(value = "资产市值")
    private BigDecimal assetMarketValue;

    /**
     * 价格（替代原current_price）
     */
    @ExcelProperty(value = "资产价格")
    private BigDecimal assetPrice;

    /**
     * 流通供给量（如 19,956,521 BTC）
     */
    @ExcelProperty(value = "资产流通供给量")
    private String assetCirculationSupply;

    /**
     * 交易量（24 小时）
     */
    @ExcelProperty(value = "资产24小时交易量")
    private BigDecimal assetVolume24h;

    /**
     * %1 小时（涨跌幅）
     */
    @ExcelProperty(value = "资产1小时涨跌幅")
    private BigDecimal assetChange1h;

    /**
     * %24 小时（涨跌幅）
     */
    @ExcelProperty(value = "资产24小时涨跌幅")
    private BigDecimal assetChange24h;

    /**
     * %7 天（涨跌幅）
     */
    @ExcelProperty(value = "资产7天涨跌幅")
    private BigDecimal assetChange7d;

    // ========== 投资建议表字段 ==========
    /**
     * 建议记录唯一标识，自增主键
     */
    @ExcelProperty(value = "建议记录唯一标识")
    private Integer suggestionId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "建议表用户ID")
    private Integer suggestionUserId;

    /**
     * 建议类型（买入、卖出、持仓等）
     */
    @ExcelProperty(value = "建议类型")
    private String suggestionType;

    /**
     * 建议内容详情
     */
    @ExcelProperty(value = "建议内容详情")
    private String suggestionContent;

    /**
     * 生成时间
     */
    @ExcelProperty(value = "建议生成时间")
    private LocalDateTime suggestionGenerateTime;

    /**
     * 生效时间
     */
    @ExcelProperty(value = "建议生效时间")
    private LocalDateTime suggestionEffectiveTime;

    /**
     * 名称（如 Bitcoin）
     */
    @ExcelProperty(value = "建议资产名称")
    private String suggestionName;

    /**
     * 简写（如 BTC）
     */
    @ExcelProperty(value = "建议资产简写")
    private String suggestionAbbreviation;

    /**
     * 市值
     */
    @ExcelProperty(value = "建议资产市值")
    private BigDecimal suggestionMarkerValue;

    /**
     * 价格
     */
    @ExcelProperty(value = "建议资产价格")
    private BigDecimal suggestionPrice;

    /**
     * 流通供给量
     */
    @ExcelProperty(value = "建议资产流通供给量")
    private String suggestionCirculationSupply;

    /**
     * 交易量（24 小时）
     */
    @ExcelProperty(value = "建议资产24小时交易量")
    private BigDecimal suggestionVolume24h;

    /**
     * %1 小时
     */
    @ExcelProperty(value = "建议资产1小时涨跌幅")
    private BigDecimal suggestionChange1h;

    /**
     * %24 小时
     */
    @ExcelProperty(value = "建议资产24小时涨跌幅")
    private BigDecimal suggestionChange24h;

    /**
     * %7 天
     */
    @ExcelProperty(value = "建议资产7天涨跌幅")
    private BigDecimal suggestionChange7d;

    // ========== 消息表字段 ==========
    /**
     * 消息唯一标识，自增主键
     */
    @ExcelProperty(value = "消息ID")
    private Integer msgId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "消息表用户ID")
    private Integer msgUserId;

    /**
     * 消息内容
     */
    @ExcelProperty(value = "消息内容")
    private String msgContent;

    /**
     * 消息类型（系统通知、业务提醒等）
     */
    @ExcelProperty(value = "消息类型")
    private String msgType;

    /**
     * 已读状态（0 - 未读，1 - 已读）
     */
    @ExcelProperty(value = "已读状态")
    private Integer msgIsRead;

    /**
     * 发送时间
     */
    @ExcelProperty(value = "发送时间")
    private LocalDateTime msgSendTime;

    // ========== 持仓分析表字段 ==========
    /**
     * 分析记录唯一标识，自增主键
     */
    @ExcelProperty(value = "分析ID")
    private Integer analysisId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "分析表用户ID")
    private Integer analysisUserId;

    /**
     * 分析类型（持仓分布、收益归因等）
     */
    @ExcelProperty(value = "分析类型")
    private String analysisType;

    /**
     * 分析结果详情
     */
    @ExcelProperty(value = "分析结果详情")
    private String analysisResult;

    /**
     * 生成时间
     */
    @ExcelProperty(value = "分析生成时间")
    private LocalDateTime analysisGenerateTime;

    // ========== 报告表字段 ==========
    /**
     * 报告唯一标识，自增主键
     */
    @ExcelProperty(value = "报告ID")
    private Integer reportId;

    /**
     * 关联用户表 user_id
     */
    @ExcelProperty(value = "报告表用户ID")
    private Integer reportUserId;

    /**
     * 报告类型（资产报告、行为报告等）
     */
    @ExcelProperty(value = "报告类型")
    private String reportType;

    /**
     * 报告内容
     */
    @ExcelProperty(value = "报告内容")
    private String reportContent;

    /**
     * 审核状态（0 - 待审核，1 - 通过，2 - 拒绝）
     */
    @ExcelProperty(value = "审核状态")
    private Integer reportAuditStatus;

    /**
     * 提交时间
     */
    @ExcelProperty(value = "提交时间")
    private LocalDateTime reportSubmitTime;

    /**
     * 审核时间
     */
    @ExcelProperty(value = "审核时间")
    private LocalDateTime reportAuditTime;

    /**
     * 审核人
     */
    @ExcelProperty(value = "审核人")
    private String reportAuditor;

    // ========== 用户表字段 ==========
    /**
     * 用户唯一标识，自增主键
     */
    @ExcelProperty(value = "用户ID")
    private Integer userId;

    /**
     * 用户名，唯一
     */
    @ExcelProperty(value = "用户名")
    private String username;

    /**
     * 密码（加密存储）
     */
    @ExcelProperty(value = "密码")
    private String password;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 用户状态（1 - 正常，0 - 禁用）
     */
    @ExcelProperty(value = "用户状态")
    private Integer status;
}