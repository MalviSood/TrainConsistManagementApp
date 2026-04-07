import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean binarySearch(String[] arr, String key) {
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
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        assertTrue(binarySearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_ElementNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertFalse(binarySearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_FirstElement() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElement() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(binarySearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_EmptyArray() {
        String[] bogieIds = {};

        assertFalse(binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_SingleElementFound() {
        String[] bogieIds = {"BG101"};

        assertTrue(binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_SingleElementNotFound() {
        String[] bogieIds = {"BG101"};

        assertFalse(binarySearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_CaseSensitivity() {
        String[] bogieIds = {"BG101", "BG205"};

        assertFalse(binarySearch(bogieIds, "bg101")); // case-sensitive
    }

    @Test
    void testSearch_UnsortedArray_FailsLogic() {
        String[] bogieIds = {"BG309", "BG101", "BG205"}; // NOT sorted

        // Binary search may fail on unsorted input
        assertFalse(binarySearch(bogieIds, "BG101"));
    }
}