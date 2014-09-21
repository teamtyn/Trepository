package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;
import javafx.scene.paint.Color;

/**
 * 
 * @author David Purcell
 */
public class Planet {
    private final String name;
    private int orbitDistance; //Good way to layout system? Should be a grid
    private Government government;
    private enum TechLevel {PREAGRICULTURAL, AGRICULTURAL, 
                           MEDIVAL, RENAISSANCE, 
                           EARLYINDUSTRY, INDUSTRIAL, 
                           POSTINDUSTRIAL, HIGHTECH};
    private enum ResourceLevel {NOSPECIALRESOURCES, MINERALRICH, MINERALPOOR,
                          DESERT, LOTSOFWATER, RICHSOIL,
                          POORSOIL, RICHFAUNA, LIFELESS,
                          WEIRDMUSHROOMS, LOTSOFHERBS,
                          ARTISTIC, WARLIKE};
    private ResourceLevel resourceLevel;
    private TechLevel techLevel;
    private Random random = new Random();
    private final Color color;
    private final int size;

    public Planet(String name) {
        this.name = name;
        resourceLevel = ResourceLevel.values()[random.nextInt(ResourceLevel.values().length)];
        techLevel = TechLevel.values()[random.nextInt(TechLevel.values().length)];
        size = random.nextInt(5) + 1;
        color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));//TODO: Josh make fancier
        orbitDistance = random.nextInt(30) + 20;//Distance between planet and star
        government = new Government();
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public ResourceLevel getResourceLevel() {
        return resourceLevel;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setResourceLevel(ResourceLevel newRes) {
        resourceLevel = newRes;
    }

    public void setTechLevel(TechLevel newTech) {
        techLevel = newTech;
    }

    public void revolt() {
        government.revolution();
    }

    public void becomeMonarch(String name){
        government.imInControl(name);
    }

    public int getOrbitDistance(){
        return orbitDistance;
    }

    @Override
    public String toString() {
        String str = "Planet: " + name + "\nResource Level: " + resourceLevel + "\nTech Level: " + techLevel
                        + "\nUnder rule of " + government;
        return str;
    }
}