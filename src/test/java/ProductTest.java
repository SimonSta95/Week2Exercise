import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testCreateProduct() {
        double price = 19.99;
        String name = "Test Product";
        String productNumber = "12345";

        Product product = new Product(price, name, productNumber);

        assertEquals(price, product.price());
        assertEquals(name, product.name());
        assertEquals(productNumber, product.productNumber());
    }

    @Test
    public void testWithPrice() {
        double initialPrice = 19.99;
        double newPrice = 29.99;
        String name = "Test Product";
        String productNumber = "12345";

        Product product = new Product(initialPrice, name, productNumber);
        Product updatedProduct = product.withPrice(newPrice);

        assertEquals(newPrice, updatedProduct.price());
        assertEquals(name, updatedProduct.name());
        assertEquals(productNumber, updatedProduct.productNumber());
    }

    @Test
    public void testWithPriceCreatesNewInstance() {
        double initialPrice = 19.99;
        double newPrice = 29.99;
        String name = "Test Product";
        String productNumber = "12345";

        Product product = new Product(initialPrice, name, productNumber);
        Product updatedProduct = product.withPrice(newPrice);

        // Verify that a new instance is created
        assertNotSame(product, updatedProduct);
    }
}
