package com.compcorp.commerce.pricing;
import java.math.*;
public final class PricingCalculator {
 private static final int SCALE=2; private static final RoundingMode ROUNDING=RoundingMode.HALF_UP;
 private PricingCalculator(){}
 public record Quote(BigDecimal subtotal,BigDecimal discount,BigDecimal taxableAmount,BigDecimal tax,BigDecimal deliveryFee,BigDecimal total){}
 public static Quote quote(BigDecimal unitPrice,int quantity,BigDecimal discountRate,BigDecimal taxRate){return quote(unitPrice,quantity,discountRate,taxRate,BigDecimal.ZERO);}
 public static Quote quote(BigDecimal unitPrice,int quantity,BigDecimal discountRate,BigDecimal taxRate,BigDecimal deliveryFee){
  if(unitPrice==null||discountRate==null||taxRate==null||deliveryFee==null)throw new IllegalArgumentException("Inputs are required");
  if(unitPrice.signum()<0||quantity<1||discountRate.signum()<0||discountRate.compareTo(BigDecimal.ONE)>0||taxRate.signum()<0||deliveryFee.signum()<0)throw new IllegalArgumentException("Invalid price, quantity, discount or tax rate");
  BigDecimal subtotal=unitPrice.multiply(BigDecimal.valueOf(quantity)).setScale(SCALE,ROUNDING);
  BigDecimal discount=subtotal.multiply(discountRate).setScale(SCALE,ROUNDING);
  BigDecimal taxable=subtotal.subtract(discount);BigDecimal tax=taxable.multiply(taxRate).setScale(SCALE,ROUNDING);
  BigDecimal fee=deliveryFee.setScale(SCALE,ROUNDING);return new Quote(subtotal,discount,taxable,tax,fee,taxable.add(tax).add(fee).setScale(SCALE,ROUNDING));
 }
}
