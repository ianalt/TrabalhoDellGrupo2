package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ItemOrderLinesVO;
import com.residencia.dell.vo.NotafiscalVO;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;

	@Autowired
	public OrderLinesRepository orderLinesRepository;

	@Autowired
	public ProductsRepository productsRepository;

	@Autowired
	public CustomersRepository customersRepository;

	public Orders findById(Integer id) {
		// return alunosRepository.getById(id).getNome();
		return ordersRepository.findById(id).get();
	}

	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	public List<Orders> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

				return listOrdersComPaginacao;
			} else {
				listOrders = ordersRepository.findAll();

				return listOrders;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}
	}

	public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Orders> listOrders = null;
		List<Orders> listOrdersComPaginacao = null;
		List<OrdersVO> listOrdersVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

				for (Orders lOrders : listOrdersComPaginacao) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			} else {
				listOrders = ordersRepository.findAll();

				for (Orders lOrders : listOrders) {
					listOrdersVO.add(convertEntidadeParaVO(lOrders));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listOrdersVO;
	}

	private OrdersVO convertEntidadeParaVO(Orders orders) {
		OrdersVO ordersVO = new OrdersVO();
		List<OrderLinesVO> listOrderLinesVO = new ArrayList<>();

		ordersVO.setNetAmount(orders.getNetAmount());
		ordersVO.setOrderDate(orders.getOrderDate());
		ordersVO.setOrderId(orders.getOrderId());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());

		for (OrderLines lOrderLines : orders.getListOrderLines()) {
			OrderLinesVO orderLinesVO = new OrderLinesVO();

			orderLinesVO.setOrderDate(lOrderLines.getOrderDate());
			// possível erro
			orderLinesVO.setOrderLineId(lOrderLines.getOrderLinesId());
			orderLinesVO.setProdId(lOrderLines.getProdId());
			orderLinesVO.setQuantity(lOrderLines.getQuantity());

			listOrderLinesVO.add(orderLinesVO);
		}

		ordersVO.setListOrderLinesVO(listOrderLinesVO);

		return ordersVO;
	}

	public Long count() {
		return ordersRepository.count();
	}

	public Orders save(Orders orders) {
		Orders newOrders = ordersRepository.save(orders);
		return newOrders;
	}

	public Orders saveVO(OrdersVO ordersVO) {

		Orders orders = new Orders();
		Customers customer = customersRepository.getById(ordersVO.getCustomerId());

		orders.setNetAmount(ordersVO.getNetAmount());
		orders.setOrderDate(ordersVO.getOrderDate());
		orders.setOrderId(ordersVO.getOrderId());
		orders.setTax(ordersVO.getTax());
		orders.setTotalAmount(ordersVO.getTotalAmount());
		orders.setCustomer(customer);

		Orders newOrders = ordersRepository.save(orders);

		Integer contadorOrderLinesId = 1;

		List<OrderLines> listNewOrderLines = new ArrayList<>();
		for (OrderLinesVO itemOrderLinesVO : ordersVO.getListOrderLinesVO()) {
			OrderLines orderlines = new OrderLines(contadorOrderLinesId, newOrders.getOrderId(),
					itemOrderLinesVO.getProdId(), itemOrderLinesVO.getQuantity(), itemOrderLinesVO.getOrderDate());

			OrderLines newOrderLines = orderLinesRepository.save(orderlines);

			listNewOrderLines.add(newOrderLines);

			contadorOrderLinesId++;
		}

		newOrders.setListOrderLines(listNewOrderLines);

		return newOrders;

	}

	public void delete(Integer id) {
		ordersRepository.deleteById(id);
	}

	public Orders update(Integer id, Orders orders) {
		Orders newOrders = ordersRepository.findById(id).get();
		updateDados(newOrders, orders);
		return ordersRepository.save(newOrders);
	}

	private void updateDados(Orders newOrders, Orders orders) {
		newOrders.setOrderDate(orders.getOrderDate());
		newOrders.setCustomer(orders.getCustomer());
		newOrders.setNetAmount(orders.getNetAmount());
		newOrders.setTax(orders.getTax());
		newOrders.setTotalAmount(orders.getTotalAmount());
	}

	public NotafiscalVO emitirnf(Integer orderId) {

		Orders order = ordersRepository.getById(orderId);

		List<OrderLines> listOrderLines = order.getListOrderLines();

		NotafiscalVO notafiscalVO = new NotafiscalVO();

		notafiscalVO.setName(order.getCustomer().getFirstName());
		notafiscalVO.setLastName(order.getCustomer().getLastName());
		notafiscalVO.setNetAmount(order.getNetAmount());
		notafiscalVO.setTotalAmount(order.getTotalAmount());
		notafiscalVO.setOrderDate(order.getOrderDate());
		notafiscalVO.setOrderId(order.getOrderId());

		List<ItemOrderLinesVO> listItemOrderLinesVO = new ArrayList<>();
		for (OrderLines orderlines : listOrderLines) {
			ItemOrderLinesVO itemOrderLinesVO = new ItemOrderLinesVO();

			Products product = productsRepository.findById(orderlines.getProdId()).get();

			itemOrderLinesVO.setTitle(product.getTitle());
			itemOrderLinesVO.setProdId(orderlines.getProdId());
			itemOrderLinesVO.setQuantity(orderlines.getQuantity());
			listItemOrderLinesVO.add(itemOrderLinesVO);
		}

		notafiscalVO.setListItemOrderLinesVO(listItemOrderLinesVO);

		return notafiscalVO;

	}

}