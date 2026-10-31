package com.compcorp.commerce.collections;
import org.junit.jupiter.api.Test;import java.math.BigDecimal;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class OrderAnalyticsTest{
 private List<OrderAnalytics.Sale> rows(){return List.of(new OrderAnalytics.Sale("1","Ada","PAID",new BigDecimal("10")),new OrderAnalytics.Sale("2","Grace","PENDING",new BigDecimal("20")),new OrderAnalytics.Sale("3","Ada","PAID",new BigDecimal("30")));}
 @Test void groupsByCustomer(){assertEquals(2,OrderAnalytics.groupByCustomer(rows()).get("Ada").size());}
 @Test void sortsDescending(){assertEquals("3",OrderAnalytics.byValue(rows()).get(0).orderId());}
 @Test void summarizes(){var s=OrderAnalytics.summarize(rows());assertEquals(3,s.count());assertEquals(new BigDecimal("60"),s.total());assertEquals("3",s.bestSale().orElseThrow().orderId());}
 @Test void emptySummary(){assertEquals(BigDecimal.ZERO,OrderAnalytics.summarize(List.of()).total());}
 @Test void searchIsCaseInsensitive(){assertEquals(2,OrderAnalytics.search(rows(),"ada").size());}
}
