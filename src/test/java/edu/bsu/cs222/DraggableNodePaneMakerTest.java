package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DraggableNodePaneMakerTest {
    @Test
    public void testFoodCourtInfo_Accurate() {
        final DraggableNodePaneMaker paneMaker = new DraggableNodePaneMaker();
        final String dormName = "Dehority";
        final String dehoFoodCourts = "- Woodworth Commons\n- Noyer Market";
        final String foodCourts = paneMaker.dormRoomInfo(dormName);
        Assertions.assertEquals(dehoFoodCourts, foodCourts);
    }
}
