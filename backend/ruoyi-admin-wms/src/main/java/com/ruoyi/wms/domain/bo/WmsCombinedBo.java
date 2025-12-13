package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * WMS系统统一业务对象 - 学生学习版
 * 整合了资产、投资建议、入库单、用户和消息的所有字段
 *
 * @author student
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WmsCombinedBo extends BaseEntity {

    // ==================== 资产表相关字段 ====================

    /**
     * 资产主键id
     */
    @NotNull(message = "资产主键id不能为空", groups = { EditGroup.class })
    private Long assetId;

    /**
     * 资产关联用户id
     */
    private Long assetUserId;

    /**
     * 资产名称
     */
    private String assetName;

    /**
     * 资产简称
     */
    private String assetAbbreviation;

    /**
     * 资产流通量
     */
    private String assetCirculationSupply;

    /**
     * 资产市值
     */
    private BigDecimal assetMarketValue;

    /**
     * 资产价格
     */
    private BigDecimal assetPrice;

    /**
     * 资产24小时交易量
     */
    private BigDecimal assetVolume24h;

    /**
     * 资产1小时涨跌幅
     */
    private BigDecimal assetChange1h;

    /**
     * 资产24小时涨跌幅
     */
    private BigDecimal assetChange24h;

    /**
     * 资产7天涨跌幅
     */
    private BigDecimal assetChange7d;

    // ==================== 投资建议表相关字段 ====================

    /**
     * 建议记录唯一标识，自增主键
     */
    private Integer suggestionId;

    /**
     * 投资建议关联用户ID
     */
    @NotNull(message = "投资建议关联用户ID不能为空")
    private Integer suggestionUserId;

    /**
     * 建议类型（买入、卖出、持仓等）
     */
    @NotBlank(message = "建议类型不能为空")
    @Size(max = 50, message = "建议类型长度不能超过50个字符")
    private String suggestionType;

    /**
     * 建议内容详情
     */
    @NotBlank(message = "建议内容详情不能为空")
    private String suggestionContent;

    /**
     * 建议生成时间
     */
    @NotNull(message = "建议生成时间不能为空")
    private LocalDateTime suggestionGenerateTime;

    /**
     * 建议生效时间
     */
    @NotNull(message = "建议生效时间不能为空")
    private LocalDateTime suggestionEffectiveTime;

    /**
     * 建议资产名称（如 Bitcoin）
     */
    @NotBlank(message = "建议资产名称不能为空")
    @Size(max = 100, message = "建议资产名称长度不能超过100个字符")
    private String suggestionName;

    /**
     * 建议资产简写（如 BTC）
     */
    @NotBlank(message = "建议资产简写不能为空")
    @Size(max = 20, message = "建议资产简写长度不能超过20个字符")
    private String suggestionAbbreviation;

    /**
     * 建议资产市值
     */
    @NotNull(message = "建议资产市值不能为空")
    private BigDecimal suggestionMarkerValue;

    /**
     * 建议资产价格
     */
    @NotNull(message = "建议资产价格不能为空")
    private BigDecimal suggestionPrice;

    /**
     * 建议资产流通供给量
     */
    @NotBlank(message = "建议资产流通供给量不能为空")
    @Size(max = 50, message = "建议资产流通供给量长度不能超过50个字符")
    private String suggestionCirculationSupply;

    /**
     * 建议资产交易量（24 小时）
     */
    @NotNull(message = "建议资产24小时交易量不能为空")
    private BigDecimal suggestionVolume24h;

    /**
     * 建议资产1小时涨跌幅
     */
    @NotNull(message = "建议资产1小时涨跌幅不能为空")
    private BigDecimal suggestionChange1h;

    /**
     * 建议资产24小时涨跌幅
     */
    @NotNull(message = "建议资产24小时涨跌幅不能为空")
    private BigDecimal suggestionChange24h;

    /**
     * 建议资产7天涨跌幅
     */
    @NotNull(message = "建议资产7天涨跌幅不能为空")
    private BigDecimal suggestionChange7d;

    // ==================== 入库单相关字段 ====================

    /**
     * 入库单主键
     */
    @NotNull(message = "入库单主键不能为空", groups = { EditGroup.class })
    private Long receiptOrderId;

    /**
     * 入库单号
     */
    @NotBlank(message = "入库单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String receiptOrderNo;

    /**
     * 入库类型
     */
    @NotNull(message = "入库类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long receiptOrderType;

    /**
     * 入库单供应商
     */
    private Long receiptOrderMerchantId;

    /**
     * 入库单关联订单号
     */
    private String receiptOrderOrderNo;

    /**
     * 入库单商品总数
     */
    private BigDecimal receiptOrderTotalQuantity;

    /**
     * 入库单订单金额
     */
    private BigDecimal receiptOrderPayableAmount;

    /**
     * 入库单状态
     */
    private Integer receiptOrderStatus;

    /**
     * 入库单仓库id
     */
    @NotNull(message = "入库单仓库不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long receiptOrderWarehouseId;

    /**
     * 入库单库区id
     */
    private Long receiptOrderAreaId;

    /**
     * 入库单备注
     */
    private String receiptOrderRemark;

    /**
     * 入库单商品信息
     */
    private List<ReceiptOrderDetailBo> receiptOrderDetails;

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

    // ==================== 消息表相关字段 ====================

    /**
     * 消息ID（自增主键，修改和删除时需要）
     */
    private Integer msgId;

    /**
     * 消息关联用户ID
     */
    @NotNull(message = "消息关联用户ID不能为空")
    private Integer msgUserId;

    /**
     * 消息内容（支持模糊查询）
     */
    private String msgContent;

    /**
     * 消息类型（如：系统通知、业务提醒等）
     */
    @NotBlank(message = "消息类型不能为空")
    @Size(max = 20, message = "消息类型长度不能超过20个字符")
    private String msgType;

    /**
     * 消息已读状态（0：未读，1：已读）
     */
    @NotNull(message = "消息已读状态不能为空")
    private Integer msgIsRead;

    /**
     * 消息发送时间
     */
    @NotNull(message = "消息发送时间不能为空")
    private LocalDateTime msgSendTime;
}