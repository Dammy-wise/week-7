package com.compcorp.commerce.repository;
import com.compcorp.commerce.entity.Customer; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer,Long>{Optional<Customer> findByEmail(String email);}
