package com.compcorp.commerce.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity @Table(name="customers",uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Customer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String firstName; @NotBlank @Column(nullable=false) private String lastName;
 @Email @NotBlank @Column(nullable=false,unique=true) private String email;
 protected Customer(){} public Customer(String firstName,String lastName,String email){this.firstName=firstName;this.lastName=lastName;this.email=email;}
 public Long getId(){return id;} public String getFirstName(){return firstName;} public String getLastName(){return lastName;} public String getEmail(){return email;}
}
