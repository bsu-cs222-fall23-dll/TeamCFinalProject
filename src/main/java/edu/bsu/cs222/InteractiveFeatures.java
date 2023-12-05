package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class InteractiveFeatures extends DraggableNodePaneMaker {
    public String[] dormNames = {"Dehority",
    "Park", "Beyerl", "Botsford-Swinford", "Kinghorn",
    "North West", "Noyer", "Schmidt-Wilson", "Studebaker East",
    "Studebaker West", "Woodworth"};


    public Pane getDormRoom() {
        GridPane gridPane = new GridPane();
        UserCreatingFurniture furnitureFunction = new UserCreatingFurniture();
        Button dormRoomButton = new Button("See Dorm Room");
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>(); // choiceBoxes is empty
        dormRoomButton.setOnAction(e -> {
            try {
                gridPane.add(clickedDormRoomButton(choiceBoxes),2,3);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        //add dorm names b/c choiceBoxes(1) {getSizeBox()}
        gridPane.add(furnitureFunction.getSizeBox(choiceBoxes,1),0,1);

        //add created dorm image in gridPane
        gridPane.add(dormRoomButton,0,2);
        return gridPane;
    }

    public Pane clickedDormRoomButton(ArrayList<ChoiceBox> choices) throws FileNotFoundException {
        UserCreatingFurniture furnitureFunction = new UserCreatingFurniture();
        String chosenDorm = furnitureFunction.getChoice(choices.get(0)); //gets the chosen value(dorm) by user
        GridPane gridPane = new GridPane();
        Pane image = getDormImage(chosenDorm);

        gridPane.add(image, 0, 0);
        return gridPane;
    }

//    public Pane displayButtonGrid() {
//        int i = 0;
//        GridPane gridPane = new GridPane();
//        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
//
//        System.out.println("hi");
//        for(Button b : buttons) {
//            // do something with your button
//            // maybe add an EventListener or something
//            b.setOnAction(new EventHandler<ActionEvent>() {
//              @Override
//              public void handle(ActionEvent event) {
//                  try {
//                      BorderPane pane = buttonActionsPane(b);
//                      paneMaker.borderPane.setCenter(pane);
//                  } catch (FileNotFoundException e) {
//                      throw new RuntimeException(e);
//                  }
//              }
//            });
//            gridPane.add(b, 0, i*(i+(int)b.getWidth()));
//            i++;
//        }
//        return gridPane;
//    }

//    public BorderPane buttonActionsPane(Button b) throws FileNotFoundException {
//        System.out.println("bye");
//        BorderPane rootPane = new BorderPane();
//        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
//
//        Pane image = getDormImage(b.getText());
//        System.out.println(b.getText());
//        rootPane.setRight(image);
//        rootPane.setCenter(paneMaker.createDraggableApp(paneMaker.getFurnitureNodes()));
//        rootPane.setBottom(paneMaker.dormDataTilePane(b.getText()));
//
////        HBox hBox = new HBox();
////        hBox.getChildren().addAll(rootPane);
//
//        return rootPane;
//    }

//    public AnchorPane displayButtonData(buttonData) {
//        AnchorPane anchorpane = new AnchorPane();
//
//        HBox hb = new HBox();
//        hb.setPadding(new Insets(0, 10, 10, 10));
//        hb.setSpacing(10);
////        hb.getChildren().addAll();
//
//        anchorpane.getChildren.addAll(buttonData, hb);
//    }

    public Pane getDormImage(String dormName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group imageGroup;
        Pane imageGroupPane = null;
//        for(Button b : buttons) {
//            if(b.getText().equals(dormName)) {
//                imageGroup = generator.GetImageAsGroup(dormName);
//                imageGroupPane = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
////                borderPane.setRight(imageGroupPane);
//                break;
//            }
//        }
        imageGroup = generator.GetImageAsGroup(dormName);
        imageGroupPane = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
        borderPane.setRight(imageGroupPane);

        return imageGroupPane;
    }
}