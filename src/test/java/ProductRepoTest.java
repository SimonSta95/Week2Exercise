import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    private ProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        productRepo = new ProductRepo();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(100.0, "Product1", "P001", 10);
        productRepo.addProduct(product);
        List<Product> products = productRepo.getProducts();
        assertEquals(1, products.size());
        assertTrue(products.contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product(100.0, "Product1", "P001", 10);
        productRepo.addProduct(product);
        productRepo.removeProduct(product);
        List<Product> products = productRepo.getProducts();
        assertFalse(products.contains(product));
    }

    @Test
    public void testGetProductByName() {
        Product product1 = new Product(100.0, "Product1", "P001", 10);
        Product product2 = new Product(150.0, "Product2", "P002", 5);
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        Product foundProduct = productRepo.getProductByName("Product1");
        assertEquals(product1, foundProduct);
        assertNull(productRepo.getProductByName("NonExistentProduct"));
    }

    @Test
    public void testGetProductByNumber() {
        Product product1 = new Product(100.0, "Product1", "P001", 10);
        Product product2 = new Product(150.0, "Product2", "P002", 5);
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        Product foundProduct = productRepo.getProductByNumber("P001");
        assertEquals(product1, foundProduct);
        assertNull(productRepo.getProductByNumber("P999"));
    }

    @Test
    public void testGetProducts() {
        Product product1 = new Product(100.0, "Product1", "P001", 10);
        Product product2 = new Product(150.0, "Product2", "P002", 5);
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);
        List<Product> products = productRepo.getProducts();
        assertEquals(2, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }
}