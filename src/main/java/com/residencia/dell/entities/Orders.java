package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "orderdate")
    private Calendar orderDate;

    //vai ser FK customers
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private Customers customerId;
    
    // bidirecional orderlines
    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    private List<Orderlines> listOrderLines;

    @Column(name = "netamount")
    private BigDecimal netAmount;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "totalamount")
    private BigDecimal totalAmount;
  

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Calendar getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    @JsonBackReference
    public Customers getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    @JsonManagedReference
    public List<Orderlines> getListOrderLines() {
        return this.listOrderLines;
    }

    public void setListOrderLines(List<Orderlines> listOrderLines) {
        this.listOrderLines = listOrderLines;
    }

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


}
