package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ImageGenerator extends Application {

    public GridPane GetImageAsGridpane() {

        GridPane gridpane = new GridPane();
        Image image = new Image("File:TeamCFinalProject/src/main/Images/Sample-DeHo-Room");
        ImageView pic = new ImageView();
        pic.setFitWidth(130);
        pic.setFitHeight(130);
        pic.setImage(image);
        gridpane.add(pic, 400, 400);

        return gridpane;

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
