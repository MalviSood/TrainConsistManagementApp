import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean isValidTrainId(String trainId) {
        String trainPattern = "TRN-\\d{4}";
        return Pattern.matches(trainPattern, trainId);
    }

    private boolean isValidCargoCode(String cargoCode) {
        String cargoPattern = "PET-[A-Z]{2}";
        return Pattern.matches(cargoPattern, cargoCode);
    }

    // ================= TRAIN ID TESTS =================

    @Test
    void testTrainId_Valid() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    void testTrainId_InvalidFormat() {
        assertFalse(isValidTrainId("TRAIN-1234")); // wrong prefix
    }

    @Test
    void testTrainId_InvalidDigits() {
        assertFalse(isValidTrainId("TRN-123")); // less digits
    }

    @Test
    void testTrainId_ExtraDigits() {
        assertFalse(isValidTrainId("TRN-12345")); // more digits
    }

    @Test
    void testTrainId_ContainsLetters() {
        assertFalse(isValidTrainId("TRN-12A4")); // letters inside digits
    }

    @Test
    void testTrainId_EmptyString() {
        assertFalse(isValidTrainId(""));
    }

    // ================= CARGO CODE TESTS =================

    @Test
    void testCargoCode_Valid() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testCargoCode_InvalidPrefix() {
        assertFalse(isValidCargoCode("CAR-AB")); // wrong prefix
    }

    @Test
    void testCargoCode_LowercaseLetters() {
        assertFalse(isValidCargoCode("PET-ab")); // lowercase not allowed
    }

    @Test
    void testCargoCode_MoreLetters() {
        assertFalse(isValidCargoCode("PET-ABC")); // extra letters
    }

    @Test
    void testCargoCode_LessLetters() {
        assertFalse(isValidCargoCode("PET-A")); // less letters
    }

    @Test
    void testCargoCode_WithNumbers() {
        assertFalse(isValidCargoCode("PET-A1")); // numbers not allowed
    }

    @Test
    void testCargoCode_EmptyString() {
        assertFalse(isValidCargoCode(""));
    }

    // ================= EDGE CASE =================

    @Test
    void testBoth_ValidTogether() {
        assertTrue(isValidTrainId("TRN-9999"));
        assertTrue(isValidCargoCode("PET-ZZ"));
    }
}