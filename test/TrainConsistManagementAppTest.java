import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private int calculateTotalSeats(List<TrainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testTotalSeats_NormalCase() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));

        int total = calculateTotalSeats(bogies);

        assertEquals(152, total);
    }

    @Test
    void testTotalSeats_WithDuplicateTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));

        int total = calculateTotalSeats(bogies);

        assertEquals(142, total);
    }

    @Test
    void testTotalSeats_SingleBogie() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        int total = calculateTotalSeats(bogies);

        assertEquals(56, total);
    }

    @Test
    void testTotalSeats_EmptyList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int total = calculateTotalSeats(bogies);

        assertEquals(0, total);
    }

    @Test
    void testTotalSeats_AllZeroCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Test1", 0));
        bogies.add(new TrainConsistManagementApp.Bogie("Test2", 0));

        int total = calculateTotalSeats(bogies);

        assertEquals(0, total);
    }

    @Test
    void testTotalSeats_LargeValues() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Luxury", 1000));
        bogies.add(new TrainConsistManagementApp.Bogie("Mega", 2000));

        int total = calculateTotalSeats(bogies);

        assertEquals(3000, total);
    }

    @Test
    void testTotalSeats_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        int total = calculateTotalSeats(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals(128, total);
    }
}