package com.compcorp.commerce.entity;
import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.junit.jupiter.api.Assertions.*;
class OrderStatusTest{
 @Test void allowsPendingToPaid(){var o=new CustomerOrder(new Customer("A","B","a@b.test"),BigDecimal.TEN);o.changeStatus(OrderStatus.PAID);assertEquals(OrderStatus.PAID,o.getStatus());}
 @Test void rejectsDeliveredToPaid(){var o=new CustomerOrder(new Customer("A","B","a@b.test"),BigDecimal.TEN);o.changeStatus(OrderStatus.CANCELLED);assertThrows(IllegalStateException.class,()->o.changeStatus(OrderStatus.PAID));}
 @Test void allowsPaidToShipped(){var o=new CustomerOrder(new Customer("A","B","a@b.test"),BigDecimal.TEN);o.changeStatus(OrderStatus.PAID);o.changeStatus(OrderStatus.SHIPPED);assertEquals(OrderStatus.SHIPPED,o.getStatus());}
 @Test void disallowsPendingToDelivered(){var o=new CustomerOrder(new Customer("A","B","a@b.test"),BigDecimal.TEN);assertThrows(IllegalStateException.class,()->o.changeStatus(OrderStatus.DELIVERED));}
}
