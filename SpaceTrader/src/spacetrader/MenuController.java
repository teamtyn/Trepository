/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Administrator
 */
public class MenuController implements Initializable, ControlledScreen {
    
    @FXML
    private ScreensController parentController;
    
    @FXML
    private void exitButtonAction(ActionEvent event) {
        System.exit(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController parentController) {
        this.parentController = parentController;
    }
}
