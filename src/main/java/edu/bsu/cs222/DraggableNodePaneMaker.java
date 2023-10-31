package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;


public class DraggableNodePaneMaker extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ImageGenerator generator = new ImageGenerator();

        Node chair = new Circle(30, 30, 30, Color.BLUE);
        Node bed = new Rectangle(135, 215, Color.RED);
        Node desk = new Rectangle(65, 185, Color.GREEN);
        Node drawers = new Rectangle(65, 185, Color.YELLOW);
        Node fridge = new Rectangle(35, 35, Color.CYAN);
        Label control = new Label("Fishtank");
        control.setFont(Font.font(34));

        Node[] nodeArray = new Node[]{chair, desk, chair, drawers, fridge, bed};

        BorderPane borderPane = new BorderPane();
        HBox hBox = addHBox();
        VBox vBox = addVBox();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);

        Group imageGroup = generator.GetImageAsGroup();
        var root = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
        borderPane.setRight(root);

        borderPane.setCenter(createDraggableApp(nodeArray));

        stage.setScene(new Scene(borderPane));
        stage.show();

    }

    public Pane createPane(int x, int y, Node[] content){
        Pane pane = new Pane(content);
        pane.setPrefSize(x, y);
        return pane;
    }
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #b51212;");

        Text title = new Text("Ball State University: Residence Halls");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 27));
        title.setFill(Color.WHITESMOKE);

        hbox.getChildren().add(title);

        return hbox;
    }

    public VBox addVBox() {
        InteractiveFeatures features = new InteractiveFeatures();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Dorm Selection");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().addAll(title, features.createButtons());

        return vbox;
    }

    public Parent createDraggableApp(Node[] nodeArray) {

        for(int i = 0; i<nodeArray.length; i++){
            if(nodeArray[i] != null) {
                nodeArray[i].setTranslateX(i * 75);
                nodeArray[i].setTranslateY(50);
            }
        }

        var root = createPane(800, 600, nodeArray);

        root.getChildren().forEach(this::makeDraggable);

        return root;
    }

    private double startPointX;
    private double startPointY;

    private void makeDraggable(Node node){
        node.setOnMousePressed(obj -> {
            startPointX = obj.getSceneX() - node.getTranslateX();
            startPointY = obj.getSceneY() - node.getTranslateY();

            node.setCursor(Cursor.CLOSED_HAND);
        });

        node.setOnMouseDragged(obj -> {
            node.setTranslateX(obj.getSceneX() - startPointX);
            node.setTranslateY(obj.getSceneY() - startPointY);
        });

    }


}
