package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class UserCreatingFurnitureTest {
    @Test
    public void testCustomFurnitureArray_IsNotEmpty() {
        final UserCreatingFurniture userFurniture = new UserCreatingFurniture();
        userFurniture.addCustomFurniture(1,1);
        Assertions.assertEquals(userFurniture.furniture.length, 1);
    }

    @Test
    public void testOldFurnitureArray_IsNotEmpty() throws FileNotFoundException {
        final UserCreatingFurniture userFurniture = new UserCreatingFurniture();
        userFurniture.addOldFurniture("Bed.jpg");
        Assertions.assertEquals(userFurniture.furniture.length, 1);
    }

    @Test
    public void testFurnitureNodeArray_IsAccurate() {
        final UserCreatingFurniture userFurniture = new UserCreatingFurniture();

    }

}
