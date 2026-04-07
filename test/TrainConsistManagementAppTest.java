import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Loop-based method
    private List<TrainConsistManagementApp.Bogie> filterUsingLoop(
            List<TrainConsistManagementApp.Bogie> bogies) {

        List<TrainConsistManagementApp.Bogie> result = new ArrayList<>();
        for (TrainConsistManagementApp.Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based method
    private List<TrainConsistManagementApp.Bogie> filterUsingStream(
            List<TrainConsistManagementApp.Bogie> bogies) {

        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testBothMethods_SameResultSize() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", i % 100));
        }

        List<TrainConsistManagementApp.Bogie> loopResult = filterUsingLoop(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testFilter_CorrectElements() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 50));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("C", 80));

        List<TrainConsistManagementApp.Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
        assertEquals("B", result.get(0).type);
        assertEquals("C", result.get(1).type);
    }

    @Test
    void testFilter_NoMatchingElements() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 10));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 20));

        List<TrainConsistManagementApp.Bogie> result = filterUsingStream(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllMatchingElements() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 80));

        List<TrainConsistManagementApp.Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testBothMethods_ExactSameElements() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("B" + i, i));
        }

        List<TrainConsistManagementApp.Bogie> loopResult = filterUsingLoop(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());

        for (int i = 0; i < loopResult.size(); i++) {
            assertEquals(loopResult.get(i).capacity, streamResult.get(i).capacity);
        }
    }

    @Test
    void testEmptyList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> loopResult = filterUsingLoop(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = filterUsingStream(bogies);

        assertTrue(loopResult.isEmpty());
        assertTrue(streamResult.isEmpty());
    }

    @Test
    void testOriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 50));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 70));

        int originalSize = bogies.size();

        filterUsingLoop(bogies);
        filterUsingStream(bogies);

        assertEquals(originalSize, bogies.size());
    }
}