public class Main {
    public static void main(String[] args) {
        ProductRepo pRepo = new ProductRepo();

        //Choose Map or List
        OrderListRepo olRepo = new OrderListRepo();
        OrderMapRepo omRepo = new OrderMapRepo();

        ShopService shop = new ShopService(omRepo, pRepo);

        pRepo.addProduct(new Product(12.50,"Product 1", "001",100));
        pRepo.addProduct(new Product(9.40,"Product 2", "002",12));
        pRepo.addProduct(new Product(15.20,"Product 3", "003",1));
        pRepo.addProduct(new Product(7.10,"Product 4", "004",50));
        pRepo.addProduct(new Product(100.95,"Product 5", "005",13));

        shop.createOrder("1", pRepo.getProductByName("Product 3"));
        shop.createOrder("2", pRepo.getProductByName("Product 5"));
        shop.createOrder("1", pRepo.getProductByName("Product 1"));



    }
}
