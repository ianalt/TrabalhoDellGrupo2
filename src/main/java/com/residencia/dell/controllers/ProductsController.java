package com.residencia.dell.controllers;

import java.util.List;

import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductsService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;

    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(productsService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping
	public ResponseEntity<List<Products>> findAll() 
					throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productsService.findAll(), 
				headers, HttpStatus.OK);
	}

    @GetMapping("/count")
	public Long Count() {
		return productsService.Count();
	}

    @PostMapping
	public ResponseEntity<Products> save(@RequestBody Products products){
		//return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();

        Products newProducts = productsService.save(products);
		
		if(null != productsService.save(products))
			return new ResponseEntity<>(newProducts, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newProducts, headers, HttpStatus.BAD_REQUEST);
	}
	

	@PutMapping("/{id}")
    public Products update(@RequestBody Products products,@PathVariable Integer id){
       return productsService.update(products, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Products> delete(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();

        boolean foiRemovido = productsService.delete(id);

        if (foiRemovido) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}
