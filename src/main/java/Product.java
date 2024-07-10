public record Product(double price,
                      String name,
                      String productNumber) {

    public Product withPrice(double price) {
        return new Product(price, name, productNumber);
    }
}
