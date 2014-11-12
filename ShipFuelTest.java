package spacetrader.items;

import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.items.Ship.ShipType;

/**
 *
 * @author Purcell7
 */
public class ShipTest {
  
    public ShipTest() {
        
    }

    /**
     * Test of addFuel method, of class Ship.
     */
    @Test
    public void testAddSomeFuel() {
        System.out.println("addSomeFuel");
        double newFuel = 50.0;
        Ship instance = new Ship(ShipType.Gnat);
        double expResult = 50.0;
        double result = instance.addFuel(newFuel);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of addFuel method, of class Ship.
     */
    @Test
    public void testAddAllFuel() {
        System.out.println("addSomeFuel");
        double newFuel = 100.0;
        Ship instance = new Ship(ShipType.Gnat);
        double expResult = 100.0;
        double result = instance.addFuel(newFuel);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of addFuel method, of class Ship.
     */
    @Test
    public void testAddLotsFuel() {
        System.out.println("addLotsFuel");
        double newFuel = 200.0;
        Ship instance = new Ship(ShipType.Gnat);
        double expResult = 100.0;
        double result = instance.addFuel(newFuel);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMissingFuel method, of class Ship.
     */
    @Test
    public void testGetMissingFuel() {
        System.out.println("getMissingFuel");
        double newFuel = 50.0;
        Ship instance = new Ship(ShipType.Gnat);
        instance.addFuel(newFuel);
        double expResult = 50.0;
        double result = instance.getMissingFuel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of emptyFuel method, of class Ship.
     */
    @Test
    public void testEmptyFuel() {
        System.out.println("emptyFuel");
        Ship instance = new Ship(ShipType.Gnat);
        instance.emptyFuel();
        double expResult = 0.0;
        double result = instance.getFuel();
        assertEquals(expResult, result, 0.0);
    }
    
}
