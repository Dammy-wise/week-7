package com.compcorp.commerce.pricing;
import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.junit.jupiter.api.Assertions.*;
class PricingCalculatorTest{
 @Test void calculatesDiscountBeforeTax(){var q=PricingCalculator.quote(new BigDecimal("125.00"),2,new BigDecimal("0.10"),new BigDecimal("0.075"));assertEquals(new BigDecimal("250.00"),q.subtotal());assertEquals(new BigDecimal("25.00"),q.discount());assertEquals(new BigDecimal("16.88"),q.tax());assertEquals(new BigDecimal("241.88"),q.total());}
 @Test void addsDeliveryFee(){assertEquals(new BigDecimal("25.00"),PricingCalculator.quote(new BigDecimal("10"),2,BigDecimal.ZERO,BigDecimal.ZERO,new BigDecimal("5")).total());}
 @Test void rejectsZeroQuantity(){assertThrows(IllegalArgumentException.class,()->PricingCalculator.quote(BigDecimal.TEN,0,BigDecimal.ZERO,BigDecimal.ZERO));}
 @Test void rejectsDiscountOverOne(){assertThrows(IllegalArgumentException.class,()->PricingCalculator.quote(BigDecimal.TEN,1,new BigDecimal("1.01"),BigDecimal.ZERO));}
 @Test void zeroDiscountAndTax(){assertEquals(new BigDecimal("20.00"),PricingCalculator.quote(new BigDecimal("10"),2,BigDecimal.ZERO,BigDecimal.ZERO).total());}
}
