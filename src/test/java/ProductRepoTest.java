import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProductRepoTest {

    private ProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        productRepo = new ProductRepo();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(19.99, "Test Product", "12345");
        productRepo.addProduct(product);

        List<Product> products = productRepo.getProducts();
        assertThat(products).contains(product);
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product(19.99, "Test Product", "12345");
        productRepo.addProduct(product);
        productRepo.removeProduct(product);

        List<Product> products = productRepo.getProducts();
        assertThat(products).doesNotContain(product);
    }

    @Test
    public void testGetProductByName() {
        Product product1 = new Product(19.99, "Test Product 1", "12345");
        Product product2 = new Product(29.99, "Test Product 2", "67890");
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        Product foundProduct = productRepo.getProductByName("Test Product 1");
        assertThat(foundProduct).isEqualTo(product1);

        Product notFoundProduct = productRepo.getProductByName("Non-existent Product");
        assertThat(notFoundProduct).isNull();
    }

    @Test
    public void testGetProductByNumber() {
        Product product1 = new Product(19.99, "Test Product 1", "12345");
        Product product2 = new Product(29.99, "Test Product 2", "67890");
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        Product foundProduct = productRepo.getProductByNumber("12345");
        assertThat(foundProduct).isEqualTo(product1);

        Product notFoundProduct = productRepo.getProductByNumber("00000");
        assertThat(notFoundProduct).isNull();
    }

    @Test
    public void testGetProducts() {
        Product product1 = new Product(19.99, "Test Product 1", "12345");
        Product product2 = new Product(29.99, "Test Product 2", "67890");
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        List<Product> products = productRepo.getProducts();
        assertThat(products).containsExactlyInAnyOrder(product1, product2);
        assertThat(products).hasSize(2);
    }
}
