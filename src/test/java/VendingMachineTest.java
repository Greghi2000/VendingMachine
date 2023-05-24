import Coins.Coin;
import Coins.CoinValue;
import Products.Cola;
import Products.Crisps;
import Products.Product;
import Products.Sweets;
import VendingMachine.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Crisps pringles;
    private Sweets haribo;
    private Cola coke;
    private HashMap<Product, Integer> inventory;
    private Coin FiftyPenceCoin;
    private Coin TenPenceCoin;
    private Coin TwentyPenceCoin;
    @Before
    public void before(){
        TenPenceCoin = new Coin(CoinValue.TENPENCE);
        TwentyPenceCoin = new Coin(CoinValue.TWENTYPENCE);
        FiftyPenceCoin = new Coin(CoinValue.FIFTYPENCE);
        coke = new Cola("coke", 10);
        pringles = new Crisps("pringles", 20);
        haribo = new Sweets("haribo", 30);
        inventory = new HashMap<>();
        inventory.put(coke, 3);
        inventory.put(haribo, 2);
        inventory.put(pringles, 5);
        vendingMachine = new VendingMachine(inventory, 10.00);
    }

    @Test
    public void canGetProductByCode(){
        assertEquals(pringles, vendingMachine.getProductByCode(20));
    }
    @Test
    public void canRemoveFromInventory(){
        vendingMachine.removeFromInventory(haribo, 1);
        assertEquals(1, vendingMachine.getQuantityOfProduct(haribo));
    }
    @Test
    public void canPurchaseProduct(){
        vendingMachine.productPurchase(20, 2);
        assertEquals(3, vendingMachine.getQuantityOfProduct(pringles));
        assertEquals(11, vendingMachine.getTill(), 0.0);
    }

    @Test
    public void canInsertCoin(){
        vendingMachine.insertCoin(TenPenceCoin);
//        assertEquals(1, vendingMachine.getCoins().get(CoinValue.TENPENCE));
        Coin coin = new Coin(CoinValue.TENPENCE); // Create a coin object with a specific value
//        vendingMachine.insertCoin(coin);

        int actualQuantity = vendingMachine.getCoins().get(CoinValue.TENPENCE);

        assertEquals(1, actualQuantity);
    }

}
