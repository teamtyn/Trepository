/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml.skillinterfacetest.cs2340.star_system;

import javafx.scene.paint.Color;

/**
 *
 * @author Purcell7
 */
public class Shipyard extends Planet{
    public Shipyard(String name){
        super(name);
        this.color = Color.GREY;
        this.size = 3;
    }
    
    public String toString(){
        return super.toString() + "\nALSO A SHIPYARD";
    }
}
