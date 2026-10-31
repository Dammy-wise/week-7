package com.compcorp.commerce.controller;
import com.compcorp.commerce.dto.*;import com.compcorp.commerce.service.CommerceService;import jakarta.validation.Valid;import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/api/v1/customers") public class CustomerController{private final CommerceService s;public CustomerController(CommerceService s){this.s=s;}
 @GetMapping public List<Views.CustomerView> list(){return s.listCustomers();}
 @PostMapping public ResponseEntity<Views.CustomerView> create(@Valid @RequestBody Requests.CustomerRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(s.createCustomer(r));}
}
