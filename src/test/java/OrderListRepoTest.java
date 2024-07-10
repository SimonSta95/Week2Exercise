import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class OrderListRepoTest {

    private OrderListRepo orderListRepo;
    private Product product;

    @BeforeEach
    public void setUp() {
        orderListRepo = new OrderListRepo();
        product = new Product(19.99, "Test Product", "12345");
    }

    @Test
    public void testAddOrder() {
        Order order = new Order("ORD123", product, 2, 39.98);
        orderListRepo.addOrder(order);

        List<Order> orders = orderListRepo.getAllOrders();
        assertThat(orders).contains(order);
    }

    @Test
    public void testRemoveOrder() {
        Order order = new Order("ORD123", product, 2, 39.98);
        orderListRepo.addOrder(order);
        orderListRepo.removeOrder(order);

        List<Order> orders = orderListRepo.getAllOrders();
        assertThat(orders).doesNotContain(order);
    }

    @Test
    public void testGetOrderByNumber() {
        Order order1 = new Order("ORD123", product, 2, 39.98);
        Order order2 = new Order("ORD456", product, 3, 59.97);
        orderListRepo.addOrder(order1);
        orderListRepo.addOrder(order2);

        Order foundOrder = orderListRepo.getOrderByNumber("ORD123");
        assertThat(foundOrder).isEqualTo(order1);

        Order notFoundOrder = orderListRepo.getOrderByNumber("ORD999");
        assertThat(notFoundOrder).isNull();
    }

    @Test
    public void testGetAllOrders() {
        Order order1 = new Order("ORD123", product, 2, 39.98);
        Order order2 = new Order("ORD456", product, 3, 59.97);
        orderListRepo.addOrder(order1);
        orderListRepo.addOrder(order2);

        List<Order> orders = orderListRepo.getAllOrders();
        assertThat(orders).containsExactlyInAnyOrder(order1, order2);
        assertThat(orders).hasSize(2);
    }
}
