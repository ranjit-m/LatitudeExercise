import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class BestProfitTest {

    @Test
    void getMaxProfit() {
        BestProfit bestProfit = new BestProfit();

        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        assertEquals(6, bestProfit.getMaxProfit(stockPrices));
    }

    @Test
    void getMaxProfitRandomInput1() {
        BestProfit bestProfit = new BestProfit();

        int[] stockPrices = {2, 87, 1, 24, 100, 7, 5, 8, 11, 88};
        assertEquals(99, bestProfit.getMaxProfit(stockPrices));
    }

    @Test
    void getMaxProfitRandomInput2() {
        BestProfit bestProfit = new BestProfit();

        int[] stockPrices = {1, 4, 7, 9, 18, 20};
        assertEquals(19, bestProfit.getMaxProfit(stockPrices));
    }

    @Test
    void getMaxProfitDecreasingPrices() {
        BestProfit bestProfit = new BestProfit();

        int[] stockPrices = {20, 18, 9, 7, 4, 1};
        assertEquals(0, bestProfit.getMaxProfit(stockPrices));
    }

    @Test
    public void emptyArrayShouldThrowException() {
        final BestProfit bestProfit = new BestProfit();

        final int[] stockPrices = {};
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                bestProfit.getMaxProfit(stockPrices);
            }
        });
    }

    @Test
    public void singleElementArrayShouldThrowException() {
        final BestProfit bestProfit = new BestProfit();

        final int[] stockPrices = {20};
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                bestProfit.getMaxProfit(stockPrices);
            }
        });
    }

    @Test
    void nullArrayShouldThrowException() {
        final BestProfit bestProfit = new BestProfit();

        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                bestProfit.getMaxProfit(null);
            }
        });
    }

    @Test
    void veryLargeArrayShouldReturnCorrectValue () {
        int [] largeArray = new int[1440];
        Random r = new Random();

        // generate numbers between 20 and 140 to simulate
        // stock price for every minute of a day (1440 mins in 24 hours)
        for (int i = 0; i < 1440; i++) {
            int next = 20 + r.nextInt(121);
            largeArray[i] = next;
        }

        largeArray[75] = 5;     // Set the minimum stock price here outside of the random number range
        largeArray[1439] = 155;   // Set the maximum stock price here outside of the random number range

        BestProfit bestProfit = new BestProfit();
        assertEquals(150, bestProfit.getMaxProfit(largeArray));
    }
}