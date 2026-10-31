package com.compcorp.commerce.repository;
import com.compcorp.commerce.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface OrderRepository extends JpaRepository<CustomerOrder,Long>{List<CustomerOrder> findByStatusIn(Collection<OrderStatus> statuses);}
