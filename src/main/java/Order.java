public record Order(String orderNumber,
                    Product product,
                    int quantity,
                    double totalPrice) {

    public Order withQuantity(int quantity) {

        double totalPrice = product.price()*quantity;
        return new Order(orderNumber, product, quantity, totalPrice);
    }
}
