package VendingMachine;

import Coins.Coin;
import Coins.CoinValue;
import Products.Crisps;
import Products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class VendingMachine {

    private HashMap<Product, Integer> inventory;
    private HashMap<CoinValue, Integer> coins;
    private double till;
    public VendingMachine(HashMap<Product, Integer> inventory, double till) {
        this.inventory = inventory;
        this.till = till;
        this.coins = new HashMap<CoinValue, Integer>();
        this.coins.put(CoinValue.FIVEPENCE, 0);
        this.coins.put(CoinValue.TENPENCE, 0);
        this.coins.put(CoinValue.TWENTYPENCE, 0);
        this.coins.put(CoinValue.FIFTYPENCE, 0);
        this.coins.put(CoinValue.ONEPOUND, 0);
        this.coins.put(CoinValue.TWOPOUND, 0);
    }

    public void insertCoin(Coin coin){
        Integer quantity = this.coins.get(coin.returnEnum());
        this.coins.replace(coin.returnEnum(), quantity, (quantity + 1));
    }

    public HashMap<CoinValue, Integer> getCoins() {
        return this.coins;
    }



    public HashMap<Product, Integer> getInventory() {
        return this.inventory;
    }

    public void addToInventory(Product product, int quantity){
        this.inventory.put(product, quantity);
    }

    public void removeFromInventory(Product product, int quantity){
        int productValue = this.inventory.get(product);
        this.inventory.replace(product, productValue, (productValue - quantity));
    }

    public void productPurchase(int code, int quantity){
        Product product = this.getProductByCode(code);
        this.removeFromInventory(product, quantity);
        this.increaseTill((product.getPrice() * quantity));
    }

    public Product getProductByCode(int code) {
        Set products = this.inventory.keySet();
        ArrayList<Product> productsList = new ArrayList<>(products);
        for (Product product : productsList) {
            if (product.getCode() == code) {
                return product;
            }
        }
        return null;
    }

    public void setInventory(HashMap<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    public double getTill() {
        return this.till;
    }

    public void increaseTill(double amount){
        this.till += amount;
    }

    public void setTill(double till) {
        this.till = till;
    }
    public int getQuantityOfProduct(Product product){
        return this.inventory.get(product);
    }
}
