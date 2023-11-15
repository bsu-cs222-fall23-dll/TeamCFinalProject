package edu.bsu.cs222;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ImageGenerator extends Application {

    public Group GetImageAsGroup(String buttonName) throws FileNotFoundException {

        InputStream fileLocationStream = new FileInputStream("src/main/Images/Test" + buttonName + "Room.png");

        Image roomImage = new Image(fileLocationStream);

        ImageView viewableRoomImage = new ImageView();

        viewableRoomImage.setImage(roomImage);

        viewableRoomImage.setX(10);
        viewableRoomImage.setY(10);
        viewableRoomImage.setFitWidth(575);
        viewableRoomImage.setPreserveRatio(true);

        return new Group(viewableRoomImage);

    }

    public Group GetFurnitureImageAsGroup(String buttonName) throws FileNotFoundException {

        InputStream fileLocationStream = new FileInputStream("src/main/Images/Furniture/" + buttonName);

        Image roomImage = new Image(fileLocationStream);

        ImageView viewableRoomImage = new ImageView();

        viewableRoomImage.setImage(roomImage);

        viewableRoomImage.setPreserveRatio(true);

        return new Group(viewableRoomImage);

    }


    public void start(Stage stage) throws IOException {
        InputStream fileLocationStream = new FileInputStream("src/main/Images/TestDehorityRoom.png");

        Image roomImage = new Image(fileLocationStream);

        ImageView viewableRoomImage = new ImageView();

        viewableRoomImage.setImage(roomImage);

        viewableRoomImage.setX(10);
        viewableRoomImage.setY(10);
        viewableRoomImage.setFitWidth(575);
        viewableRoomImage.setPreserveRatio(true);

    }

}

