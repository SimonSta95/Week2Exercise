import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class OrderMapRepoTest {

    private OrderMapRepo orderMapRepo;
    private Product product;

    @BeforeEach
    public void setUp() {
        orderMapRepo = new OrderMapRepo();
        product = new Product(19.99, "Test Product", "12345");
    }

    @Test
    public void testAddOrder() {
        Order order = new Order("ORD123", product, 2, 39.98);
        orderMapRepo.addOrder(order);

        Order retrievedOrder = orderMapRepo.getOrderByNumber("ORD123");
        assertEquals(order, retrievedOrder);
    }

    @Test
    public void testRemoveOrder() {
        Order order = new Order("ORD123", product, 2, 39.98);
        orderMapRepo.addOrder(order);
        orderMapRepo.removeOrder(order);

        Order retrievedOrder = orderMapRepo.getOrderByNumber("ORD123");
        assertNull(retrievedOrder);
    }

    @Test
    public void testGetOrderByNumber() {
        Order order1 = new Order("ORD123", product, 2, 39.98);
        Order order2 = new Order("ORD456", product, 3, 59.97);
        orderMapRepo.addOrder(order1);
        orderMapRepo.addOrder(order2);

        Order foundOrder = orderMapRepo.getOrderByNumber("ORD123");
        assertEquals(order1, foundOrder);

        Order notFoundOrder = orderMapRepo.getOrderByNumber("ORD999");
        assertNull(notFoundOrder);
    }

    @Test
    public void testGetAllOrders() {
        Order order1 = new Order("ORD123", product, 2, 39.98);
        Order order2 = new Order("ORD456", product, 3, 59.97);
        orderMapRepo.addOrder(order1);
        orderMapRepo.addOrder(order2);

        List<Order> orders = orderMapRepo.getAllOrders();
        assertTrue(orders.contains(order1));
        assertTrue(orders.contains(order2));
        assertEquals(2, orders.size());
    }
}
