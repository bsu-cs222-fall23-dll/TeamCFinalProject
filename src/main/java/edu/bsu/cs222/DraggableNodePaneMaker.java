package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class DraggableNodePaneMaker extends Application {
    public BorderPane borderPane = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        HBox hBox = addHBox();
        VBox vBox = addVBox();
        VBox vBoxCustomFurniture = addVBoxFurniture();
        GridPane gridPaneCenter = gridPaneCenterFeatures();
        borderPane.setTop(hBox);
       // borderPane.setLeft(vBox);
        borderPane.setRight(vBoxCustomFurniture);
        borderPane.setCenter(gridPaneCenter);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setWidth(1200);
        primaryStage.setHeight(850);
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

        return new Node[]{nodeMaker.makeImageNode("Bed.png"), nodeMaker.makeImageNode("Chair.png"),
                nodeMaker.makeImageNode("Desk.png"), nodeMaker.makeImageNode("Drawer.png"), nodeMaker.makeImageNode("TrashCan.png")};

    }

    public VBox addVBox() throws FileNotFoundException {
        InteractiveFeatures features = new InteractiveFeatures();
        UserCreatingFurniture furniture = new UserCreatingFurniture();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #DAE6F3;");

        Button button1 = new Button("Dehority");

        button1.setOnAction(e -> {
            try {
                Pane image = features.getDormImage(button1.getText());
                borderPane.setRight(image);

                //displays ALL furniture nodes
                borderPane.setCenter(createDraggableApp(getFurnitureNodes()));

                borderPane.setBottom(dormDataTilePane(button1.getText()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Text title = new Text("Dorm Selection");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));

    //    GridPane gridPane = gridPaneCenterFeatures();

        vbox.getChildren().addAll(title); //button1, gridPane

        return vbox;
    }

    public GridPane gridPaneCenterFeatures() {
        InteractiveFeatures features = new InteractiveFeatures();
        UserCreatingFurniture furniture = new UserCreatingFurniture();
        GridPane gridPane = new GridPane();
        Group root = new Group();
        Group root2 = new Group();

        root.getChildren().add(features.getDormRoom());
        root2.getChildren().add(features.getFurniture());

      //  BorderPane.setAlignment(root, Pos.TOP_LEFT);
      //  BorderPane.setMargin(root, new Insets(12,12,12,12));
        borderPane.setRight(root);

       // BorderPane.setAlignment(root2, Pos.BOTTOM_LEFT);
       // BorderPane.setMargin(root2, new Insets(12,12,12,12));
        borderPane.setCenter(root2);

        gridPane.add(root, 0, 0);
        gridPane.add(root2, 1, 0);

        return gridPane;
    }

    public VBox addVBoxFurniture() {
        InteractiveFeatures features = new InteractiveFeatures();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: DAE6F3;");

        Group root = new Group();
        Group root2 = new Group();

        root.getChildren().add(features.getCustomFurniture());
        root2.getChildren().add(features.getFurniture());

        Text title = new Text("Add Custom\nFurniture");
        Text title2 = new Text("Add Provided\nFurniture");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        vbox.getChildren().addAll(title, root, title2, root2);

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
