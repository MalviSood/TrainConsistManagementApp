import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean isSafetyCompliant(List<TrainConsistManagementApp.GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> {
                    if (b.type.equals("Cylindrical")) {
                        return b.cargo.equals("Petroleum");
                    }
                    return true;
                });
    }

    @Test
    void testSafety_AllValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Box", "Grain"));

        assertTrue(isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_InvalidCylindricalCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")); // invalid
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Box", "Grain"));

        assertFalse(isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_NoCylindricalBogies() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Box", "Grain"));

        assertTrue(isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_MultipleCylindrical_AllValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));

        assertTrue(isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_MultipleCylindrical_OneInvalid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")); // invalid

        assertFalse(isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_EmptyList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(isSafetyCompliant(bogies)); // allMatch on empty → true
    }

    @Test
    void testSafety_OriginalListUnchanged() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));

        int originalSize = bogies.size();

        boolean result = isSafetyCompliant(bogies);

        assertEquals(originalSize, bogies.size());
        assertTrue(result);
    }
}