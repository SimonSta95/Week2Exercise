import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {
    List<Order> orderRepo;

    public OrderListRepo() {
        orderRepo = new ArrayList<>();
    }

    public List<Order> getAllOrders() {
        return orderRepo;
    }

    public Order getOrderByNumber(String number) {
        for (Order order : orderRepo) {
            if(Objects.equals(order.orderNumber(), number)){
                return order;
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        orderRepo.add(order);
    }
    public void removeOrder(Order order) {
        orderRepo.remove(order);
    }
}
