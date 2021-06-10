package com.residencia.dell.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orderlines")
public class Orderlines implements Serializable {
    
	@EmbeddedId
	OrderlinesID orderLinesId;
    // //Fk orders / Talvez problema com o objeto orders
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable=false, updatable=false)
    private Orders order;

    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "orderdate")
    private Calendar orderDate;

    public Orderlines() {
	}
	
	public Orderlines(Integer orderlineid, Integer orderid, Integer prodId, Integer quantity,
			Calendar orderDate) {
		
		OrderlinesID orderLinesId = new OrderlinesID(orderlineid, orderid); 
		
		this.orderLinesId = orderLinesId;
		this.prodId = prodId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}


    public OrderlinesID getOrderLinesId() {
        return orderLinesId;
    }

    public void setOrderLinesId(OrderlinesID orderLinesId) {
        this.orderLinesId = orderLinesId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @JsonBackReference
    public Orders getOrders() {
        return this.order;
    }

    public void setOrders(Orders orders) {
        this.order = orders;
    }

    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Calendar getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }
}
