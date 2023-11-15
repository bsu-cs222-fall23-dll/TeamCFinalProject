package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class DraggableNodePaneMaker extends Application {
    public BorderPane borderPane = new BorderPane();
    public Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Node chair = new Circle(30, 30, 30, Color.BLUE);
        Node bed = new Rectangle(135, 215, Color.RED);
        Node desk = new Rectangle(100, 95, Color.GREEN);
        Node drawers = new Rectangle(100, 95, Color.YELLOW);
        Node fridge = new Rectangle(65, 65, Color.DARKCYAN);
        Node trashcan = new Rectangle(55,30, Color.SANDYBROWN);
        Label control = new Label("Fishtank");
        control.setFont(Font.font(34));

        Node[] nodeArray = new Node[]{chair, desk, drawers, fridge, bed, trashcan};

        HBox hBox = addHBox();
        VBox vBox = addVBox();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);

//        Pane imageGroup = features.getDormImage("Dehority");
//        var root = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));//
//        borderPane.setRight(imageGroup);

//        borderPane.setCenter(createDraggableApp(nodeArray));

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

    public Node[] getFurnitureNodes() {

        Node chair = new Circle(30, 30, 30, Color.BLUE);
        Node bed = new Rectangle(135, 215, Color.RED);
        Node desk = new Rectangle(100, 95, Color.GREEN);
        Node drawers = new Rectangle(100, 95, Color.YELLOW);
        Node fridge = new Rectangle(65, 65, Color.DARKCYAN);
        Node trashcan = new Rectangle(55,30, Color.SANDYBROWN);
        Label control = new Label("Fishtank");
        control.setFont(Font.font(34));

        Node[] nodeArray = new Node[]{chair, desk, drawers, fridge, bed, trashcan};
        return nodeArray;
    }

    public VBox addVBox() throws FileNotFoundException {
        InteractiveFeatures features = new InteractiveFeatures();
        features.initBtnsArray();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button[] buttons = new Button[11];
        String[] dormNames = {"Dehority",
                "Park", "North", "Botsford/Swinford", "Kinghorn",
                "North West", "Noyer", "Schmidt/Wilson", "Studebaker East",
                "Studebaker West", "Woodworth"};





        //add into vbox .getChildren borderPane
//        int i = 0;
//        Button btns = null;

//            int finalJ = j;
//            btns = buttons[i];
//            btns.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent e) {
//                    try {
//                        Pane image = features.getDormImage(dormNames[finalJ]);
//                        borderPane.setRight(image);
//                    } catch (FileNotFoundException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//            });
//            i++;
//        }

        Button button1 = new Button("Dehority");
        Button button2 = new Button("Park");
        Button button3 = new Button("Beyerl");
        Button button4 = new Button("BotsfordSwinford");
        Button button5 = new Button("Kinghorn");
        Button button6 = new Button("North West");
        Button button7 = new Button("Noyer");
        Button button8 = new Button("SchmidtWilson");
        Button button9 = new Button("Studebaker East");
        Button button10 = new Button("Studebaker West");
        Button button11 = new Button("Woodworth");
        button1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    try {
                        Pane image = features.getDormImage(button1.getText());
                        borderPane.setRight(image);
                        borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button2.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button3.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button4.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button5.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button6.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button7.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button8.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button9.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button10.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane image = features.getDormImage(button11.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
//            buttons[i] = button1;
//            i++;
//        }

        Text title = new Text("Dorm Selection");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().addAll(title, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11); //features.getButtonGrid()


        return vbox;
    }

    public Pane getDormImage(String dormName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();
//        DraggableNodePaneMaker draggable = new DraggableNodePaneMaker();
        InteractiveFeatures features = new InteractiveFeatures();

        Group imageGroup;
        Pane imageGroupPane = null;
        for(Button b : features.buttons) {
            if(b.getText() == dormName) {
                imageGroup = generator.GetImageAsGroup(dormName);
                imageGroupPane = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
                borderPane.setRight(imageGroupPane);
                break;
            }
//            else {
//                imageGroup = generator.GetImageAsGroup("ImageNotFound");
//                imageGroupPane = draggable.createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
//                draggable.borderPane.setRight(imageGroupPane);
//            }
        }
        return imageGroupPane;
    }

//    public void initBtnsArray() {
////        DraggableNodePaneMaker draggable = new DraggableNodePaneMaker()
//        InteractiveFeatures features = new InteractiveFeatures();
//
//        int i = 0;
//        for(int j = 0; j < features.buttons.length; j++) {
//            Button button = new Button(features.dormNames[j]);
//            button.setOnAction(new EventHandler<ActionEvent>() {
//                @Override public void handle(ActionEvent e) {
//                    try {
//                        System.out.println(e.toString());
//                        Pane image = features.getDormImage(button.getText());
//                        borderPane.setRight(image); // doesn't work b/c borderpane is empty and not in start
//
////                        Button o = (Button) e.getTarget();
////                        String name = o.getName();
////                        getDormImage(String.valueOf(o));
////                        draggable.borderPane.setCenter(draggable.createDraggableApp(nodeArray));
////                        draggable.stage.setScene(new Scene(draggable.borderPane));
////                        draggable.stage.show();
//
//                    } catch (FileNotFoundException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//            });
//            features.buttons[i] = button;
//            i++;
//        }
//    }

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
