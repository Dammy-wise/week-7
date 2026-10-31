package com.compcorp.commerce.dto;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import java.math.BigDecimal; import java.util.List;
public final class Requests { private Requests(){}
 public record ProductRequest(@NotBlank String sku,@NotBlank String name,String description,@NotNull @DecimalMin("0.01") BigDecimal price,@Min(0) int stockQuantity){}
 public record StockRequest(@NotNull Integer delta){}
 public record CustomerRequest(@NotBlank String firstName,@NotBlank String lastName,@NotBlank @Email String email){}
 public record OrderLine(@NotNull Long productId,@Min(1) int quantity){}
 public record OrderRequest(@NotNull Long customerId,@NotEmpty List<@Valid OrderLine> items){}
 public record StatusRequest(@NotNull com.compcorp.commerce.entity.OrderStatus status){}
}
