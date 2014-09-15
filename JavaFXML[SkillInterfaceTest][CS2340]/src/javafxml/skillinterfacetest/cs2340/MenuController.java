package javafxml.skillinterfacetest.cs2340;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author TYN
 * @version 1.0
 */
public class MenuController implements Initializable, ControlledScreen {

    @FXML
    private ScreensController parentController;

    @FXML
    private void startButtonAction(ActionEvent event) {
        parentController.setScreen("SkillSetup");
    }

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