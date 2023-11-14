package edu.bsu.cs222;

import org.w3c.dom.Node;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class NodeMaker {

    public Group makeBed() {
        ImageGenerator generator = new ImageGenerator();
        Group bedGroup = null;
        try {
            bedGroup = generator.GetFurnitureImageAsGroup("Bed.jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bedGroup;
    }
}
