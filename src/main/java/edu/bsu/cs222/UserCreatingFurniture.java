package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserCreatingFurniture {

    public String[] furnitureArray = {"Bed", "Chair", "Wardrobe",
            "Trashcan", "Drawer", "Desk"};

    public Pane getCustomFurniture() {
        GridPane gridPane = new GridPane();
        Button furnitureButton = new Button("Create Furniture");
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>();
        furnitureButton.setOnAction(e -> {
            try {
                clickedFurnitureButton(choiceBoxes);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Text widthText = new Text("Width in feet");
        Text heightTest = new Text("Height in feet");

        gridPane.add(widthText,0,1);
        gridPane.add(getSizeBox(choiceBoxes,0),1,1);
        gridPane.add(heightTest,0,2);
        gridPane.add(getSizeBox(choiceBoxes,0),1,2);
        gridPane.add(furnitureButton,0,3);
        return gridPane;
    }

    public Pane getFurniture() {
        GridPane gridPane = new GridPane();
        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
        Button furnitureButton = new Button("Create Furniture");
        ArrayList<ChoiceBox> choiceBoxes2 = new ArrayList<ChoiceBox>();
        furnitureButton.setOnAction(e -> {
            try {
                System.out.println("hi");
                gridPane.add(clickedFurnitureButton(choiceBoxes2), 2, 3);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridPane.add(getSizeBox(choiceBoxes2,3),1,1);
        gridPane.add(furnitureButton,1,2);

        return gridPane;
    }

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

    public Pane clickedFurnitureButton(ArrayList<ChoiceBox> choiceBoxes2) throws FileNotFoundException {
        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
        String chosenFurniture = getChoice(choiceBoxes2.get(0));

        GridPane gridPane = new GridPane();
        Pane image = getFurnitureImage(chosenFurniture);
        paneMaker.borderPane.setCenter(paneMaker.createDraggableApp(new Pane[]{image}));

        gridPane.add(image, 0, 0);
        return gridPane;

    }

    public Pane getFurnitureImage(String furnitureName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();
        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();

        Group imageGroup;
        Pane imageGroupPane = null;

        imageGroup = generator.GetFurnitureImageAsGroup(furnitureName);
        imageGroupPane = paneMaker.createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
        paneMaker.borderPane.setRight(imageGroupPane);


        return imageGroupPane;
    }

}
