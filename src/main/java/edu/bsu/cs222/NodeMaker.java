package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;

import java.io.FileNotFoundException;

public class NodeMaker {

    Group makeChair() throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group chair = generator.GetFurnitureImageAsGroup("Chair.png");

        return chair;
    }
    Group makeBed() throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group bed = generator.GetFurnitureImageAsGroup("Bed.jpg");

        return bed;
    }
}
