import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo{
    Map<String, Order> orderRepo;
    public OrderMapRepo() {
        orderRepo = new HashMap<String, Order>();
    }

    public List<Order> getAllOrders(){
        return new ArrayList<>(orderRepo.values());
    }

    public Order getOrderByNumber(String number){
        return orderRepo.get(number);
    }

    public void addOrder(Order order){
        orderRepo.put(String.valueOf(order.orderNumber()),order);
    }

    public void removeOrder(Order order){
        orderRepo.remove(String.valueOf(order.orderNumber()));
    }
}
