package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UserCreatingFurniture {

    private Node[] furniture = new Node[]{};

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
//                paneMaker.borderPane.setCenter(paneMaker.createDraggableApp(paneMaker.getFurnitureNodes()));
            } catch (Exception ex) { //FileNotFoundException
                throw new RuntimeException(ex);
            }
        });


        gridPane.add(getSizeBox(choiceBoxes2, 2), 0, 1);

        //add created furniture images in gridPane
        gridPane.add(furnitureButton,0,2);

        return gridPane;
    }

    public ChoiceBox getSizeBox(ArrayList<ChoiceBox> choiceBoxes, int type) {
        InteractiveFeatures features = new InteractiveFeatures();
        ChoiceBox newBox = new ChoiceBox();
        if (type == 0) newBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        if (type == 1) newBox.getItems().addAll(features.dormNames);
        if (type == 2) newBox.getItems().addAll(1, 2);

        newBox.getSelectionModel().select(0);
        choiceBoxes.add(newBox);
        return newBox;
    }

    public String getChoice(ChoiceBox choice) {
        return choice.getValue().toString();
    }

    public Pane clickedFurnitureButton(ArrayList<ChoiceBox> choices) throws FileNotFoundException {
        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
        int furnitureWidth = Integer.parseInt(getChoice(choices.get(0)));
        int furnitureHeight = Integer.parseInt(getChoice(choices.get(1)));
//        int bed = Integer.parseInt(getChoice(choices.get(2)));

        String chosenFurniture = "Bed.jpg";
                //getChoice(choices.get(0)); //gets the chosen value of choice box; maybe not usable for furniture?
        GridPane gridPane = new GridPane();
        Pane image = getFurnitureImage(chosenFurniture);

        //why does image spawn in gridpane when it's set to borderPane??
        paneMaker.borderPane.setCenter(paneMaker.createDraggableApp(new Pane[]{image}));


        gridPane.add(image, 0, 0);

        addNewFurniture(furnitureHeight, furnitureWidth);

        spawnFurniture();

        return gridPane;


        // This is where you can program the "spawning in custom furniture" and use the int variables there for width and height


        // This is where you can spawn in all furniture images

        /*
        - add to StackPane or AnchorPane??
        - add that Pane to borderPane center??
         */

//     *******   paneMaker.borderPane.setCenter(paneMaker.createDraggableApp(paneMaker.getFurnitureNodes()));





//        System.out.println("Width: " + furnitureWidth);
//        System.out.println("Height: " + furnitureHeight);
//        System.out.println("Bed: " + bed);



//    public Pane getFurnitureImage(String furnitureName) throws FileNotFoundException {
//        ImageGenerator generator = new ImageGenerator();
//        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
//
//        Group imageGroup;
//        Pane imageGroupPane = null;
//
//        imageGroup = generator.GetFurnitureImageAsGroup(furnitureName);
//        imageGroupPane = paneMaker.createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
//        paneMaker.borderPane.setRight(imageGroupPane);
//
//        return imageGroupPane;


//        DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
//        GridPane gridPane = new GridPane();
//
//        Circle circle = new Circle();
//        circle.setCenterX(100);
//        circle.setCenterY(100);
//        circle.setRadius(50);
//        circle.setFill(Color.RED);
//
//        gridPane.add(circle, 0, 0);
//
////        paneMaker.borderPane.setAlignment(gridPane, Pos.BOTTOM_CENTER);
////        paneMaker.borderPane.setMargin(gridPane, new Insets(12,12,12,12));
//        paneMaker.borderPane.setCenter(gridPane);  //paneMaker.createDraggableApp(paneMaker.getFurnitureNodes())
//
//        return gridPane;
    }

    private void addNewFurniture(int furnitureHeight, int furnitureWidth) {
            Node element = new Rectangle(furnitureWidth * 40, furnitureHeight * 40, Color.RED);

            Node[] newFurniture = new Node[furniture.length + 1];

            int i;

            for(i = 0; i < furniture.length; i++) {
                newFurniture[i] = furniture[i];
            }

            newFurniture[i] = element;
            furniture = newFurniture;
    }
    void spawnFurniture(){
        InteractiveFeatures features = new InteractiveFeatures();
        DraggableNodePaneMaker DNPM = new DraggableNodePaneMaker();

        BorderPane borderPane = new BorderPane();

        try {
            Pane newImage = features.getDormImage(features.currentDorm);
            borderPane.setRight(newImage);

            Node[] getFurniture = DNPM.getFurnitureNodes();

            Node[] newFurniture = new Node[getFurniture.length + furniture.length];

            for(int i = 0; i < newFurniture.length; i++){
                if(i < getFurniture.length){
                    newFurniture[i] = getFurniture[i];
                }
                else{
                    newFurniture[i] = furniture[i - getFurniture.length];
                }
            }


            borderPane.setCenter(DNPM.createDraggableApp(newFurniture));

            borderPane.setBottom(DNPM.dormDataTilePane(features.currentDorm));

            Stage primaryStage = new Stage();

            primaryStage.setScene(new Scene(borderPane));
            primaryStage.setWidth(1200);
            primaryStage.setHeight(850);
            primaryStage.show();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
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
