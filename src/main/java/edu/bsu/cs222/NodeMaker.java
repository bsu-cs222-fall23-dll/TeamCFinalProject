package edu.bsu.cs222;

import javafx.scene.Group;
import org.w3c.dom.Node;

import java.io.FileNotFoundException;

public class NodeMaker {

    Group makeBed() throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group bed = generator.GetFurnitureImageAsGroup("Bed.jpg");

        return bed;
    }
}
