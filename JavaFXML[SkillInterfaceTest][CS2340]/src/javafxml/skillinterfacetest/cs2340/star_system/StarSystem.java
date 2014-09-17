package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;
import javafx.geometry.Point2D;

/**
 *
 * @author David Purcell
 */
public class StarSystem {
    private String name;
    private Point2D coordinates;
    private Planet[] planets;
    private Random random = new Random();
    
    public StarSystem(String name){
        this.name = name;
        generateSystem();
    }
    
    private void generateSystem(){
        //Nico make better, this is just filler for now
        planets = new Planet[random.nextInt(10) + 1];
        for(int i=0; i<planets.length - 1; i++){
            planets[i] = new Planet("Names are hard");
        }
        planets[planets.length - 1] = new Shipyard("Ships to the yard");//Do all systems have?
    }
    
    public Planet[] getPlanets(){
        return planets;
    }
    
    public Planet destroyPlanet(int i){
        Planet dead = null;
        if(i < planets.length){
            dead = planets[i];
            planets[i] = null;
        }
        return dead;
    }
    
    public Point2D getCoordinates(){
        return coordinates;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder("System: ")
            .append(name)
            .append("\n")
            .append("Star System Coordinates:\n")
            .append(coordinates)
            .append("Planets: \n");
        for(Planet planet : planets){
            str.append(planet)
                .append("\n");
        }
        return str.toString();
    }
}
