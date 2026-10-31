package com.compcorp.commerce.repository;
import com.compcorp.commerce.entity.Product; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ProductRepository extends JpaRepository<Product,Long>{Optional<Product> findBySku(String sku); List<Product> findByNameContainingIgnoreCase(String name);}
