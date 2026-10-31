package com.compcorp.commerce.collections;
import java.math.BigDecimal;import java.util.*;import java.util.stream.*;
public final class OrderAnalytics{private OrderAnalytics(){} public record Sale(String orderId,String customer,String status,BigDecimal value){} public record Summary(long count,BigDecimal total,BigDecimal average,Optional<Sale> bestSale){}
 public static List<Sale> search(Collection<Sale> rows,String term){return rows.stream().filter(Objects::nonNull).filter(x->x.orderId().contains(term)||x.customer().toLowerCase().contains(term.toLowerCase())).toList();}
 public static List<Sale> byValue(Collection<Sale> rows){return CollectionTools.safeSorted(rows,Comparator.comparing(Sale::value).reversed());}
 public static Map<String,List<Sale>> groupByCustomer(Collection<Sale> rows){return CollectionTools.group(rows,Sale::customer);}
 public static Summary summarize(Collection<Sale> rows){var list=rows==null?List.<Sale>of():rows.stream().filter(Objects::nonNull).toList();BigDecimal total=list.stream().map(Sale::value).reduce(BigDecimal.ZERO,BigDecimal::add);return new Summary(list.size(),total,list.isEmpty()?BigDecimal.ZERO:total.divide(BigDecimal.valueOf(list.size()),2,java.math.RoundingMode.HALF_UP),list.stream().max(Comparator.comparing(Sale::value)));}}
