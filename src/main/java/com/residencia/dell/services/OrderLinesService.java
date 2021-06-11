package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.repositories.OrderLinesRepository;

@Service
public class OrderLinesService {

	@Autowired
	public OrderLinesRepository orderLinesRepository;

	public OrderLines findById(Integer id) {
		return orderLinesRepository.findByOrderLinesId(id);
	}

	// findOrderlineidAndOrderid
//	public OrderLines findById(Integer orderlineId, Integer orderId) {
//		return orderLinesRepository.findByOrderLineIdAndOrderId(orderlineId, orderId);
//	}

	public List<OrderLines> findAll() {
		return orderLinesRepository.findAll();
	}

	public Long count() {
		return orderLinesRepository.count();
	}

	public OrderLines save(OrderLines orderlines) {
		return orderLinesRepository.save(orderlines);
	}

	public boolean delete(Integer id) {
		if (id != null) {
			orderLinesRepository.delete(orderLinesRepository.findByOrderLinesId(id));
			return true;
		} else {
			return false;
		}
	}

	public OrderLines update(OrderLines orderlines, Integer id) {
		orderlines.setProdId(id);
		return orderLinesRepository.save(orderlines);
	}

}
