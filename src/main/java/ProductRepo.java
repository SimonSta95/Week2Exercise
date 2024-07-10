import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    List<Product> repo = new ArrayList<>();

    public void addProduct(Product p) {
        repo.add(p);
    }

    public void removeProduct(Product p) {
        repo.remove(p);
    }

    public Product getProduct(String productNumber) {
        for (Product p : repo) {
            if (p.productNumber() == productNumber) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return repo;
    }
}
