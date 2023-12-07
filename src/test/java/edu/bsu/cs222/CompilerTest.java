package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompilerTest {
    @Test
    public void testFoodCourtInfo_Accurate() {
        final Compiler compiler = new Compiler();
        final String dormName = "Dehority";
        final String dehoFoodCourts = "- Woodworth Commons\n- Noyer Market";
        final String foodCourts = compiler.dormRoomInfo(dormName);
        Assertions.assertEquals(dehoFoodCourts, foodCourts);
    }
}
