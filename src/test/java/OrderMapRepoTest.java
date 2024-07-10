import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderMapRepoTest {
    private OrderMapRepo orderMapRepo;

    @Mock
    private Map<String, Order> mockOrderRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderMapRepo = new OrderMapRepo();
        orderMapRepo.orderRepo = mockOrderRepo;
    }

    @Test
    public void testGetAllOrders() {
        List<Order> expectedOrders = List.of(
                new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10)),
                new Order(String.valueOf(2), new Product(150.0, "Product2", "P002", 5))
        );

        when(mockOrderRepo.values()).thenReturn(new ArrayList<>(expectedOrders));

        List<Order> actualOrders = orderMapRepo.getAllOrders();

        assertEquals(expectedOrders.size(), actualOrders.size());
        assertTrue(actualOrders.containsAll(expectedOrders));
    }

    @Test
    public void testGetOrderById() {
        Order expectedOrder = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));
        String orderId = String.valueOf(expectedOrder.orderNumber());

        when(mockOrderRepo.get(orderId)).thenReturn(expectedOrder);

        Order actualOrder = orderMapRepo.getOrderById(Integer.parseInt(expectedOrder.orderNumber()));

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testAddOrder() {
        Order orderToAdd = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));

        orderMapRepo.addOrder(orderToAdd);

        verify(mockOrderRepo, times(1)).put(String.valueOf(orderToAdd.orderNumber()), orderToAdd);
    }

    @Test
    public void testRemoveOrder() {
        Order orderToRemove = new Order(String.valueOf(1), new Product(100.0, "Product1", "P001", 10));

        when(mockOrderRepo.remove(String.valueOf(orderToRemove.orderNumber()))).thenReturn(orderToRemove);

        orderMapRepo.removeOrder(orderToRemove);

        verify(mockOrderRepo, times(1)).remove(String.valueOf(orderToRemove.orderNumber()));
    }
}