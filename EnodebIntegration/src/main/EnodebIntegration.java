/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewFactory;

/**
 *
 * @author P05144
 */
public class EnodebIntegration extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory _viewFactory = new ViewFactory();
        _viewFactory.showMainWindow("MainView.fxml");
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
