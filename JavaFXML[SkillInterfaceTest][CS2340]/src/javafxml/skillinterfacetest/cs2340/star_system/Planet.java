/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;

/**
 *
 * @author Purcell7
 */
public class Planet {
    private String name;
    private int orbitDistance;//Good way to layout system?
    private Government government;//Object or Enum?
    private enum TechLevel{PreAgricultural, AGRICULTURAL, 
                           MEDIVAL, RENAISSANCE, 
                           EARLYINDUSTRY, INDUSTRIAL, 
                           POSTINDUSTRAIL, HIGHTECH};
    private enum Resource{NO, MINERALRICH, MINERALPOOR,
                          DESERT, LOTSOFWATER, RICHSOIL,
                          POORSOIL, RICHFAUNA, LIFELESS,
                          WEIRDMUSHROOMS, LOTSOFHERBS,
                          ARTISTIC, WARLIKE};
    private Resource resource;
    private TechLevel techlevel;
    private Random random = new Random();
    
    public Planet(String name){
        this.name = name;
        generatePlanet();//Nico do this better
    }
    
    private void generatePlanet(){
        resource = Resource.NO;
        techlevel = TechLevel.HIGHTECH;
        orbitDistance = random.nextInt(Integer.MAX_VALUE);//Distance between planet and star
        government = new Government();
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder("Planet: " + this.name + "\n")
            .append("Resource: ")
            .append(resource)
            .append("Under rule of ")
            .append(government);
        return str.toString();
    }
}
