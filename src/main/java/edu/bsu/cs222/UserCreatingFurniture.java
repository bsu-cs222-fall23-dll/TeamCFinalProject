package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserCreatingFurniture {

    public String[] furnitureArray = {"Bed", "Chair", "Wardrobe",
            "Trashcan", "Drawer", "Desk"};

    public String[] allImages = {"Bed", "Chair", "Wardrobe",
            "Trashcan", "Drawer", "Desk", "Dehority",
            "Park", "Beyerl", "Botsford-Swinford", "Kinghorn",
            "North West", "Noyer", "Schmidt-Wilson", "Studebaker East",
            "Studebaker West", "Woodworth"};

    public ChoiceBox getSizeBox(ArrayList<ChoiceBox> choiceBoxes, int type) {
        InteractiveFeatures features = new InteractiveFeatures();
        ChoiceBox newBox = new ChoiceBox();
        if (type == 0) newBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        if (type == 1) newBox.getItems().addAll(features.dormNames);
        if (type == 2) newBox.getItems().addAll(1, 2);
        if (type == 3) newBox.getItems().addAll(furnitureArray);


        newBox.getSelectionModel().select(0);
        choiceBoxes.add(newBox);
        return newBox;
    }

    public String getChoice(ChoiceBox choice) {
        return choice.getValue().toString();
    }

}
