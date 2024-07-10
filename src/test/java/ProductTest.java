import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void testProductCreation() {
        Product product = new Product(10.0, "Product1", "123", 5);

        assertNotNull(product);
        assertEquals(10.0, product.price());
        assertEquals("Product1", product.name());
        assertEquals("123", product.productNumber());
        assertEquals(5, product.quantity());
    }

    @Test
    public void testEqualsAndHashCode() {
        Product product1 = new Product(10.0, "Product1", "123", 5);
        Product product2 = new Product(10.0, "Product1", "123", 5);
        Product product3 = new Product(15.0, "Product2", "456", 2);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1, product3);
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    public void testToString() {
        Product product = new Product(10.0, "Product1", "123", 5);
        String expectedString = "Product[price=10.0, name=Product1, productNumber=123, quantity=5]";

        assertEquals(expectedString, product.toString());
    }
}