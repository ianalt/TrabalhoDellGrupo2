package com.residencia.dell.controllers;

import java.util.List;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.services.OrderlinesService;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderlinesController {
    @Autowired
    private OrderlinesService orderlinesService;

    // @GetMapping("/{id}")
    // public ResponseEntity<Orderlines> findById(@PathVariable Integer id) {
    //     HttpHeaders headers = new HttpHeaders();
    //     return new ResponseEntity<>(orderlinesService.findById(id), headers, HttpStatus.OK);
    // }

    @GetMapping
	public ResponseEntity<List<Orderlines>> findAll() 
					throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderlinesService.findAll(), 
				headers, HttpStatus.OK);
	}

    @GetMapping("/count")
	public Long Count() {
		return orderlinesService.Count();
	}

    @PostMapping
	public ResponseEntity<Orderlines> save(@RequestBody Orderlines orderlines){
		//return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();

        Orderlines newOrderlines = orderlinesService.save(orderlines);
		
		if(null != orderlinesService.save(orderlines))
			return new ResponseEntity<>(newOrderlines, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newOrderlines, headers, HttpStatus.BAD_REQUEST);
	}
	

	@PutMapping("/{id}")
    public Orderlines update(@RequestBody Orderlines orderlines,@PathVariable Integer id){
       return orderlinesService.update(orderlines, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orderlines> delete(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();

        boolean foiRemovido = orderlinesService.delete(id);

        if (foiRemovido) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}
