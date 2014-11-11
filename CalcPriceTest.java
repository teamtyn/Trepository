import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.market.TradeGood;
import spacetrader.star_system.Planet;

/**
 * JUnit test for the calcPrice() method of TradeGood.java.
 * @author Ryan Burns
 */
public class CalcPriceTest {
    /**
     * The number of randomly generated planets to test.
     */
    private static final int NUM_PLANETS = 10;
    /**
     * The number of randomly generated planets to test.
     */
    private static final int NUM_GOODS = 10;

    /**
     * All the goods on each planet in the universe.
     */
    private final ArrayList<ArrayList<TradeGood>> goods;
    /**
     * All the planets in the universe.
     */
    private final ArrayList<Planet> planets;

    /**
     * Constructor for the test which sets up the planets and goods lists.
     */
    public CalcPriceTest() {
        goods = new ArrayList<>(NUM_PLANETS);
        planets = new ArrayList<>(NUM_PLANETS);
        for (int i = 0; i < planets.size(); i++) {
            planets.add(new Planet());
            goods.add(new ArrayList<>(NUM_GOODS));
        }
        for (int i = 0; i < planets.size(); i++) {
            Planet thisPlanet = planets.get(i);
            ArrayList<TradeGood> theseGoods = goods.get(i);
            for (TradeGood.GoodType type : TradeGood.GoodType.values()) {
                TradeGood newGood = new TradeGood(type, thisPlanet);
                theseGoods.add(newGood);
            }
        }
    }

    /**
     * Verifies some basic characteristics of the test.
     */
    @Test
    public final void testSetUp() {
        assertEquals(planets.size(), goods.size(), NUM_PLANETS);
        for (ArrayList<TradeGood> planetsGoods : goods) {
            assertEquals(NUM_GOODS, planetsGoods.size());
        }
    }

    /**
     * Verifies that every good in the universe has a price smaller than its
     *     maximum value.
     */
    @Test
    public final void testSmallerThanMax() {
        for (ArrayList<TradeGood> planetsGoods : goods) {
            for (TradeGood good : planetsGoods) {
                assertTrue(good.getPrice() < good.type.mhl);
            }
        }
    }

    /**
     * Verifies that every good in the universe has a price greater than its
     *     minimum value.
     */
    @Test
    public final void testBiggerThanMin() {
        for (ArrayList<TradeGood> planetsGoods : goods) {
            for (TradeGood good : planetsGoods) {
                assertTrue(good.getPrice() > good.type.mtl);
            }
        }
    }
}
