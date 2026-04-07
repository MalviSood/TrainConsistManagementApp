import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ElementFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        assertTrue(linearSearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_ElementNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertFalse(linearSearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_FirstElement() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElement() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        assertTrue(linearSearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_EmptyArray() {
        String[] bogieIds = {};

        assertFalse(linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_SingleElementFound() {
        String[] bogieIds = {"BG101"};

        assertTrue(linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_SingleElementNotFound() {
        String[] bogieIds = {"BG101"};

        assertFalse(linearSearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_CaseSensitivity() {
        String[] bogieIds = {"BG101", "BG205"};

        assertFalse(linearSearch(bogieIds, "bg101")); // case-sensitive
    }
}