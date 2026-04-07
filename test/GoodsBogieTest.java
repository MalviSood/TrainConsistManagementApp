import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testValidCargoAssignment_CylindricalPetroleum() {
        GoodsBogie bogie = new CylindricalBogie();

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testInvalidCargoAssignment_RectangularPetroleum() {
        GoodsBogie bogie = new RectangularBogie();

        bogie.assignCargo("Petroleum");

        // Cargo should NOT be assigned due to exception
        assertNull(bogie.cargo);
    }

    @Test
    void testValidCargoAssignment_RectangularGrain() {
        GoodsBogie bogie = new RectangularBogie();

        bogie.assignCargo("Grain");

        assertEquals("Grain", bogie.cargo);
    }

    @Test
    void testCaseInsensitiveCheck() {
        GoodsBogie bogie = new RectangularBogie();

        bogie.assignCargo("petroleum"); // lowercase

        assertNull(bogie.cargo); // still invalid
    }

    @Test
    void testMultipleAssignments() {
        GoodsBogie bogie = new RectangularBogie();

        bogie.assignCargo("Petroleum"); // invalid
        assertNull(bogie.cargo);

        bogie.assignCargo("Grain"); // valid
        assertEquals("Grain", bogie.cargo);
    }

    @Test
    void testDifferentBogiesIndependently() {
        GoodsBogie b1 = new CylindricalBogie();
        GoodsBogie b2 = new RectangularBogie();

        b1.assignCargo("Petroleum");
        b2.assignCargo("Grain");

        assertEquals("Petroleum", b1.cargo);
        assertEquals("Grain", b2.cargo);
    }

    @Test
    void testNoExceptionPropagation() {
        GoodsBogie bogie = new RectangularBogie();

        // Should NOT throw because exception is handled internally
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}