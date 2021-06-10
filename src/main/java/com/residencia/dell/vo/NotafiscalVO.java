package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;


public class NotafiscalVO {
    private String name;
    private String lastName;
    private BigDecimal netAmount;
    private BigDecimal totalAmount;
    private Calendar orderDate;
    private Integer orderId;
    private List<ItemOrderLinesVO> listItemOrderLinesVO;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Calendar getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public List<ItemOrderLinesVO> getListItemOrderLinesVO() {
        return this.listItemOrderLinesVO;
    }

    public void setListItemOrderLinesVO(List<ItemOrderLinesVO> listItemOrderLinesVO) {
        this.listItemOrderLinesVO = listItemOrderLinesVO;
    }

}
