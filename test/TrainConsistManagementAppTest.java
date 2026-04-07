import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private Map<String, List<TrainConsistManagementApp.Bogie>> groupBogiesByType(
            List<TrainConsistManagementApp.Bogie> bogies) {

        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    void testGroup_MultipleTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertEquals(3, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGroup_DuplicateTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 80));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertEquals(2, result.size());
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGroup_SingleTypeMultipleBogies() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 80));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 65));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(3, result.get("Sleeper").size());
    }

    @Test
    void testGroup_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGroup_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 80));

        int originalSize = bogies.size();

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertEquals(3, bogies.size());
        assertEquals(originalSize, bogies.size());
        assertEquals(2, result.size());
    }

    @Test
    void testGroup_CorrectBogiesInEachGroup() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 80));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        List<TrainConsistManagementApp.Bogie> sleeperGroup = result.get("Sleeper");

        assertEquals(2, sleeperGroup.size());
        assertEquals(72, sleeperGroup.get(0).capacity);
        assertEquals(80, sleeperGroup.get(1).capacity);
    }

    @Test
    void testGroup_AllBogiesSameType() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 100));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("General"));
        assertEquals(2, result.get("General").size());
    }

    @Test
    void testGroup_GroupKeysMatchTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 80));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 60));

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogiesByType(bogies);

        assertEquals(3, result.keySet().size());
        assertTrue(result.keySet().contains("Sleeper"));
        assertTrue(result.keySet().contains("AC Chair"));
        assertTrue(result.keySet().contains("First Class"));
    }
}