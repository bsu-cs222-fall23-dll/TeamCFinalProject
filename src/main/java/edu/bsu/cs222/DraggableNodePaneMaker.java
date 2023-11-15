package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class DraggableNodePaneMaker extends Application {
    public BorderPane borderPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) {

        HBox hBox = addHBox();
        VBox vBox = addVBox();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();

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

    public Node[] getFurnitureNodes() throws FileNotFoundException {
        NodeMaker nodeMaker = new NodeMaker();

        return new Node[]{nodeMaker.makeImageNode("Bed.jpg"), nodeMaker.makeImageNode("Chair.png"),
                nodeMaker.makeImageNode("Desk.png"), nodeMaker.makeImageNode("Drawers.png"), nodeMaker.makeImageNode("TrashCan.png")};

    }

    public VBox addVBox() {
        InteractiveFeatures features = new InteractiveFeatures();
        features.initBtnsArray();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: DAE6F3;");


        Button button1 = new Button("Dehority");
        Button button2 = new Button("Park");
        Button button3 = new Button("Beyerl");
        Button button4 = new Button("Botsford-Swinford");
        Button button5 = new Button("Kinghorn");
        Button button6 = new Button("North West");
        Button button7 = new Button("Noyer");
        Button button8 = new Button("Schmidt-Wilson");
        Button button9 = new Button("Studebaker East");
        Button button10 = new Button("Studebaker West");
        Button button11 = new Button("Woodworth");
        button1.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button1.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button1.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button2.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button2.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button2.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button3.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button3.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button3.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button4.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button4.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button4.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button5.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button5.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button5.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button6.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button6.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button6.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button7.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button7.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button7.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button8.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button8.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button8.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button9.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button9.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button9.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button10.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button10.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button10.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        button11.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button11.getText());
                borderPane.setRight(image);
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                borderPane.setBottom(dormDataTilePane(button11.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Text title = new Text("Dorm Selection");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().addAll(title, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11);

        return vbox;
    }

    public TilePane dormDataTilePane(String buttonName) {
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(5, 0, 5, 0));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(2);
        tile.setStyle("-fx-background-color: DAE6F3;");

        HBox hbox2 = addHBox2(buttonName);
        HBox hbox3 = addHBox3(buttonName);
        HBox hbox4 = addHBox4();

        tile.getChildren().addAll(hbox2, hbox3, hbox4);
        return tile;
    }

    public HBox addHBox4() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(8);

        Text title = new Text("Pet Friendly: ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Label label = new Label("Yes");
        hbox.getChildren().addAll(title, label);

        return hbox;
    }

    public HBox addHBox3(String buttonName) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(8);

        Text title = new Text("Food Courts Nearby: ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        String dormData = dormRoomInfo(buttonName);
        Label label = new Label(dormData);
        hbox.getChildren().addAll(title, label);

        return hbox;
    }

    public HBox addHBox2(String dormName) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(8);

        Text title = new Text("Dorm Key: ");
        Label label;
        String key = null;
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        switch (dormName) {
            case "Dehority", "Noyer", "Studebaker West", "Woodworth" -> key = """
                    Chair(s): 2
                    Bed(s): 2
                    Trashcan(s): 2
                    Desk(s): 2
                    Dresser(s): 2
                    Wardrobe(s): 2
                    Closet(s): 0
                    """;
            case "Beyerl", "Schmidt-Wilson", "North West", "Botsford-Swinford" -> key = """
                    Chair(s): 2
                    Bed(s): 2
                    Trashcan(s): 2
                    Desk(s): 2
                    Dresser(s): 2
                    Wardrobe(s): 0
                    Closet(s): 2
                    """;
            case "Park", "Studebaker East", "Kinghorn" -> key = """
                    Chair(s): 2
                    Bed(s): 2
                    Trashcan(s): 2
                    Desk(s): 2
                    Dresser(s): 2
                    Wardrobe(s): 0
                    Closet(s): 1
                    """;
        }

        label = new Label(key);
        hbox.getChildren().addAll(title, label);
        return hbox;
    }

    public String dormRoomInfo(String buttonName) {
        return switch (buttonName) {
            case "Dehority", "Woodworth", "Noyer", "Park", "Kinghorn" -> "- Woodworth Commons\n- Noyer Market";
            case "Beyerl", "Schmidt-Wilson", "North West", "Botsford-Swinford" -> "- North Dining Hall\n";
            case "Studebaker East", "Studebaker West" -> "- Woodworth Commons\n- Tom John Food Shop\n- Micro Cafe";
            default -> "";
        };
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
