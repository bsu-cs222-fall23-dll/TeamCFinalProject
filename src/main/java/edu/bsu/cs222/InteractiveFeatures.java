package edu.bsu.cs222;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Group;

import java.io.IOException;

public class InteractiveFeatures {
    /*
    - make buttons
    - add buttons to gradle
    - make buttons switch between dorm images
     */

    public Button createButtons() {
        Button dehorityButton = new Button();
        dehorityButton.setText("Dehority");

        Button parkButton = new Button();
        parkButton.setText("Park");

        Button botswinSwinfordButton = new Button();
        botswinSwinfordButton.setText("Botswin/Swinford");

        Button northButton = new Button();
        northButton.setText("North");

        Button kinghornButton = new Button();
        kinghornButton.setText("Kinghorn");

        Button northWest = new Button();
        northWest.setText("North West");

        Button noyerButton = new Button();
        noyerButton.setText("Noyer");

        Button stuEastButton = new Button();
        stuEastButton.setText("Studebaker East");

        Button stuWestButton = new Button();
        stuWestButton.setText("Studebaker West");

        Button woodworthButton = new Button();
        woodworthButton.setText("Woodworth");

        Button schmidtWilsonButton = new Button();
        schmidtWilsonButton.setText("Schmidt/Wilson");

        return dehorityButton;
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #b51212;");

        Text title = new Text("Ball State University: Residence Halls");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        title.setFill(Color.WHITESMOKE);

        hbox.getChildren().add(title);

        return hbox;
    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Dorm Selection");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().addAll(title, createButtons());

//        vbox.getChildren().add(createButtons());

//        for (int i=0; i<4; i++) {
//            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
//            vbox.getChildren().add(options[i]);
//        }

        return vbox;
    }

    public void displayRoomFromButton(Button button) throws IOException {
        ImageGenerator generator = new ImageGenerator();
        Group imageGroup = generator.GetImageAsGroup();

        if (button.getText().equals("Dehority")) {
            button.setOnAction(e -> {
                //display image this way
            });
        }
    }
}


