import java.util.List;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void createOrder(String orderNumber, Product product, int quantity){

        if(checkAvailabiltiy(product)){

            double totalPrice = quantity * product.price();
            Order newOrder = new Order(orderNumber, product, quantity , totalPrice);
            if(checkDuplicateOrder(newOrder)) {

                orderRepo.addOrder(newOrder);
                return;
            }
        }

        System.out.println("Order was not created.");
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
