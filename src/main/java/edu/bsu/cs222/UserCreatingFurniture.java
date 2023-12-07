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

import static edu.bsu.cs222.Compiler.closetCount;
import static edu.bsu.cs222.InteractiveFeatures.currentDorm;

public class UserCreatingFurniture {

    private static Node[] furniture = new Node[]{};
    public String[] furnitureNameArray = {"Bed.jpg", "Chair.png", "Wardrobe.png",
            "Trashcan.png", "Drawers.png", "Desk.png"};


    public Pane getCustomFurniture() {
        GridPane gridPane = new GridPane();
        Button furnitureButton = new Button("Create New Object");
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>();
        furnitureButton.setOnAction(e -> {
            try {
                clickedCustomFurnitureButton(choiceBoxes);
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

    public Pane getExistingFurniture() {
        GridPane gridPane = new GridPane();
        Button furnitureButton = new Button("Create Furniture");
        ArrayList<ChoiceBox> choiceBoxes2 = new ArrayList<ChoiceBox>();
        furnitureButton.setOnAction(e -> {
            try {
                clickedExistingFurnitureButton(choiceBoxes2);
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
        if (type == 0)
            newBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        if (type == 1)
            newBox.getItems().addAll(features.dormNames);
        if (type == 2)
            newBox.getItems().addAll(1, 2);
        if (type == 3)
            newBox.getItems().addAll(furnitureNameArray);


        newBox.getSelectionModel().select(0);
        choiceBoxes.add(newBox);
        return newBox;
    }

    public String getChoice(ChoiceBox choice) {
        return choice.getValue().toString();
    }

    public void clickedExistingFurnitureButton(ArrayList<ChoiceBox> choiceBoxes2) throws FileNotFoundException {
        String chosenFurniture = getChoice(choiceBoxes2.get(0));

        addOldFurniture(chosenFurniture);
    }

    public void clickedCustomFurnitureButton(ArrayList<ChoiceBox> choices) throws FileNotFoundException {
        int furnitureWidth = Integer.parseInt(getChoice(choices.get(0)));
        int furnitureHeight = Integer.parseInt(getChoice(choices.get(1)));

        addCustomFurniture(furnitureHeight, furnitureWidth);
    }


    private void addCustomFurniture(int furnitureHeight, int furnitureWidth) {
            Node element = new Rectangle(furnitureWidth * 40, furnitureHeight * 40, Color.RED);

            Node[] newFurniture = new Node[furniture.length + 1];

            int i;

            for(i = 0; i < furniture.length; i++) {
                newFurniture[i] = furniture[i];
            }

            newFurniture[i] = element;
            furniture = newFurniture;
    }
    private void addOldFurniture(String furnitureName) throws FileNotFoundException {
        ImageGenerator imageGenerator = new ImageGenerator();

        Group desiredFurniture = imageGenerator.GetFurnitureImageAsGroup(furnitureName);

        Node[] newFurniture = new Node[furniture.length + 1];

        int i;

        for(i = 0; i < furniture.length; i++) {
            newFurniture[i] = furniture[i];
        }

        newFurniture[i] = desiredFurniture;
        furniture = newFurniture;

    }
    void spawnFurniture(){
        InteractiveFeatures features = new InteractiveFeatures();
        Compiler compiler = new Compiler();
        DraggableNodePaneMaker DNPM = new DraggableNodePaneMaker();

        BorderPane borderPane = new BorderPane();

        try {
            Pane newImage = features.getDormImage(currentDorm);
            borderPane.setRight(newImage);

            Node[] getFurniture = getFurnitureNodes();

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

            borderPane.setBottom(compiler.dormDataTilePane(currentDorm));

            Stage primaryStage = new Stage();

            primaryStage.setScene(new Scene(borderPane));
            primaryStage.setWidth(1200);
            primaryStage.setHeight(850);
            primaryStage.show();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    Node[] getFurnitureNodes() throws FileNotFoundException {
        NodeMaker nodeMaker = new NodeMaker();
        if(closetCount == 0){
            return new Node[]{nodeMaker.makeImageNode("Chair.png"), nodeMaker.makeImageNode("Chair.png"),
                    nodeMaker.makeImageNode("Desk.png"), nodeMaker.makeImageNode("Desk.png"),
                    nodeMaker.makeImageNode("Drawers.png"), nodeMaker.makeImageNode("Drawers.png"),
                    nodeMaker.makeImageNode("TrashCan.png"), nodeMaker.makeImageNode("TrashCan.png"),
                    nodeMaker.makeImageNode("Bed.jpg"), nodeMaker.makeImageNode("Bed.jpg"),
                    nodeMaker.makeImageNode("Closet.png"), nodeMaker.makeImageNode("Closet.png")};
        }
        else{
            return new Node[]{nodeMaker.makeImageNode("Chair.png"), nodeMaker.makeImageNode("Chair.png"),
                    nodeMaker.makeImageNode("Desk.png"), nodeMaker.makeImageNode("Desk.png"),
                    nodeMaker.makeImageNode("Drawers.png"), nodeMaker.makeImageNode("Drawers.png"),
                    nodeMaker.makeImageNode("TrashCan.png"), nodeMaker.makeImageNode("TrashCan.png"),
                    nodeMaker.makeImageNode("Bed.jpg"), nodeMaker.makeImageNode("Bed.jpg")};
        }
    }
}
