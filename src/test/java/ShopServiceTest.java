import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopServiceTest {
    private ShopService shopService;
    private ProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        shopService = new ShopService();
        productRepo = shopService.productList; // Access the ProductRepo instance used by ShopService

        // Add some products to the product repository for testing
        productRepo.addProduct(new Product(100.0, "Product1", "P001", 10));
        productRepo.addProduct(new Product(150.0, "Product2", "P002", 5));
    }

    @Test
    public void testPlaceOrderByName() {
        shopService.placeOrderByName("Product1");
        List<Product> order = shopService.order;
        assertEquals(1, order.size());
        assertEquals("Product1", order.get(0).name());

        shopService.placeOrderByName("NonExistentProduct");
        assertEquals(1, order.size(), "Order should not add non-existent product");
    }

    @Test
    public void testPlaceOrderByNumber() {
        shopService.placeOrderByNumber("P002");
        List<Product> order = shopService.order;
        assertEquals(1, order.size());
        assertEquals("P002", order.get(0).productNumber());

        shopService.placeOrderByNumber("P999");
        assertEquals(1, order.size(), "Order should not add non-existent product");
    }

    @Test
    public void testCheckAvailability() {
        Product product = productRepo.getProductByName("Product1");
        assertTrue(shopService.checkAvailability(product));

        Product nonExistentProduct = new Product(200.0, "Product3", "P003", 0);
        assertFalse(shopService.checkAvailability(nonExistentProduct));
    }
}