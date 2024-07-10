import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

public class ShopServiceTest {

    private ShopService shopService;
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    @BeforeEach
    public void setUp() {
        // Mock repositories
        productRepo = new ProductRepo();
        orderRepo = new OrderListRepo(); // or OrderMapRepo

        // Initialize ShopService with mock repositories
        shopService = new ShopService((OrderListRepo) orderRepo,productRepo);

        // Add some mock products to productRepo
        productRepo.addProduct(new Product(10.0, "Product A", "A001", 5));
        productRepo.addProduct(new Product(15.0, "Product B", "B001", 3));
    }

    @Test
    public void testCreateOrderSuccess() {
        Product product = productRepo.getProductByName("Product A");
        Order order = shopService.createOrder("ORD001", product);

        assertNotNull(order);
        assertEquals("ORD001", order.orderNumber());
        assertEquals(product, order.product());
    }

    @Test
    public void testCreateOrderDuplicate() {
        Product product = productRepo.getProductByName("Product A");
        Order order1 = shopService.createOrder("ORD001", product);
        Order order2 = shopService.createOrder("ORD001", product);

        assertNotNull(order1);
        assertNull(order2); // Second order creation should fail
    }

    @Test
    public void testCreateOrderProductNotAvailable() {
        Product nonExistingProduct = new Product(20.0, "Product C", "C001", 1);
        Order order = shopService.createOrder("ORD002", nonExistingProduct);

        assertNull(order);
    }

    @Test
    public void testCheckDuplicateOrderExistingOrder() {

        orderRepo.addOrder(new Order("ORD001", new Product(10.0, "Product A", "A001", 5)));

        Order existingOrder = new Order("ORD001", new Product(10.0, "Product A", "A001", 5));
        boolean result = shopService.checkDuplicateOrder(existingOrder);

        assertFalse(result);
    }

    @Test
    public void testCheckDuplicateOrderNewOrder() {
        Order newOrder = new Order("ORD003", new Product(20.0, "Product C", "C001", 2));
        boolean result = shopService.checkDuplicateOrder(newOrder);

        assertTrue(result);
    }

    @Test
    public void testCheckAvailabilityProductAvailable() {
        Product product = productRepo.getProductByName("Product A");
        boolean result = shopService.checkAvailabiltiy(product);

        assertTrue(result);
    }

    @Test
    public void testCheckAvailabilityProductNotAvailable() {
        Product nonExistingProduct = new Product(20.0, "Product C", "C001", 1);
        boolean result = shopService.checkAvailabiltiy(nonExistingProduct);

        assertFalse(result);
    }
}
