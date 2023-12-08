package edu.bsu.cs222;

import javafx.scene.Group;
import javafx.scene.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class UserCreatingFurnitureTest {
    @Test
    public void testCustomFurnitureArray_IsNotEmpty() {
        final UserCreatingFurniture userFurniture = new UserCreatingFurniture();
        userFurniture.addCustomFurniture(1,1);
        Assertions.assertNotEquals(0, UserCreatingFurniture.furniture.length);
    }

    @Test
    public void testAddOldFurnitureLoop_DoesAdd() throws FileNotFoundException {
        final UserCreatingFurniture userFurniture = new UserCreatingFurniture();
        ImageGenerator imageGenerator = new ImageGenerator();

        Node[] newFurniture = new Node[UserCreatingFurniture.furniture.length + 1];
        Group desiredFurniture = imageGenerator.GetFurnitureImageAsGroup("Bed.jpg");

        userFurniture.addOldFurnitureLoop(newFurniture, desiredFurniture);
        Assertions.assertEquals(1, UserCreatingFurniture.furniture.length);
    }

    @Test
    public void testFurnitureLoop_DoesAdd() throws FileNotFoundException {
        final UserCreatingFurniture userFurniture = new UserCreatingFurniture();
        final NodeMaker nodeMaker = new NodeMaker();
        final Node[] furniture = new Node[]{};

        Node[] getFurniture = new Node[]{nodeMaker.makeImageNode("Chair.png")};
        Node[] newFurniture = new Node[getFurniture.length + furniture.length];

        Node[] newFurnitureArray = userFurniture.spawnFurnitureLoop(newFurniture, getFurniture);
        Assertions.assertEquals(1, newFurnitureArray.length);
    }


}