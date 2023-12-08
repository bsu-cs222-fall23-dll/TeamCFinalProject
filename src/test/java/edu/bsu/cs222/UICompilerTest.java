package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UICompilerTest {
    @Test
    public void testFoodCourtInfo_IsAccurate() {
        final UICompiler compiler = new UICompiler();
        final String dormName = "Dehority";
        final String dehoFoodCourts = "- Woodworth Commons\n- Noyer Market";
        final String foodCourts = compiler.dormRoomInfo(dormName);
        Assertions.assertEquals(dehoFoodCourts, foodCourts);
    }

    @Test
    public void testReturnDormFurnitureInfo_IsAccurate() {
        final UICompiler compiler = new UICompiler();
        final String dormName = "Dehority";
        final String dehoFurniture = """
                        Chair(s): 2
                        Bed(s): 2
                        Trashcan(s): 2
                        Desk(s): 2
                        Dresser(s): 2
                        Wardrobe(s): 2
                        Closet(s): 0
                        """;
        final String furnitureInfo = compiler.returnDormFurnitureInfo(dormName);
        Assertions.assertEquals(dehoFurniture, furnitureInfo);
    }
}
