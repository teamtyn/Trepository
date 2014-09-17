/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml.skillinterfacetest.cs2340.star_system;

/**
 *
 * @author Purcell7
 */
public class Universe {
    public static void main(String[] args){
        StarSystem[] starSystems = {new StarSystem("1"), new StarSystem("2"), new StarSystem("3")};
        for(StarSystem sys : starSystems){
            System.out.println(sys);
        }
    }
}
