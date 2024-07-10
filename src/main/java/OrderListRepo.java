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

    public Order getOrderById(int id) {
        for (Order order : orderRepo) {
            if(Objects.equals(order.orderNumber(), String.valueOf(id))){
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
