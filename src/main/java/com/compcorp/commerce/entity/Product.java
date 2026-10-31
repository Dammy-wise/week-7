package com.compcorp.commerce.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.math.BigDecimal;
@Entity @Table(name="products", uniqueConstraints=@UniqueConstraint(columnNames="sku"))
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,unique=true) private String sku;
 @NotBlank @Column(nullable=false) private String name;
 @Column(length=2000) private String description;
 @NotNull @DecimalMin("0.01") @Column(nullable=false,precision=12,scale=2) private BigDecimal price;
 @Min(0) @Column(nullable=false) private int stockQuantity;
 protected Product() {}
 public Product(String sku,String name,String description,BigDecimal price,int stockQuantity){this.sku=sku;this.name=name;this.description=description;this.price=price;this.stockQuantity=stockQuantity;}
 public Long getId(){return id;} public String getSku(){return sku;} public String getName(){return name;} public String getDescription(){return description;} public BigDecimal getPrice(){return price;} public int getStockQuantity(){return stockQuantity;}
 public void update(String name,String description,BigDecimal price,int stock){this.name=name;this.description=description;this.price=price;this.stockQuantity=stock;}
 public void adjustStock(int delta){if(stockQuantity+delta<0)throw new IllegalArgumentException("Stock cannot become negative");stockQuantity+=delta;}
}
