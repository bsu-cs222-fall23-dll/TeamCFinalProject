package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GUIDraggableApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ImageGenerator generator = new ImageGenerator();

        Node circle = new Circle(25, 25, 25, Color.BLUE);
        Node rect = new Rectangle(150, 30, Color.RED);
        Label control = new Label("Drag Me");
        control.setFont(Font.font(42));

        Node[] nodeArray = new Node[]{ circle, rect, control};


        GridPane testGridPane = generator.GetImageAsGridpane();

        Node[] nullNodeArray = new Node[]{testGridPane};

        stage.setScene(new Scene(testGridPane));
        stage.show();

        //stage.setScene(new Scene(createDraggableApp(nodeArray)));
        //stage.show();
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
