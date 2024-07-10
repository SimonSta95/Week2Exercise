import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
    List<Order> orderRepo;

    public OrderListRepo() {
        orderRepo = new ArrayList<>();
    }

    public List<Order> getAllOrders() {
        return orderRepo;
    }

    public Order getOrderById(int id) {
        for (Order order : orderRepo) {
            if(order.orderNumber() == id){
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
