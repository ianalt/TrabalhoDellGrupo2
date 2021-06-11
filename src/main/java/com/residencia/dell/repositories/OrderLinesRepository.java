package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.OrderLinesId;

@Repository
public interface OrderLinesRepository extends JpaRepository<OrderLines, OrderLinesId> {

    OrderLines findByOrderLinesId(Integer orderLinesId);
	
}
