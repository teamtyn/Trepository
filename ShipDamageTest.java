package spacetrader.items;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Nicolas
 */
public class ShipDamageTest {

    /**
     * If there's no shield and the damage doesn't destroy the ship, then the
     * damage is the simple difference.
     */
    @Test
    public final void testNoShieldNormalDamageDealt() {
        System.out.println("noShieldNormalDamageDealt");
        Ship ship = new Ship(Ship.ShipType.Wasp);
        assertEquals(200, ship.takeDamage(300));
    }

    /**
     * If the damage would destroy the ship outright, the damage is at most the
     * ship's health.
     */
    @Test
    public final void testNoShieldOverkillDamageDealt() {
        System.out.println("noShieldOverkillDamageDealt");
        Ship ship = new Ship(Ship.ShipType.Wasp);
        assertEquals(0, ship.takeDamage(10000));
    }

    /**
     * If the damage would be fully absorbed by the shield, the ship takes no
     * damage.
     */
    @Test
    public final void testShieldNormalDamageAbsorbed() {
        System.out.println("shieldNormalDamageAbsorbed");
        Ship ship = new Ship(Ship.ShipType.Wasp);
        Shield shield = new Shield(Shield.ShieldType.Kite);
        ship.addShield(shield);
        assertEquals(500, ship.takeDamage(10));
        assertEquals(90, shield.getStrength());
    }

    /**
     * If the damage would not be fully absorbed by the shield, the ship takes
     * normal damage.
     */
    @Test
    public final void testShieldInsufficientDamageDealt() {
        System.out.println("shieldNormalDamageAbsorbed");
        Ship ship = new Ship(Ship.ShipType.Wasp);
        Shield shield = new Shield(Shield.ShieldType.Kite);
        ship.addShield(shield);
        assertEquals(300, ship.takeDamage(200));
        assertEquals(100, shield.getStrength());
    }
}
