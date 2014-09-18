/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Purcell7
 */
public class Universe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StarSystem[] systems = {new StarSystem("Sys 1"),new StarSystem("Sys 2"),new StarSystem("Sys 3"),new StarSystem("Sys 4")};
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        Random random = new Random();
        
        for(StarSystem sys : systems){
            Circle star = CircleBuilder.create()
                .centerX(sys.getCoordinateX())
                .centerY(sys.getCoordinateY())
                .radius(10)
                .fill(Color.YELLOW)
                .build();
            root.getChildren().add(star);
            
            Text systemLabel = new Text(sys.getCoordinateX() - 15, sys.getCoordinateY() - 15, sys.getName());
            systemLabel.setFill(Color.WHITE);
            for(Planet planet : sys.getPlanets()){
                int degrees = random.nextInt(360);
                Circle planetCircle = CircleBuilder.create()
                .centerX(sys.getCoordinateX() + (planet.getOrbitDistance() * Math.cos(degrees * 0.0174532925)))
                .centerY(sys.getCoordinateY() + (planet.getOrbitDistance() * Math.sin(degrees * 0.0174532925)))
                .radius(planet.getSize())
                .fill(planet.getColor())
                .build();
                root.getChildren().add(planetCircle);
                if(planet instanceof Shipyard){
                    Text shipyardLabel = new Text(planetCircle.getCenterX() - 25, planetCircle.getCenterY() - 5, "Shipyard");
                    shipyardLabel.setFill(Color.WHITE);
                    root.getChildren().add(shipyardLabel);
                }
            }
            root.getChildren().add(systemLabel);
            System.out.println(sys);
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
