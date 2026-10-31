package com.compcorp.commerce.pricing;
import java.math.BigDecimal;
public class StandardPricingPolicy implements PricingPolicy { public BigDecimal calculate(BigDecimal price,int quantity){if(price==null||price.signum()<0||quantity<1)throw new IllegalArgumentException("Invalid pricing input");return price.multiply(BigDecimal.valueOf(quantity)).setScale(2,java.math.RoundingMode.HALF_UP);} }
