package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ImageGenerator extends Application {
    @Override
    public void start(Stage stage) throws Exception {



        Node[] nullNodeArray = new Node[]{};


        stage.setScene(new Scene(createPane(40, 800, nullNodeArray)));
        stage.show();
    }

    public Pane createPane(int x, int y, Node[] content){
        Pane pane = new Pane(content);
        pane.setPrefSize(x, y);
        return pane;
    }


    public Parent createDraggableApp(Node[] nodeArray) {

        for(int i = 0; i<nodeArray.length; i++){
            if(nodeArray[i] != null)
                nodeArray[i].setTranslateX(i * 75);
                nodeArray[i].setTranslateY(50);
        }
        var root = createPane(800, 600, nodeArray);

        root.getChildren().forEach(this::makeDraggable);

        return root;
    }

    private double startX;
    private double startY;

    private void makeDraggable(Node node){
        node.setOnMousePressed(obj -> {
            startX = obj.getSceneX() - node.getTranslateX();
            startY = obj.getSceneY() - node.getTranslateY();

            node.setCursor(Cursor.CLOSED_HAND);
        });

        node.setOnMouseDragged(obj -> {
            node.setTranslateX(obj.getSceneX() - startX);
            node.setTranslateY(obj.getSceneY() - startY);
        });

    }



}
