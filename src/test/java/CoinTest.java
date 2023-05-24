import Coins.Coin;
import Coins.CoinValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {
    Coin FiftyPenceCoin;
    Coin TenPenceCoin;
    Coin TwentyPenceCoin;
    @Before
    public void before(){
        TenPenceCoin = new Coin(CoinValue.TENPENCE);
        TwentyPenceCoin = new Coin(CoinValue.TWENTYPENCE);
        FiftyPenceCoin = new Coin(CoinValue.FIFTYPENCE);
    }

    @Test
    public void canGetValue20(){
        assertEquals(0.2, TwentyPenceCoin.getValue(), 0.0);
    }
    @Test
    public void canGetValue50(){
        assertEquals(0.5, FiftyPenceCoin.getValue(), 0.0);
    }
    @Test
    public void canGetValue10(){
        assertEquals(0.1, TenPenceCoin.getValue(), 0.0);
    }
}
