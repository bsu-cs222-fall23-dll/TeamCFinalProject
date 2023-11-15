package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;

import java.io.FileNotFoundException;

public class NodeMaker {

    Group makeImageNode(String nodeName) throws FileNotFoundException {
        ImageGenerator generator = new ImageGenerator();

        Group imageNode = generator.GetFurnitureImageAsGroup(nodeName);

        return imageNode;
    }
}
