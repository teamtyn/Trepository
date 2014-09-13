/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxml.skillinterfacetest.cs2340;
import javafxml.skillinterfacetest.cs2340.player.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Node;


/**
 * FXML Controller class
 *
 * @author Local Clayton
 */
public class SkillSetupController implements Initializable, ControlledScreen {

    @FXML
    private HBox container;

    @FXML
    private Button minus0;

    @FXML
    private Button plus3;

    @FXML
    private Button plus2;

    @FXML
    private Button plus4;

    @FXML
    private Label topLabel;

    @FXML
    private Button plus1;

    @FXML
    private Label points0;

    @FXML
    private ProgressBar bar1;

    @FXML
    private Label skill3;

    @FXML
    private Label skill4;

    @FXML
    private ProgressBar bar2;

    @FXML
    private ProgressBar bar0;

    @FXML
    private Label skill1;

    @FXML
    private Label skill2;

    @FXML
    private Label skill0;

    @FXML
    private Label points4;

    @FXML
    private Button plus0;

    @FXML
    private ProgressBar bar3;

    @FXML
    private Button doneButton;

    @FXML
    private ProgressBar bar4;

    @FXML
    private Label points3;

    @FXML
    private VBox labels;

    @FXML
    private Label points2;

    @FXML
    private Label points1;

    @FXML
    private HBox container1;

    @FXML
    private Button minus3;

    @FXML
    private HBox container2;

    @FXML
    private Button minus2;

    @FXML
    private Button minus1;

    @FXML
    private HBox container3;

    @FXML
    private Label comment;

    @FXML
    private HBox container4;

    @FXML
    private VBox barBox;

    @FXML
    private Button minus4;
    
    @FXML
    private Label totalLabel;
    
    @FXML
    private ProgressBar totalBar;
    
    
    //Non FXML - related members
        Map<String, Integer> buttonMap = new HashMap<String, Integer>(5);
        Map<String, Integer> minusButtonMap = new HashMap<String, Integer>(5);
        
        Player player = new Player();
        Label[] labelArray = new Label[0];
        Label[] pointLabelArray;
        Button[] minusButtonArray;
        Button[] plusButtonArray;
        ProgressBar[] bars;
        int[] skillPointArray;
        int avgValue = 10;
        int barMax = 30;
        int maxPts = 75;
        int totalPts = 50;
        private ScreensController parentController;
        
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        plusButtonArray = new Button[] {plus0, plus1, plus2, plus3, plus4};
        minusButtonArray = new Button[] {minus0, minus1, minus2, minus3, minus4};
        pointLabelArray = new Label[] {points0, points1, points2, points3, points4};
        bars = new ProgressBar[] {bar0, bar1, bar2, bar3, bar4};
        //Setting up Player and Skills
        setUp();
            

        //the doneButton's OnAction
        doneButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                updatePlayerSkills();
                String closingMessage;
                closingMessage = "~~~PLAYER INFORMATION~~~\nNAME: " + 
                        player.getName() + "\nSKILLS: \n";
                for(Skill skill : player.getSkills()) {
                 closingMessage = closingMessage + skill.getType() + " - " + skill.getValue() + "\n";
                }
                System.out.println("This is the end of our game. Look out for the sequel: '" + player.getName() + " Clicks Buttons II: Even More Buttons!'");
                System.out.println(closingMessage);
                System.exit(1);
            }
        });
    }
    
    private void updatePlayerSkills() {
       System.out.println(player.getSkills().size());
        for (int i = 0; i < player.getSkills().size(); i++) {
           player.getSkills().get(i).setValue(skillPointArray[i]);

       } 
    }
    
    @Override
    public void setScreenParent(ScreensController parentController) {
        this.parentController = parentController;
    }
    /**
     *
     */
    public void setUp() {
        createSkillListAndPlayer();
        setUpControls();
    }
    
        @FXML
    private void plusButtonAction(ActionEvent event) {
        Node n = (Node) event.getSource();
        //System.out.println(minusButtonMap.get(n.getId()));
        addToSkill(buttonMap.get(n.getId()));
    }
    
    private void addToSkill(int index) {
        int skillPoints = skillPointArray[index];
        if((skillPoints < barMax) &&(totalPts < maxPts)) {
            skillPoints++;
            totalPts++;
    }
        skillPointArray[index] = skillPoints;

        updateProgressBar(index, skillPoints);
        updatePointLabel(index, skillPoints);

    }
    
    @FXML
    private void minusButtonAction(ActionEvent event) {
        Node n = (Node) event.getSource();
        //System.out.println(minusButtonMap.get(n.getId()));
        subtractFromSkill(minusButtonMap.get(n.getId()));
    }
    
    private void subtractFromSkill(int index) {
        int skillPoints = skillPointArray[index];
        if(skillPoints > 0) {
            skillPoints--;
            totalPts--;
        }
        
        skillPointArray[index] = skillPoints;
        updateProgressBar(index, skillPoints);
        updatePointLabel(index, skillPoints);
    }
    
    private void updatePointLabel(int index, int points) {
        pointLabelArray[index].setText("" + points);
    }
    
    private void updateProgressBar(int index, int points) {
        bars[index].setProgress((float)points/(float)barMax);
        updateTotalDisplays();
    }
    
    private void updateTotalDisplays() {
        totalBar.setProgress((float) (maxPts - totalPts)/(float)maxPts);
        totalLabel.setText("" + (maxPts - totalPts));
    
    }
    
    /**
     *
     */
    public void createSkillListAndPlayer() {
            //skills
            Skill intelligence = new Skill("Intelligence");
            Skill looks = new Skill("Looks");
            Skill bloodPressure = new Skill("Blood Pressure");
            Skill intuition = new Skill ("Intuition");
            Skill luck = new Skill("Luck");
            List<Skill> skills = new ArrayList<>(asList(intelligence, looks, intuition, bloodPressure, luck));
            createPlayer(skills);
    }
    
    /**
     *Creates a Player, for testing out this interface
     * @param newSkills
     * @see Player
     */
    public void createPlayer(List<Skill> newSkills) {
        //create the player and set the skills
            player.setName("Joe");
            player.setSkillList(newSkills); 
    }
    
    /**
     * This method:
     *      sets labelArray to an array of label next to the sliders. It
     *          sets their text values to be skill names that correspond with the
     *          slider numbers.
     *      sets the points displayed on the right of the sliders
     *      instantiates an array of ints that will hold the points for each skill
     */
    public void setUpControls() {
        labelArray = new Label[] {skill0, skill1, skill2, skill3, skill4};
        for(int i = 0; i < labelArray.length; i++) {
            labelArray[i].setText(player.getSkills().get(i).getType());
        }
        
        


//        for (int i = 0; i < sliders.getChildren().size() - 1; i++) {
//            HBox hbox = (HBox) sliders.getChildren().get(i);
//            Slider slider = (Slider)hbox.getChildren().get(1);
//            int val = (int)slider.getValue();
//            Label points = (Label) hbox.getChildren().get(2);
//            points.setText("" + val);
//            
//        }
        //set up the array of point values
        skillPointArray = new int[player.getSkills().size()];
        for(int i = 0; i < skillPointArray.length; i++) {
            skillPointArray[i] = avgValue;
            
        }
        
        for(int i = 0; i < plusButtonArray.length; i++) {
            buttonMap.put(plusButtonArray[i].getId(), i);
            minusButtonMap.put(minusButtonArray[i].getId(), i);
            updateProgressBar(i, avgValue);
            updatePointLabel(i, avgValue);
        }

        
    }
    
    
}
