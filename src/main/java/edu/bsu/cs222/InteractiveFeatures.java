package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class InteractiveFeatures extends DraggableNodePaneMaker {

    public static String currentDorm = "Woodworth";
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

    public Pane getDormImage(String dormName) throws FileNotFoundException {
        currentDorm = dormName;
        ImageGenerator generator = new ImageGenerator();

        Group imageGroup;
        Pane imageGroupPane = null;
        imageGroup = generator.GetImageAsGroup(dormName);
        imageGroupPane = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
        borderPane.setRight(imageGroupPane);

        return imageGroupPane;
    }
}