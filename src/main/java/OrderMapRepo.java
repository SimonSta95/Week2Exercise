import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo{

    Map<String, Order> orderRepo;

    public List<Order> getAllOrders(){
        return new ArrayList<>(orderRepo.values());
    }

    public Order getOrderById(int id){
        return orderRepo.get(String.valueOf(id));
    }

    public void addOrder(Order order){
        orderRepo.put(String.valueOf(order.orderNumber()),order);
    }

    public void removeOrder(Order order){
        orderRepo.remove(String.valueOf(order.orderNumber()));
    }
}
