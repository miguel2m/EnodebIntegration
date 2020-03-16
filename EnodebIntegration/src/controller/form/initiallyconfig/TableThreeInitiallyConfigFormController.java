/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.initiallyconfig;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableThreeInitiallyConfigFormController extends BaseController implements Initializable {
    private TableView tableInitConfigThree;
    private boolean isUpdate;
    public TableThreeInitiallyConfigFormController(ViewFactory viewFactory, String fxmlName,
            TableView tableInitConfigThree,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableInitConfigThree=tableInitConfigThree;
        this.isUpdate=isUpdate;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
