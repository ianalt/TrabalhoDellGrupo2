package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "reorder")
public class Reorder {

    @Id
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "date_low")
    private Calendar dateLow;

    @Column(name = "quan_low")
    private Integer quanLow;

    @Column(name = "date_reordered")
    private Calendar dateReordered;

    @Column(name = "quan_reordered")
    private Integer quanReordered;

    @Column(name = "date_expected")
    private Calendar dateExpexted;


    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Calendar getDateLow() {
        return this.dateLow;
    }

    public void setDateLow(Calendar dateLow) {
        this.dateLow = dateLow;
    }

    public Integer getQuanLow() {
        return this.quanLow;
    }

    public void setQuanLow(Integer quanLow) {
        this.quanLow = quanLow;
    }

    public Calendar getDateReordered() {
        return this.dateReordered;
    }

    public void setDateReordered(Calendar dateReordered) {
        this.dateReordered = dateReordered;
    }

    public Integer getQuanReordered() {
        return this.quanReordered;
    }

    public void setQuanReordered(Integer quanReordered) {
        this.quanReordered = quanReordered;
    }

    public Calendar getDateExpexted() {
        return this.dateExpexted;
    }

    public void setDateExpexted(Calendar dateExpexted) {
        this.dateExpexted = dateExpexted;
    }

    
}
