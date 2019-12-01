/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedFish;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Aquarium extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Move up");
        FishGUI fish = new FishGUI(200, 300);
        
        
        Pane root = new Pane();
        root.getChildren().addAll(btn, fish.getBody(), fish.getTail());
        
        Scene scene = new Scene(root, 750, 500);
        
        primaryStage.setTitle("Aquarium");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //event handlers
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fish.moveRight();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
