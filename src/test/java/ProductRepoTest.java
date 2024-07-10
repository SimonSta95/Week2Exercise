import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProductRepoTest {
    @Test
    public void testAddProduct() {
        ProductRepo repo = new ProductRepo();
        Product product = new Product(10.0, "Product1", "123", 1);

        repo.addProduct(product);
        List<Product> products = repo.getProducts();

        assertEquals(1, products.size());
        assertTrue(products.contains(product));
    }

    @Test
    public void testRemoveProduct() {
        ProductRepo repo = new ProductRepo();
        Product product = new Product(10.0, "Product1", "123", 1);

        repo.addProduct(product);
        repo.removeProduct(product);
        List<Product> products = repo.getProducts();

        assertEquals(0, products.size());
        assertFalse(products.contains(product));
    }

    @Test
    public void testGetProduct() {
        ProductRepo repo = new ProductRepo();
        Product product1 = new Product(10.0, "Product1", "123", 1);
        Product product2 = new Product(15.0, "Product2", "456", 2);

        repo.addProduct(product1);
        repo.addProduct(product2);

        Product foundProduct = repo.getProduct("123");

        assertNotNull(foundProduct);
        assertEquals("123", foundProduct.productNumber());
    }

    @Test
    public void testGetProductNotFound() {
        ProductRepo repo = new ProductRepo();
        Product product = new Product(10.0, "Product1", "123", 1);

        repo.addProduct(product);
        Product foundProduct = repo.getProduct("456");

        assertNull(foundProduct);
    }

    @Test
    public void testGetProducts() {
        ProductRepo repo = new ProductRepo();
        Product product1 = new Product(10.0, "Product1", "123", 1);
        Product product2 = new Product(15.0, "Product2", "456", 2);

        repo.addProduct(product1);
        repo.addProduct(product2);
        List<Product> products = repo.getProducts();

        assertEquals(2, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }
}