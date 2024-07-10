import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ShopServiceTest {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;
    private ShopService shopService;

    private Product product;
    private Order order;

    @BeforeEach
    public void setUp() {
        productRepo = Mockito.mock(ProductRepo.class);
        orderRepo = Mockito.mock(OrderRepo.class);

        product = new Product(19.99, "Test Product", "12345");
        order = new Order("ORD123", product, 2, 39.98);

        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.when(productRepo.getProducts()).thenReturn(products);

        shopService = new ShopService(orderRepo, productRepo);
    }

    @Test
    public void testCreateOrder() {
        Mockito.when(orderRepo.getAllOrders()).thenReturn(new ArrayList<>());

        shopService.createOrder("ORD123", product, 2);

        Mockito.verify(orderRepo, Mockito.times(1)).addOrder(Mockito.any(Order.class));
    }

    @Test
    public void testCreateOrderWhenProductNotAvailable() {
        List<Product> emptyProductList = new ArrayList<>();
        Mockito.when(productRepo.getProducts()).thenReturn(emptyProductList);

        shopService.createOrder("ORD123", product, 2);

        Mockito.verify(orderRepo, Mockito.never()).addOrder(Mockito.any(Order.class));
    }

    @Test
    public void testCreateOrderWhenOrderIsDuplicate() {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        Mockito.when(orderRepo.getAllOrders()).thenReturn(orders);

        shopService.createOrder("ORD123", product, 2);

        Mockito.verify(orderRepo, Mockito.never()).addOrder(Mockito.any(Order.class));
    }

    @Test
    public void testCheckDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        Mockito.when(orderRepo.getAllOrders()).thenReturn(orders);

        boolean isDuplicate = shopService.checkDuplicateOrder(order);

        assertThat(isDuplicate).isFalse();
    }

    @Test
    public void testCheckAvailabiltiy() {
        boolean isAvailable = shopService.checkAvailabiltiy(product);

        assertThat(isAvailable).isTrue();
    }

    @Test
    public void testCheckAvailabiltiyWhenProductNotAvailable() {
        List<Product> emptyProductList = new ArrayList<>();
        Mockito.when(productRepo.getProducts()).thenReturn(emptyProductList);

        boolean isAvailable = shopService.checkAvailabiltiy(product);

        assertThat(isAvailable).isFalse();
    }
}
