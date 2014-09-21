package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;
import javafx.geometry.Point2D;

/**
 *
 * @author David Purcell
 */
public class StarSystem {
    private final String name;
    private Point2D coordinates;
    private Planet[] planets;
    private Random random = new Random();
    private String[] names = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public StarSystem(String name) {
        this.name = name;
        generateSystem();
    }

    // Nico will make better, this is just filler for now
    private void generateSystem() {
        coordinates = new Point2D(random.nextDouble() * 1300 + 50, random.nextDouble() * 600 + 50);//Range <-50.0, -50.0> - <50.0,50.0>
        planets = new Planet[random.nextInt(6) + 4];
        for (int i = 0; i < planets.length - 1; i++) {
            planets[i] = new Planet(names[i % 10]);
        }
    }

    public String getName(){
        return name;
    }

    public Planet[] getPlanets(){
        return planets;
    }

    public Planet destroyPlanet(int i) {
        Planet dead = null;
        if(i < planets.length) {
            dead = planets[i];
            planets[i] = null;
        }
        return dead;
    }

    public Point2D getCoordinates() {
        return coordinates;
    }

    public double getCoordinateX() {
        return coordinates.getX();
    }

    public double getCoordinateY() {
        return coordinates.getY();
    }

    public String toString() {
        StringBuilder str = new StringBuilder("System: ")
            .append(name)
            .append("\nStar System Coordinates:\n")
            .append(coordinates)
            .append("\nPlanets: \n");
        for(Planet planet : planets){
            str.append(planet)
                .append("\n");
        }
        return str.toString();
    }
}