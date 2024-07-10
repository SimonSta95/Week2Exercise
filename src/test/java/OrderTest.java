import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderCreation() {
        // Create a product for the order
        Product product = new Product(100.0, "Product1", "P001", 10);

        // Create an order
        String orderNumber = "123";
        Order order = new Order(String.valueOf(orderNumber), product);

        // Verify orderNumber and product are correctly set
        assertEquals(orderNumber, order.orderNumber());
        assertEquals(product, order.product());
    }

    @Test
    public void testOrderEquality() {
        // Create products for orders
        Product product1 = new Product(100.0, "Product1", "P001", 10);
        Product product2 = new Product(150.0, "Product2", "P002", 5);

        // Create orders with different order numbers but the same product
        int orderNumber1 = 123;
        int orderNumber2 = 456;

        Order order1 = new Order(String.valueOf(orderNumber1), product1);
        Order order2 = new Order(String.valueOf(orderNumber1), product1);
        Order order3 = new Order(String.valueOf(orderNumber2), product1);

        // Verify equality
        assertEquals(order1, order2, "Orders with the same order number and product should be equal");
        assertNotEquals(order1, order3, "Orders with different order numbers should not be equal");
    }

    @Test
    public void testOrderHashCode() {
        // Create products for orders
        Product product1 = new Product(100.0, "Product1", "P001", 10);
        Product product2 = new Product(150.0, "Product2", "P002", 5);

        // Create orders with the same order number and product
        int orderNumber = 123;

        Order order1 = new Order(String.valueOf(orderNumber), product1);
        Order order2 = new Order(String.valueOf(orderNumber), product1);
        Order order3 = new Order(String.valueOf(orderNumber), product2);

        // Verify hashCode
        assertEquals(order1.hashCode(), order2.hashCode(), "Orders with the same order number and product should have the same hash code");
        assertNotEquals(order1.hashCode(), order3.hashCode(), "Orders with different products should have different hash codes");
    }

    @Test
    public void testOrderToString() {
        // Create a product for the order
        Product product = new Product(100.0, "Product1", "P001", 10);

        // Create an order
        int orderNumber = 123;
        Order order = new Order(String.valueOf(orderNumber), product);

        // Verify toString representation
        assertEquals("Order[orderNumber=123, product=Product[price=100.0, name=Product1, productNumber=P001, quantity=10]]", order.toString(), "toString method should return the correct representation");
    }
}