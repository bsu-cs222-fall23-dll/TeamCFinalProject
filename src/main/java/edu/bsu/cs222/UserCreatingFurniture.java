package edu.bsu.cs222;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class UserCreatingFurniture {

    public Pane createCustomFurniture() {
        GridPane gridPane = new GridPane();
        Button furnitureButton = new Button("Create Furniture");
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>();
        furnitureButton.setOnAction(e -> clickedFurnitureButton(choiceBoxes));

        Text widthText = new Text("Width in feet");
        Text heightTest = new Text("Height in feet");

        gridPane.add(widthText,0,1);
        gridPane.add(getFurnitureSizeBox(choiceBoxes,0),1,1);
        gridPane.add(heightTest,0,2);
        gridPane.add(getFurnitureSizeBox(choiceBoxes,0),1,2);
        gridPane.add(furnitureButton,0,3);
        return gridPane;
    }

    public ChoiceBox getFurnitureSizeBox(ArrayList<ChoiceBox> choiceBoxes, int type) {
        InteractiveFeatures features = new InteractiveFeatures();
        ChoiceBox newBox = new ChoiceBox();
        if (type == 0) newBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        if (type == 1) newBox.getItems().addAll(features.dormNames);
        newBox.getSelectionModel().select(0);
        choiceBoxes.add(newBox);
        return newBox;
    }

    public String getChoice(ChoiceBox choice) {
        return choice.getValue().toString();
    }

    public void clickedFurnitureButton(ArrayList<ChoiceBox> choiceBoxes) {
        int furnitureWidth = Integer.parseInt(getChoice(choiceBoxes.get(0)));
        int furnitureHeight = Integer.parseInt(getChoice(choiceBoxes.get(1)));

        // This is where you can program the "spawning in custom furniture" and use the int variables there for width and height

        System.out.println("Width: " + furnitureWidth);
        System.out.println("Height: " + furnitureHeight);
    }

}
