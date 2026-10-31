package com.compcorp.commerce.controller;
import com.compcorp.commerce.dto.*;import com.compcorp.commerce.service.CommerceService;import jakarta.validation.Valid;import org.springframework.http.*;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/v1/orders") public class OrderController{private final CommerceService s;public OrderController(CommerceService s){this.s=s;}
 @PostMapping public ResponseEntity<Views.OrderView> create(@Valid @RequestBody Requests.OrderRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(s.placeOrder(r));}
 @GetMapping("/{id}") public Views.OrderView get(@PathVariable Long id){return s.order(id);}
 @PatchMapping("/{id}/status") public Views.OrderView status(@PathVariable Long id,@Valid @RequestBody Requests.StatusRequest r){return s.changeStatus(id,r.status());}
}
