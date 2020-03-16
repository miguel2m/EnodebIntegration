/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BaseController;
import controller.InitiallyConfigController;
import controller.MainViewController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
/**
 *
 * @author P05144
 */
public class ViewFactory {
    final Hyperlink link = new Hyperlink("https://github.com/miguel2m/GouScriptView");
    
    public void showMainWindow(String fxmlName){
        BaseController _baseController = new MainViewController(this,fxmlName);
        startStage(_baseController);
    }
    
    
    public void startStage(BaseController _baseController){
        FXMLLoader fxmll = new FXMLLoader(getClass().getResource(_baseController.getFxmlName()));
        fxmll.setController(_baseController);
        Parent parent = null;
        try{
            parent = fxmll.load();
        }catch(IOException io){
            io.printStackTrace();
        } 
        
        Scene scene = new Scene(parent);
        Stage  stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("eNodeB - Integration");
        stage.getIcons().add(new Image(ViewFactory.class.getResourceAsStream("assets/antenna.png")));
        stage.show();
    }
    
    public void addStageCenterBorderPanel(BorderPane _borderPane, BaseController _baseController){
        FXMLLoader fxmll = new FXMLLoader(getClass().getResource(_baseController.getFxmlName()));
        fxmll.setController(_baseController);
        Parent parent = null;
        try{
            parent = fxmll.load();
        }catch(IOException io){
            io.printStackTrace();
        }
        _borderPane.setCenter(parent);
    }
    
    
    public void showModalStage(Stage stageParent,BaseController _baseController,String _title){
        FXMLLoader fxmll = new FXMLLoader(getClass().getResource(_baseController.getFxmlName()));
        fxmll.setController(_baseController);
        Parent parent = null;
        try{
            parent = fxmll.load();
        }catch(IOException io){
            io.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        //stage.
        //stage.show();
        stage.setTitle(_title);
        stage.initOwner(stageParent);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.getIcons().add(new Image(ViewFactory.class.getResourceAsStream("assets/antenna.png")));
        stage.showAndWait();
    }
    
    public void showAlertValidation(Stage stageParent,String title,String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR,
                    msg);
            alert.initOwner(stageParent);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle(title);
            alert.showAndWait();
    }
    
    
    public void showHelpMainWindow(Stage stageParent){
        FlowPane fp = new FlowPane();
        Label lbl = new Label("Toda la ayuda la encontrarás aquí: ");
        
        fp.getChildren().addAll(lbl, link);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Info");
                alert.initOwner(stageParent);
                alert.setTitle("Info");
                alert.getDialogPane().setContent(fp);
                alert.getDialogPane().setHeaderText("Información");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.showAndWait();
    }
    
    public void closeStage(Stage closeStage){
        closeStage.close();
    }
}
