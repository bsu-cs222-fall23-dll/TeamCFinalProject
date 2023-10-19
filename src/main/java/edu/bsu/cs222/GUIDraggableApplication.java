package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Group;


public class GUIDraggableApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ImageGenerator generator = new ImageGenerator();
        InteractiveFeatures feature = new InteractiveFeatures();

        Node circle = new Circle(15, 15, 15, Color.BLUE);
        Node rect = new Rectangle(45, 85, Color.RED);
        Label control = new Label("Fishtank");
        control.setFont(Font.font(34));

        Node[] nodeArray = new Node[]{ circle, rect, circle, control};

        BorderPane borderPane = new BorderPane();
        HBox hBox = feature.addHBox();
        VBox vBox = feature.addVBox();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);
        borderPane.setCenter(createDraggableApp(nodeArray));
//        borderPane.setRight();

        stage.setScene(new Scene(borderPane));
        stage.show();

    }

    public Pane createPane(int x, int y, Node[] content){
        Pane pane = new Pane(content);
        pane.setPrefSize(x, y);
        return pane;
    }

    public Parent createDraggableApp(Node[] nodeArray) throws Exception {

        for(int i = 0; i<nodeArray.length; i++){
            if(nodeArray[i] != null)
                nodeArray[i].setTranslateX(i * 75);
            nodeArray[i].setTranslateY(50);
        }

        ImageGenerator generator = new ImageGenerator();
        Group imageGroup = generator.GetImageAsGroup();

        nodeArray[0] = imageGroup;

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
