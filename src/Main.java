public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Product robijn = new Product(AvailableProducts.ROBIJN, 3f);
        Product brinta = new Product(AvailableProducts.BRINTA, 2.5f);
        Product chineseGroenten = new Product(AvailableProducts.CHINESE_GROENTEN, 5f);
        Product kwark = new Product(AvailableProducts.KWARK, 2f);
        Product luiers = new Product(AvailableProducts.LUIERS, 10f);
        cart.addToCart(robijn, 10);
        cart.addToCart(luiers, 4);
        cart.calculateDiscount();
        cart.checkout(100);

    }
}