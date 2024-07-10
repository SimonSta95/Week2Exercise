import java.util.ArrayList;
import java.util.List;

public class ShopService {

    ProductRepo productList = new ProductRepo();

    List<Product> order = new ArrayList<>();

    public void placeOrderByName(String productName) {
        Product product = productList.getProductByName(productName);
        if(checkAvailability(product)) {

            order.add(product);
        }
    }

    public void placeOrderByNumber(String productNumber) {
        Product product = productList.getProductByNumber(productNumber);
        if(checkAvailability(product)) {
            order.add(product);
        }

    }

    public boolean checkAvailability(Product product) {
        List<Product> products = productList.getProducts();

        for (Product p : products) {
            if(p == product) {
                return true;
            }
        }
        System.out.println("Product not available.");
        return false;
    }

}
