package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_hist")
public class CustHist {
    
    @Id
    @Column(name = "orderid")
    private Integer orderId;

    // Fk customers
    // @ManyToOne
    // @JoinColumn(name = "customerid", referencedColumnName = "curtomerid")  
    // private Customers customerId;

    @Column(name = "prod_id")
    private Integer prodId;

}
