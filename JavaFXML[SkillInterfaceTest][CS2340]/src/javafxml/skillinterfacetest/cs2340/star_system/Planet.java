/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author Purcell7
 */
public class Planet {
    protected String name;
    protected int orbitDistance;//Good way to layout system?
    protected Government government;//Object or Enum?
    protected enum TechLevel{PreAgricultural, AGRICULTURAL, 
                           MEDIVAL, RENAISSANCE, 
                           EARLYINDUSTRY, INDUSTRIAL, 
                           POSTINDUSTRAIL, HIGHTECH};
    protected enum Resource{NO, MINERALRICH, MINERALPOOR,
                          DESERT, LOTSOFWATER, RICHSOIL,
                          POORSOIL, RICHFAUNA, LIFELESS,
                          WEIRDMUSHROOMS, LOTSOFHERBS,
                          ARTISTIC, WARLIKE};
    protected Resource resource;
    protected TechLevel techlevel;
    protected Random random = new Random();
    protected Color color;
    protected int size;
    
    public Planet(String name){
        this.name = name;
        generatePlanet();//Nico do this better
    }
    
    protected void generatePlanet(){
        resource = Resource.values()[random.nextInt(Resource.values().length)];
        techlevel = TechLevel.values()[random.nextInt(TechLevel.values().length)];
        size = random.nextInt(5) + 1;
        color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        orbitDistance = random.nextInt(30) + 20;//Distance between planet and star
        government = new Government();
    }
    
    public Color getColor(){
        return color;
    }
    
    public int getSize(){
        return size;
    }
    
    public String getName(){
        return name;
    }
    
    public int getOrbitDistance(){
        return orbitDistance;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder("Planet: ")
            .append(name)
            .append("\nResource: ")
            .append(resource)
            .append("\nUnder rule of ")
            .append(government);
        return str.toString();
    }
}
