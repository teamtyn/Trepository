package spacetrader.items;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnits test for CargoBay's methods, specifically the addTradeGood method.
 * @author Clayton
 */
public class CargoBayTest {
    CargoBay cg;
    
    private void addCargoBay() {
        cg = new CargoBay(10);
    }
    /**
     * Test that addTradeGood adds the correct amount of goods.
     */
    @Test
    public void testAddTradeGoodAddsCorrectAmountOfGoods() {
        addCargoBay();
        System.out.println("Add 3 furs.");
        String goodName = "Furs";
        int quantityRequested = 3;
        int expResult = 3;
        int result = cg.addTradeGood(goodName, quantityRequested);
        assertEquals(expResult, result);
        result = cg.getGoods().get("Furs");
        assertEquals(expResult, result);
        System.out.println("Tested that Cargo bay contains 3 furs.");
    }
    
    /**
     * Test that addTradeGood does not add more than the CargoBay's capacity.
     */
    @Test
    public void testAddingTooManyGoods() {
        //create a new Cargo Bay that has a capacity of 10.
        addCargoBay();
        int quantityRequested = 15; //this amount is too greater than capacity
        int expResult = 10;
        int result = cg.addTradeGood("Firearms", quantityRequested);
        assertEquals(expResult, result);
        result = cg.getGoods().get("Firearms");
        assertEquals(expResult, result);
        System.out.println("Tested that Cargo bay did not add more than capacity.");    }
    
    /**
     * Test that addTradeGood does not add negative amounts of goods to the bay.
     */
    @Test
    public void testAddingNegativeGoodsFails() {
        //create a new Cargo Bay that has a capacity of 10
        addCargoBay();
        int quantityRequested = -3; //this amount is negative and should not make any change
        int expResult = 0;
        int result = cg.addTradeGood("Furs", quantityRequested);
        assertEquals(expResult, result);
        //test the good in the hashmap
        result = cg.getGoods().get("Furs");
        assertEquals(expResult, result);
        System.out.println("Tested that Cargo bay did not add negative amounts of good.");
    }

    
}
