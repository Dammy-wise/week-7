package com.compcorp.commerce.controller;
import com.compcorp.commerce.dto.*;import com.compcorp.commerce.service.CommerceService;import jakarta.validation.Valid;import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.math.BigDecimal;import java.util.*;
@RestController @RequestMapping("/api/v1/products")
public class ProductController{private final CommerceService s;public ProductController(CommerceService s){this.s=s;}
 @GetMapping public List<Views.ProductView> list(@RequestParam(required=false)String q,@RequestParam(required=false)BigDecimal minPrice,@RequestParam(required=false)BigDecimal maxPrice,@RequestParam(defaultValue="false")boolean availableOnly){return s.listProducts(q,minPrice,maxPrice,availableOnly);}
 @GetMapping("/{id}") public Views.ProductView get(@PathVariable Long id){return s.product(id);}
 @PostMapping public ResponseEntity<Views.ProductView> create(@Valid @RequestBody Requests.ProductRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(s.createProduct(r));}
 @PutMapping("/{id}") public Views.ProductView update(@PathVariable Long id,@Valid @RequestBody Requests.ProductRequest r){return s.updateProduct(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){s.deleteProduct(id);}
 @PatchMapping("/{id}/stock") public Views.ProductView stock(@PathVariable Long id,@Valid @RequestBody Requests.StockRequest r){return s.adjustStock(id,r.delta());}
}
