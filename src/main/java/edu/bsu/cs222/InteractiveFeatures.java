package edu.bsu.cs222;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import javafx.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;


public class InteractiveFeatures extends DraggableNodePaneMaker {
    public Button[] buttons = new Button[11];
    public String[] dormNames = {"Dehority",
    "Park", "North", "Botsford/Swinford", "Kinghorn",
    "North West", "Noyer", "Schmidt/Wilson", "Studebaker East",
    "Studebaker West", "Woodworth"};

    public Pane getButtonGrid() throws FileNotFoundException {
        int i = 0;
        GridPane gridPane = new GridPane();
        for(Button b : buttons) {
            gridPane.add(b, 0, i*(i+(int)b.getWidth()));
//            buttonClicked(b.getText());
//            b.setOnAction(e -> {
//                try {
//                    String bName = b.getText();
//                    buttonClicked(bName);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//                break;
//            });
            i++;
        }
        return gridPane;
    }

    public void initBtnsArray() {
        DraggableNodePaneMaker draggable = new DraggableNodePaneMaker();

        int i = 0;
        for(int j = 0; j < buttons.length; j++) {
            Button button = new Button(dormNames[j]);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    try {
                        System.out.println(e.toString());
                        Pane image = draggable.getDormImage(button.getText());
//                        draggable.borderPane.setRight(image); // doesn't work b/c borderpane is empty and not in start

//                        Button o = (Button) e.getTarget();
//                        String name = o.getName();
//                        getDormImage(String.valueOf(o));
//                        draggable.borderPane.setCenter(draggable.createDraggableApp(nodeArray));
//                        draggable.stage.setScene(new Scene(draggable.borderPane));
//                        draggable.stage.show();

                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            buttons[i] = button;
            i++;
        }
    }

    public Button dehorityButton() {
        Button button = new Button("Dehority");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Pane dehority = getDormImage(button.getText());
                    borderPane.setRight(dehority); // works because borderPane is full variable and in start
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return button;
    }

//    public Pane getBorderPane(){
//        DraggableNodePaneMaker draggable = new DraggableNodePaneMaker();
//
//        BorderPane borderPane = new BorderPane();
//        HBox hBox = draggable.addHBox();
//        VBox vBox = draggable.addVBox();
//        borderPane.setTop(hBox);
//        borderPane.setLeft(vBox);
//
//        return borderPane;
//    }

    public Node[] getFurniture() {
        Node circle = new Circle(15, 15, 15, Color.BLUE);
        Node rect = new Rectangle(45, 85, Color.RED);
        Label control = new Label("Fishtank");
        control.setFont(Font.font(34));
        Node[] nodeArray = new Node[]{ rect, circle, control};

        return nodeArray;
    }
    public Pane getDormImage(String dormName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();
        DraggableNodePaneMaker draggable = new DraggableNodePaneMaker();

        Group imageGroup;
        Pane imageGroupPane = null;
        for(Button b : buttons) {
            if(b.getText() == dormName) {
                imageGroup = generator.GetImageAsGroup(dormName);
                imageGroupPane = draggable.createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
//                draggable.borderPane.setRight(imageGroupPane);
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

//    public Group buttonClicked(String dormName) throws FileNotFoundException {
////        ImageGenerator generator = new ImageGenerator();
////        DraggableNodePaneMaker draggable = new DraggableNodePaneMaker();
//        for(Button b : buttons) {
//            b.fire();
//            if(b.getText() == dormName) {
//                b.setOnAction(e -> {
//                Group dormImage;
//                    try {
////                        dormImage = getDormImage(dormName);
////                        return dormImage;
////                        Node[] furniture = getFurniture();
//
////                    Pane borderPane = getBorderPane();
////                    Node[] furnitureNode = getFurniture();
////                    imageGroup = generator.GetImageAsGroup(b.getText());
////                    var root = draggable.createPane(800, 600, imageGroup.getChildren().toArray()(new Node[0]));
////                    borderPane.setRight(root);
////                    borderPane.setCenter(draggable.createDraggableApp(nodeArray));
////                    } catch (IOException ex) {
////                        throw new RuntimeException(ex);
//////                    }
////                });
////                break;
////            }
////        }
////        return null;
//
////        return imageGroup;
//
////        ImageGenerator generator = new ImageGenerator();
////        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
////        BorderPane borderPane = new BorderPane();
////
////        Group imageGroup = generator.GetImageAsGroup(buttonName);
////        var root = paneMaker.createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
////        borderPane.setRight(root);
//    }
//
}


