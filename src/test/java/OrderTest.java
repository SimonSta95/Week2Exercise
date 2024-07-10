import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testCreateOrder() {
        String orderNumber = "ORD123";
        Product product = new Product(19.99, "Test Product", "12345");
        int quantity = 2;
        double totalPrice = 39.98;

        Order order = new Order(orderNumber, product, quantity, totalPrice);

        assertEquals(orderNumber, order.orderNumber());
        assertEquals(product, order.product());
        assertEquals(quantity, order.quantity());
        assertEquals(totalPrice, order.totalPrice());
    }

    @Test
    public void testWithQuantity() {
        String orderNumber = "ORD123";
        Product product = new Product(19.99, "Test Product", "12345");
        int initialQuantity = 2;
        double initialTotalPrice = 39.98;

        Order order = new Order(orderNumber, product, initialQuantity, initialTotalPrice);

        int newQuantity = 3;
        double newTotalPrice = product.price() * newQuantity;

        Order updatedOrder = order.withQuantity(newQuantity);

        assertEquals(orderNumber, updatedOrder.orderNumber());
        assertEquals(product, updatedOrder.product());
        assertEquals(newQuantity, updatedOrder.quantity());
        assertEquals(newTotalPrice, updatedOrder.totalPrice());
    }

    @Test
    public void testWithQuantityCreatesNewInstance() {
        String orderNumber = "ORD123";
        Product product = new Product(19.99, "Test Product", "12345");
        int initialQuantity = 2;
        double initialTotalPrice = 39.98;

        Order order = new Order(orderNumber, product, initialQuantity, initialTotalPrice);

        Order updatedOrder = order.withQuantity(3);

        // Verify that a new instance is created
        assertNotSame(order, updatedOrder);
    }

    @Test
    public void testTotalPriceCalculation() {
        Product product = new Product(19.99, "Test Product", "12345");
        int quantity = 4;
        double expectedTotalPrice = product.price() * quantity;

        Order order = new Order("ORD123", product, quantity, expectedTotalPrice);

        assertEquals(expectedTotalPrice, order.totalPrice());
    }
}
