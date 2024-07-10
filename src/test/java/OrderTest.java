import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderCreation() {
        int orderNumber = 123;
        Order order = new Order(orderNumber);

        assertNotNull(order);
        assertEquals(orderNumber, order.orderNumber());
    }

    @Test
    public void testOrderEquality() {
        int orderNumber1 = 123;
        int orderNumber2 = 456;

        Order order1 = new Order(orderNumber1);
        Order order2 = new Order(orderNumber1);
        Order order3 = new Order(orderNumber2);

        assertEquals(order1, order2, "Orders with the same order number should be equal");
        assertNotEquals(order1, order3, "Orders with different order numbers should not be equal");
    }

    @Test
    public void testOrderHashCode() {
        int orderNumber = 123;

        Order order1 = new Order(orderNumber);
        Order order2 = new Order(orderNumber);

        assertEquals(order1.hashCode(), order2.hashCode(), "Orders with the same order number should have the same hash code");
    }

    @Test
    public void testOrderToString() {
        int orderNumber = 123;

        Order order = new Order(orderNumber);

        assertEquals("Order[orderNumber=123]", order.toString(), "toString method should return the correct representation");
    }
}