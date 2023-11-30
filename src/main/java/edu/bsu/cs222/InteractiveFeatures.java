package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class InteractiveFeatures extends DraggableNodePaneMaker {
    public Button[] buttons = new Button[11];
    public String[] dormNames = {"Dehority",
    "Park", "Beyerl", "Botsford-Swinford", "Kinghorn",
    "North West", "Noyer", "Schmidt-Wilson", "Studebaker East",
    "Studebaker West", "Woodworth"};

    public Button[] buttonCustomFurniture = new Button[11];
    public String[] customFurnitureNames = {"Height, Width, Create"};

    public void initBtnsArray() {
        int i = 0;
        for(int j = 0; j < buttons.length; j++) {
            Button button = new Button(dormNames[j]);
            buttons[i] = button;
            i++;
        }
    }

    public Pane getButtonGrid() {
        int i = 0;
        GridPane gridPane = new GridPane();
        for(Button b : buttons) {
// do something with your button
// maybe add an EventListener or something
            b.setOnAction(e -> {
                try {
                    Pane image = getDormImage(b.getText());
                    borderPane.setRight(image);
                    borderPane.setCenter(createDraggableApp(getFurnitureNodes()));
                    borderPane.setBottom(dormDataTilePane(b.getText()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });
            gridPane.add(b, 0, i*(i+(int)b.getWidth()));
            i++;
        }
        return gridPane;
    }

    public Pane createCustomFurniture() {
        GridPane gridPane = new GridPane();
        Button button = new Button("Create Furniture");
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>();
        button.setOnAction(e -> {
            System.out.println("Width: " + getChoice(choiceBoxes.get(0)));
            System.out.println("Height: " + getChoice(choiceBoxes.get(1)));
        });
        Text widthText = new Text("Width in feet");
        Text heightTest = new Text("Height in feet");

        ChoiceBox choice;
        choice = getFurnitureSizeBox();
        choice.getSelectionModel().select(0);

        ChoiceBox choice2;
        choice2 = getFurnitureSizeBox();
        choice2.getSelectionModel().select(0);

        choiceBoxes.add(choice);
        choiceBoxes.add(choice2);

        gridPane.add(button,0,1);
        gridPane.add(widthText,0,2);
        gridPane.add(choiceBoxes.get(0),1,2);
        gridPane.add(heightTest,0,3);
        gridPane.add(choiceBoxes.get(1),1,3);
        return gridPane;
    }

    private static ChoiceBox getFurnitureSizeBox() {
        ChoiceBox newBox = new ChoiceBox();
        newBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        return newBox;
    }

    public String getChoice(ChoiceBox choice) {
        return choice.getValue().toString();
    }

    public Pane getDormImage(String dormName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group imageGroup;
        Pane imageGroupPane = null;
        for(Button b : buttons) {
            if(b.getText().equals(dormName)) {
                imageGroup = generator.GetImageAsGroup(dormName);
                imageGroupPane = createPane(800, 600, imageGroup.getChildren().toArray(new Node[0]));
                borderPane.setRight(imageGroupPane);
                break;
            }
        }
        return imageGroupPane;
    }
}