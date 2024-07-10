import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderListRepoTest {
    private OrderListRepo orderListRepo;

    @BeforeEach
    public void setUp() {
        orderListRepo = new OrderListRepo();
    }

    @Test
    public void testAddOrder() {
        Order order = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));
        orderListRepo.addOrder(order);
        List<Order> orders = orderListRepo.getAllOrders();
        assertEquals(1, orders.size());
        assertTrue(orders.contains(order));
    }

    @Test
    public void testRemoveOrder() {
        Order order = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));
        orderListRepo.addOrder(order);
        orderListRepo.removeOrder(order);
        List<Order> orders = orderListRepo.getAllOrders();
        assertFalse(orders.contains(order));
        assertTrue(orders.isEmpty());
    }

    @Test
    public void testGetAllOrders() {
        Order order1 = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));
        Order order2 = new Order(String.valueOf(2), new Product(150.0, "Product2", "P002", 5));
        orderListRepo.addOrder(order1);
        orderListRepo.addOrder(order2);
        List<Order> orders = orderListRepo.getAllOrders();
        assertEquals(2, orders.size());
        assertTrue(orders.contains(order1));
        assertTrue(orders.contains(order2));
    }

    @Test
    public void testGetOrderById() {
        Order order1 = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));
        Order order2 = new Order(String.valueOf(2), new Product(150.0, "Product2", "P002", 5));
        orderListRepo.addOrder(order1);
        orderListRepo.addOrder(order2);
        Order foundOrder = orderListRepo.getOrderById(1);
        assertEquals(order1, foundOrder);
        assertNull(orderListRepo.getOrderById(999), "Non-existent order ID should return null");
    }
}
