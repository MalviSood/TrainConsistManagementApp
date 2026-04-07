import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private String[] sortBogies(String[] arr) {
        String[] copy = arr.clone(); // avoid modifying original
        Arrays.sort(copy);
        return copy;
    }

    @Test
    void testSorting_NormalCase() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testSorting_AlreadySorted() {
        String[] input = {"A", "B", "C"};
        String[] expected = {"A", "B", "C"};

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testSorting_ReverseOrder() {
        String[] input = {"Z", "Y", "X"};
        String[] expected = {"X", "Y", "Z"};

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testSorting_WithDuplicates() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper"};
        String[] expected = {"AC Chair", "Sleeper", "Sleeper"};

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testSorting_SingleElement() {
        String[] input = {"OnlyOne"};
        String[] expected = {"OnlyOne"};

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testSorting_EmptyArray() {
        String[] input = {};
        String[] expected = {};

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testSorting_CaseSensitivity() {
        String[] input = {"sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "sleeper"}; // uppercase comes first

        assertArrayEquals(expected, sortBogies(input));
    }

    @Test
    void testOriginalArrayUnchanged() {
        String[] input = {"Sleeper", "General"};
        String[] copy = input.clone();

        sortBogies(input);

        assertArrayEquals(copy, input); // original unchanged
    }
}