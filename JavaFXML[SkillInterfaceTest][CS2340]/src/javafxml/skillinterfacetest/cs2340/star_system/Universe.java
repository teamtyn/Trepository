/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import static javafx.event.EventType.ROOT;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Purcell7
 */
public class Universe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StarSystem[] systems = {new StarSystem("Sys 1"),new StarSystem("Sys 2"),new StarSystem("Sys 3"),
                                new StarSystem("Sys 4"),new StarSystem("Sys 5"),new StarSystem("Sys 6")};
        Group root = new Group();
        Scene scene = new Scene(root, 1400, 700, Color.BLACK);       
        
        viewUniverse(root, systems);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void viewUniverse(Group root, StarSystem[] systems){
        Random random = new Random();
        for(StarSystem sys : systems){
            Circle star = CircleBuilder.create()
                .centerX(sys.getCoordinateX())
                .centerY(sys.getCoordinateY())
                .radius(10)
                .fill(Color.YELLOW)
                .build();
            
            star.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent MouseEvent) -> {
                root.getChildren().removeAll(root.getChildren());
                viewSystem(root, sys, systems);
            });         
            root.getChildren().add(star);
            
            Text systemText = new Text(sys.getCoordinateX() - 30, sys.getCoordinateY() - 30, sys.getName());
            systemText.setFont(Font.font ("Verdana", 20));
            systemText.setFill(Color.WHITE);
            root.getChildren().add(systemText);
            
            int planets = sys.getPlanets().length;
            int degrees = 0;
            for(Planet planet : sys.getPlanets()){
                Circle planetCircle = CircleBuilder.create()
                .centerX(sys.getCoordinateX() + (planet.getOrbitDistance() * Math.cos(degrees * 0.0174532925)))
                .centerY(sys.getCoordinateY() + (planet.getOrbitDistance() * Math.sin(degrees * 0.0174532925)))
                .radius(planet.getSize())
                .fill(planet.getColor())
                .build();
                root.getChildren().add(planetCircle);
                degrees += 360 / planets;
            }
        }
    }
    
    public void viewSystem(Group root, StarSystem system, StarSystem[] systems){
        Random random = new Random();
        Text systemText = new Text(600, 50, system.getName());
        systemText.setFont(Font.font ("Verdana", 40));
        systemText.setFill(Color.WHITE);
        root.getChildren().add(systemText);
        Circle star = CircleBuilder.create()
            .centerX(600)
            .centerY(300)
            .radius(50)
            .fill(Color.YELLOW)
            .build();
        root.getChildren().add(star);
        Button button = new Button("GO BACK");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent MouseEvent) -> {
                root.getChildren().removeAll(root.getChildren());
                viewUniverse(root, systems);
            });
        root.getChildren().add(button);
        int planets = system.getPlanets().length;
        int degrees = 0;
        for(Planet planet : system.getPlanets()){
            Circle planetCircle = CircleBuilder.create()
            .centerX(star.getCenterX() + (5 * planet.getOrbitDistance() * Math.cos(degrees * 0.0174532925)))
            .centerY(star.getCenterY() + (5 * planet.getOrbitDistance() * Math.sin(degrees * 0.0174532925)))
            .radius(planet.getSize() * Math.sqrt(5))
            .fill(planet.getColor())
            .build();
            root.getChildren().add(planetCircle);
            Text planetText = new Text(planetCircle.getCenterX() - planet.getName().length() * 3, planetCircle.getCenterY() - 30, planet.getName());
            planetText.setFont(Font.font ("Verdana", 20));
            planetText.setFill(Color.WHITE);
            root.getChildren().add(planetText);
            degrees += 360 / planets;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}