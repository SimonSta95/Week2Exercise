import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShopServiceTest {
    private ShopService shopService;
    private ProductRepo productRepo;
    private OrderListRepo orderRepo;

    @BeforeEach
    public void setUp() {
        productRepo = new ProductRepo();
        orderRepo = new OrderListRepo();

        // Mock ShopService to use the mock repositories
        shopService = new ShopService();
        shopService.productRepo = productRepo;
        shopService.orderRepo = orderRepo;

        // Add some products to the product repository for testing
        productRepo.addProduct(new Product(100.0, "Product1", "P001", 10));
        productRepo.addProduct(new Product(150.0, "Product2", "P002", 5));
    }

    @Test
    public void testCreateOrderSuccess() {
        Product product = productRepo.getProductByName("Product1");
        int orderNumber = 1;

        Order order = shopService.createOrder(orderNumber, product);

        assertNotNull(order, "Order should be created successfully");
        assertEquals(orderNumber, order.orderNumber());
        assertEquals(product, order.product());

        // Check that the order was added to the orderRepo
        List<Order> orders = orderRepo.getAllOrders();
        assertTrue(orders.contains(order));
    }

    @Test
    public void testCreateOrderProductNotAvailable() {
        Product unavailableProduct = new Product(200.0, "Product3", "P003", 0);
        int orderNumber = 2;

        Order order = shopService.createOrder(orderNumber, unavailableProduct);

        assertNull(order, "Order should not be created if product is not available");
    }

    @Test
    public void testCreateOrderDuplicateOrder() {
        Product product = productRepo.getProductByName("Product1");
        int orderNumber = 1;

        // Create the first order
        Order order1 = shopService.createOrder(orderNumber, product);
        assertNotNull(order1, "First order should be created successfully");

        // Trying to create a duplicate order
        Order order2 = shopService.createOrder(orderNumber, product);

        assertNull(order2, "Duplicate order should not be created");
    }

    @Test
    public void testCheckDuplicateOrder() {
        Product product = new Product(100.0, "Product1", "P001", 10);
        int orderNumber = 1;

        Order order = new Order(orderNumber, product);

        // Add the order to the mock repository
        orderRepo.addOrder(order);

        // Verify checkDuplicateOrder method
        assertFalse(shopService.checkDuplicateOrder(order), "Duplicate order should return false");
    }

    @Test
    public void testCheckAvailability() {
        Product availableProduct = productRepo.getProductByName("Product1");
        Product unavailableProduct = new Product(200.0, "Product3", "P003", 0);

        assertTrue(shopService.checkAvailabiltiy(availableProduct), "Available product should return true");
        assertFalse(shopService.checkAvailabiltiy(unavailableProduct), "Unavailable product should return false");
    }
}
