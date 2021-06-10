package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.services.OrderLinesService;

@RestController
@RequestMapping("/orderlines")
public class OrderLinesController {
	@Autowired
	private OrderLinesService orderLinesService;

	 @GetMapping("/{id}")
	 public ResponseEntity<OrderLines> findById(@PathVariable Integer id) {
	 HttpHeaders headers = new HttpHeaders();
	 return new ResponseEntity<>(orderLinesService.findById(id), headers,
	 HttpStatus.OK);
	 }

	@GetMapping
	public ResponseEntity<List<OrderLines>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderLinesService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return orderLinesService.count();
	}

	@PostMapping
	public ResponseEntity<OrderLines> save(@RequestBody OrderLines orderlines) {
		// return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();

		OrderLines newOrderLines = orderLinesService.save(orderlines);

		if (null != orderLinesService.save(orderlines))
			return new ResponseEntity<>(newOrderLines, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newOrderLines, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public OrderLines update(@RequestBody OrderLines orderlines, @PathVariable Integer id) {
		return orderLinesService.update(orderlines, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<OrderLines> delete(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = orderLinesService.delete(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}
