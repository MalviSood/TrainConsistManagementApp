import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> filterBogies(
            List<TrainConsistManagementApp.Bogie> bogies, int threshold) {

        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertEquals(2, result.size());
        assertEquals("Sleeper", result.get(0).name);
        assertEquals("General", result.get(1).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Test", 60));

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 50));

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));
        bogies.add(new TrainConsistManagementApp.Bogie("Luxury", 80));

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 40));

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        List<TrainConsistManagementApp.Bogie> result = filterBogies(bogies, 60);

        assertEquals(originalSize, bogies.size()); // original unchanged
    }
}