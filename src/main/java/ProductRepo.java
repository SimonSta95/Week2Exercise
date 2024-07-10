import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    List<Product> repo;

    public ProductRepo() {
        repo = new ArrayList<>();
    }

    public void addProduct(Product p) {
        repo.add(p);
    }

    public void removeProduct(Product p) {
        repo.remove(p);
    }

    public Product getProductByName(String productName) {
        for (Product p : repo) {
            if (p.name() == productName) {
                return p;
            }
        }
        return null;
    }

    public Product getProductByNumber(String productNumber) {
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
