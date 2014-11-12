/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.items;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for trade good removal in cargo bay.
 *
 * @author Administrator
 */
public final class CargoBayGoodRemovalTests {
    /**
     * The max cargo bay capacity used for these tests.
     */
    private static final int MAX_CAPACITY = 10;
    /**
     * Low test value.
     */
    private static final int TEST_LOW = 7;
    /**
     * High test value.
     */
    private static final int TEST_HIGH = 15;

    /**
     * Test of removeTradeGood method, of class CargoBay.
     */
    @Test
    public void testRemoveValid() {
        System.out.println("removeValid");
        CargoBay cargoBay = new CargoBay(MAX_CAPACITY);
        cargoBay.addTradeGood("Furs", MAX_CAPACITY);
        int expResult = TEST_LOW;
        int result = cargoBay.removeTradeGood("Furs", TEST_LOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTradeGood method, of class CargoBay.
     */
    @Test
    public void testRemoveTooMany() {
        System.out.println("removeTooMany");
        CargoBay cargoBay = new CargoBay(MAX_CAPACITY);
        cargoBay.addTradeGood("Furs", MAX_CAPACITY);
        int expResult = MAX_CAPACITY;
        int result = cargoBay.removeTradeGood("Furs", TEST_HIGH);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGoods method, of class CargoBay.
     */
    @Test
    public void testRemoveNegative() {
        System.out.println("removeNegative");
        CargoBay cargoBay = new CargoBay(MAX_CAPACITY);
        cargoBay.addTradeGood("Furs", MAX_CAPACITY);
        int expResult = 0;
        int result = cargoBay.removeTradeGood("Furs", -TEST_LOW);
        assertEquals(expResult, result);
    }
}
