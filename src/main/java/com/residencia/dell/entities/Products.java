package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "category")
    private Integer category;

    @Column(name = "title")
    private String title;

    @Column(name = "actor")
    private String actor;

    @Column(name = "price")
    private Integer price;

    @Column(name = "special")
    private Integer special;

    @Column(name = "common_prod_id")
    private Integer commonProdId;
    

    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return this.actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSpecial() {
        return this.special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    }

    public Integer getCommonProdId() {
        return this.commonProdId;
    }

    public void setCommonProdId(Integer commonProdId) {
        this.commonProdId = commonProdId;
    }


}
