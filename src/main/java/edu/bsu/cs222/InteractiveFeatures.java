package edu.bsu.cs222;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class InteractiveFeatures {
    private Button[] buttons = new Button[11];
    private String[] dormNames = {"Dehority",
    "Park", "North", "Botsford/Swinford", "Kinghorn",
    "North West", "Noyer", "Schmidt/Wilson", "Studebaker East",
    "Studebaker West", "Woodworth"};

    public Pane getGrid() {
        int i = 0;
        GridPane gridPane = new GridPane();
        for(Button b : buttons) {
            gridPane.add(b, 0, i*(i+(int)b.getWidth()));
            i++;
        }
        return gridPane;
    }

    public void initBtnsArray() {
        int i = 0;
        for(int j = 0; j < buttons.length; j++) {
            buttons[i] = new Button(dormNames[j]);
            i++;
        }
    }
}


