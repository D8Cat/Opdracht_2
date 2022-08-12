import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private HashMap<Product, Integer> cart;
    private int day = 3;

    public Cart() {
        this.cart = new HashMap<>();
        cart.put(new Product(AvailableProducts.ROBIJN, 3f), 0);
        cart.put(new Product(AvailableProducts.BRINTA, 2.5f), 0);
        cart.put(new Product(AvailableProducts.CHINESE_GROENTEN, 5f), 0);
        cart.put(new Product(AvailableProducts.KWARK, 2f), 0);
        cart.put(new Product(AvailableProducts.LUIERS, 10f), 0);
    }

    public void addToCart(Product product, int amount) {
        if (cart.containsKey(product)) {
            cart.put(product, (cart.get(product) + amount));
        }
        cart.put(product, amount);
    }

    public void removeFromCart(Product product) {
        if (cart.get(product) >= 1) {
            cart.put(product, cart.get(product) - 1);
        }
    }

    public float totalCost() {
        float cost = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            cost += entry.getKey().getPrice() * entry.getValue();
        }
        return cost;
    }

    public float calculateDiscount() {
        float discount = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if (entry.getKey().getName() == AvailableProducts.ROBIJN) {
                discount += (entry.getValue() - (entry.getValue()%2)) * entry.getKey().getPrice() * 0.31;
            }
            if (day == 3 && entry.getKey().getName() == AvailableProducts.KWARK) {
                discount += entry.getValue();
            }
            if (entry.getKey().getName() == AvailableProducts.LUIERS) {
                discount += (entry.getValue()/4f) * entry.getKey().getPrice();
            }
        }
        return discount;
    }

    public void checkout(float payment) {
        float totalCost = totalCost() - calculateDiscount();
        if (payment > totalCost) {
            System.out.print("Total cost = $");
            System.out.printf("%.2f", totalCost);
            System.out.print("\nYou've paid $");
            System.out.printf("%.2f", payment);
            System.out.printf(" in cash.\nYour change is $");
            System.out.printf("%.2f", + (payment - totalCost));
        } else {
            System.out.println("Insufficient funds. You need to pay $");
            System.out.printf("%.2f", totalCost);
        }
    }


    public void setDay(int day) {
        this.day = day;
    }

    public HashMap<Product, Integer> getCart() {
        return cart;
    }
}
