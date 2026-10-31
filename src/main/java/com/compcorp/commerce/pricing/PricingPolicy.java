package com.compcorp.commerce.pricing;
import java.math.BigDecimal;
public interface PricingPolicy { BigDecimal calculate(BigDecimal unitPrice,int quantity); }
