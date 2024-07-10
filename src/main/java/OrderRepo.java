import java.util.List;

public interface OrderRepo {

    public List<Order> getAllOrders();
    public Order getOrderById(int id);
    public void addOrder(Order order);
    public void removeOrder(Order order);
}
