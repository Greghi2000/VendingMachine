package Products;

public abstract class Product {

    private String name;
    private double price;
    private int code;

    public Product(String name, double price, int code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
