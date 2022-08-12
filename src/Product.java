public class Product {
    private AvailableProducts name;
    private float price;

    public Product(AvailableProducts name, float price) {
        this.name = name;
        this.price = price;
    }

    public AvailableProducts getName() {
        return name;
    }

    public void setName(AvailableProducts name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
