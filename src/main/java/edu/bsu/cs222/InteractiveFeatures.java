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