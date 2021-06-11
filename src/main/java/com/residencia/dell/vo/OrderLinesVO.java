package com.residencia.dell.vo;

import java.util.Calendar;

import com.residencia.dell.entities.OrderLinesId;


public class OrderLinesVO {
    private OrderLinesId orderLineId;
	private OrdersVO ordersVO;
	private Integer prodId;
	private Integer quantity;
	private Calendar orderDate;

	public OrderLinesId getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(OrderLinesId orderLinesId) {
		this.orderLineId = orderLinesId;
	}

	public OrdersVO getOrdersVO() {
		return ordersVO;
	}

	public void setOrdersVO(OrdersVO ordersVO) {
		this.ordersVO = ordersVO;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
}
