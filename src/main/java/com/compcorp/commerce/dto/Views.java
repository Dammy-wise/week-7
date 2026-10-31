package com.compcorp.commerce.dto;
import com.compcorp.commerce.entity.*; import java.math.BigDecimal; import java.time.Instant; import java.util.*;
public final class Views {private Views(){}
 public record ProductView(Long id,String sku,String name,String description,BigDecimal price,int stockQuantity){public static ProductView of(Product p){return new ProductView(p.getId(),p.getSku(),p.getName(),p.getDescription(),p.getPrice(),p.getStockQuantity());}}
 public record CustomerView(Long id,String firstName,String lastName,String email){public static CustomerView of(Customer c){return new CustomerView(c.getId(),c.getFirstName(),c.getLastName(),c.getEmail());}}
 public record ItemView(Long productId,String productName,int quantity,BigDecimal unitPrice,BigDecimal lineTotal){}
 public record OrderView(Long id,Long customerId,OrderStatus status,BigDecimal total,Instant createdAt,List<ItemView> items){public static OrderView of(CustomerOrder o){return new OrderView(o.getId(),o.getCustomer().getId(),o.getStatus(),o.getTotal(),o.getCreatedAt(),o.getItems().stream().map(i->new ItemView(i.getProduct().getId(),i.getProduct().getName(),i.getQuantity(),i.getUnitPrice(),i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity())))).toList());}}
 public record SalesReport(long orderCount,BigDecimal grossSales,long unitsSold){}
}
