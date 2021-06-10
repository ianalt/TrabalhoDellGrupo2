package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class OrdersVO {
    private Integer orderId;
	private Calendar orderDate;
	private BigDecimal netAmount;
	private BigDecimal tax;
	private BigDecimal totalAmount;
	private Integer customers;
	private List<OrderLinesVO> listOrderLinesVO;


	public Integer getCustomers() {
		return this.customers;
	}

	public void setCustomers(Integer customers) {
		this.customers = customers;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderLinesVO> getListOrderLinesVO() {
		return listOrderLinesVO;
	}

	public void setListOrderLinesVO(List<OrderLinesVO> listOrderLinesVO) {
		this.listOrderLinesVO = listOrderLinesVO;
	}

}
