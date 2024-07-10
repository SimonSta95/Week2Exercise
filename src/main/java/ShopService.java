import java.util.List;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(OrderListRepo listRepo, ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.orderRepo = listRepo;
    }

    public ShopService(OrderMapRepo mapRepo, ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.orderRepo = mapRepo;
    }

    public Order createOrder(String orderNumber, Product product){

        if(checkAvailabiltiy(product)){
            Order newOrder = new Order(orderNumber, product);
            if(checkDuplicateOrder(newOrder)) {

                orderRepo.addOrder(newOrder);
                return newOrder;
            }
        }

        System.out.println("Order was not created.");
        return null;
    }

    public boolean checkDuplicateOrder(Order order){
        List<Order> orders = orderRepo.getAllOrders();
        for(Order o : orders){
            if(o.equals(order)){
                System.out.println("Order already exists.");
                return false;
            }
        }
        return true;
    }

    public boolean checkAvailabiltiy(Product product){
        List<Product> products = productRepo.getProducts();
        for(Product p : products){
            if(p == product){
                return true;
            }
        }

        System.out.println("Product is not available.");
        return false;
    }
}
