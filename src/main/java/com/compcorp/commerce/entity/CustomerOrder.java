package com.compcorp.commerce.entity;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.Instant; import java.util.*;
@Entity @Table(name="customer_orders")
public class CustomerOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false,fetch=FetchType.LAZY) private Customer customer;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private OrderStatus status=OrderStatus.PENDING;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal total;
 @Column(nullable=false) private Instant createdAt=Instant.now();
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER) private List<OrderItem> items=new ArrayList<>();
 protected CustomerOrder(){} public CustomerOrder(Customer customer,BigDecimal total){this.customer=customer;this.total=total;}
 public void addItem(OrderItem item){items.add(item);item.setOrder(this);} public void setTotal(BigDecimal total){this.total=total;} public Long getId(){return id;} public Customer getCustomer(){return customer;} public OrderStatus getStatus(){return status;} public BigDecimal getTotal(){return total;} public Instant getCreatedAt(){return createdAt;} public List<OrderItem> getItems(){return Collections.unmodifiableList(items);}
 public void changeStatus(OrderStatus next){boolean ok=switch(status){case PENDING->next==OrderStatus.PAID||next==OrderStatus.CANCELLED;case PAID->next==OrderStatus.SHIPPED||next==OrderStatus.CANCELLED;case SHIPPED->next==OrderStatus.DELIVERED;default->false;};if(!ok)throw new IllegalStateException("Invalid order status transition: "+status+" -> "+next);status=next;}
}
