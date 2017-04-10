package com.xylj.order.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * ddEntity
 * @author dd
 * @version 2017-04-04
 */
public class XTenementOrder extends DataEntity<XTenementOrder> {
	
	private static final long serialVersionUID = 1L;
	private String userName;		// 缴费人名称
	private String userPhone;		// 缴费人电话
	private Long roomId;		// 缴费房间
	private String feeType;		// 缴费类型(1:物业费 2: 供暖费 3: 生活垃圾费)
	private String typeName;		// 缴费类型名称
	private String propertyOrderNumber;		// 订单号
	private String price;		// 金额
	private String fine;		// 滞纳金
	private String subtotal;		// 总金额
	private String pattern;		// 支付方式
	private String billId;		// 发票id
	private String orderType;		// 订单状态(0:创建  1:推送 2:取消 3:支付完成)
	private Date createTime;		// 创建时间
	private Date updateTime;		// 更新时间
	private String paymentDay;		// 账期
	private Date endTime;		// 截止日期
	private String isDelete;		// 是否删除
	private Long userId;		// 用户ID
	private Date feeTime;		// 缴费日期
	private Long roomMoneyId;		// 账期金额表的Id
	
	public XTenementOrder() {
		super();
	}

	public XTenementOrder(String id){
		super(id);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getPropertyOrderNumber() {
		return propertyOrderNumber;
	}

	public void setPropertyOrderNumber(String propertyOrderNumber) {
		this.propertyOrderNumber = propertyOrderNumber;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}
	
	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Date getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}
	
	public Long getRoomMoneyId() {
		return roomMoneyId;
	}

	public void setRoomMoneyId(Long roomMoneyId) {
		this.roomMoneyId = roomMoneyId;
	}
	
}