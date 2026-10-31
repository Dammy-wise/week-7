package com.compcorp.commerce.shipping;
import java.math.BigDecimal;
public interface ShippingCalculator { BigDecimal feeFor(String destination,BigDecimal orderValue); }
