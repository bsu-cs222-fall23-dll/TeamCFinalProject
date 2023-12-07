package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class InteractiveFeatures extends DraggableNodePaneMaker {
    public String[] dormNames = {"Dehority",
    "Park", "Beyerl", "Botsford-Swinford", "Kinghorn",
    "North West", "Noyer", "Schmidt-Wilson", "Studebaker East",
    "Studebaker West", "Woodworth"};

    public GridPane gridPaneDorm = new GridPane();

    public Pane getDormRoom() {
        UserCreatingFurniture furnitureFunction = new UserCreatingFurniture();
        Button dormRoomButton = new Button("See Dorm Room");
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>(); // choiceBoxes is empty
      //  String chosenFurniture = furnitureFunction.getChoice(choiceBoxes.get(0));


        dormRoomButton.setOnAction(e -> {
            try {
                System.out.println("hello");
//                if (chosenFurniture == "Bed" || "Chair" || "Wardrobe" ||
//                "Trashcan" || "Drawer" || "Desk") {
                //gridPaneDorm.add(furnitureFunction.clickedFurnitureButton(choiceBoxes), 2, 3);
                //}
                gridPaneDorm.add(clickedDormRoomButton(choiceBoxes), 2, 3);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridPaneDorm.add(furnitureFunction.getSizeBox(choiceBoxes,1),0,1);
        gridPaneDorm.add(dormRoomButton,0,2);

        return gridPaneDorm;
    }

    public Group clickedDormRoomButton(ArrayList<ChoiceBox> choices) throws FileNotFoundException {
        UserCreatingFurniture furnitureFunction = new UserCreatingFurniture();
        String chosenDorm = furnitureFunction.getChoice(choices.get(0));

        Pane image = getDormImage(chosenDorm);
        Group root = new Group();

        root.getChildren().add(image);
        return root;
    }

    public Pane getDormImage(String dormName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group imageGroup;
        Pane imageGroupPane = null;

        imageGroup = generator.GetImageAsGroup(dormName);
        imageGroupPane = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
        borderPane.setRight(imageGroupPane); //setRight

        return imageGroupPane;
    }

    public Pane getCustomFurniture() {
        UserCreatingFurniture furniture = new UserCreatingFurniture();
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
        gridPane.add(furniture.getSizeBox(choiceBoxes,0),1,1);
        gridPane.add(heightTest,0,2);
        gridPane.add(furniture.getSizeBox(choiceBoxes,0),1,2);
        gridPane.add(furnitureButton,0,3);
        return gridPane;
    }

    public Pane getFurniture() {
        UserCreatingFurniture furniture = new UserCreatingFurniture();
        Button furnitureButton = new Button("Create Furniture");
        ArrayList<ChoiceBox> choiceBoxes2 = new ArrayList<ChoiceBox>();

        furnitureButton.setOnAction(e -> {
            try {
                System.out.println("hi");
                gridPaneDorm.add(clickedFurnitureButton(choiceBoxes2), 2, 3);//features.gridPaneDorm.add , 2, 3)
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridPaneDorm.add(furniture.getSizeBox(choiceBoxes2,3),1,1);
        gridPaneDorm.add(furnitureButton,1,2);

        return gridPaneDorm;
    }


    public Group clickedFurnitureButton(ArrayList<ChoiceBox> choiceBoxes2) throws FileNotFoundException {
        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
        UserCreatingFurniture furniture = new UserCreatingFurniture();
        String chosenFurniture = furniture.getChoice(choiceBoxes2.get(0));

        Pane image = getFurnitureImage(chosenFurniture);
        Group root = new Group();

        root.getChildren().add(paneMaker.createDraggableApp(new Pane[]{image}));
        return root;

    }

    public Pane getFurnitureImage(String furnitureName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();
        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();

        Group imageGroup;
        Pane imageGroupPane = null;

        imageGroup = generator.GetFurnitureImageAsGroup(furnitureName);
        imageGroupPane = paneMaker.createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
        paneMaker.borderPane.setCenter(imageGroupPane);


        return imageGroupPane;
    }

}