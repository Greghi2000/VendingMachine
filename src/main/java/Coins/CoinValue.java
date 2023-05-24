package Coins;

public enum CoinValue {
    FIVEPENCE(0.05),
    TENPENCE(0.10),
    TWENTYPENCE(0.20),
    FIFTYPENCE(0.50),
    ONEPOUND(1),
    TWOPOUND(2);
    private final double value;

    CoinValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
