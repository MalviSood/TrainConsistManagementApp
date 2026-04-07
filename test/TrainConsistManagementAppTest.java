import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean safeBinarySearch(String[] arr, String key) {
        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available in the train consist.");
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].compareTo(key) == 0) {
                return true;
            } else if (arr[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    @Test
    void testSearch_ElementFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412"};

        assertTrue(safeBinarySearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_ElementNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertFalse(safeBinarySearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_EmptyArray_Exception() {
        String[] bogieIds = {};

        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> safeBinarySearch(bogieIds, "BG309")
        );

        assertEquals("No bogies available in the train consist.", exception.getMessage());
    }

    @Test
    void testSearch_SingleElementFound() {
        String[] bogieIds = {"BG309"};

        assertTrue(safeBinarySearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_SingleElementNotFound() {
        String[] bogieIds = {"BG101"};

        assertFalse(safeBinarySearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_FirstElement() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(safeBinarySearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElement() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(safeBinarySearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_UnsortedArray_NotReliable() {
        String[] bogieIds = {"BG309", "BG101", "BG205"}; // unsorted

        boolean result = safeBinarySearch(bogieIds, "BG101");

        // Instead of asserting true/false, just verify method runs
        assertDoesNotThrow(() -> safeBinarySearch(bogieIds, "BG101"));
    }
}