package Coins;

public class Coin {
    private CoinValue value;
    // WEIGHT?

    public Coin(CoinValue value) {
        this.value = value;
    }
    public double getValue() {
        return this.value.getValue();
    }

    public CoinValue returnEnum(){
        return this.value;
    }
}
