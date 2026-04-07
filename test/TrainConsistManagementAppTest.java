import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private int[] bubbleSort(int[] arr) {
        int[] capacities = arr.clone(); // avoid modifying original

        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
        return capacities;
    }

    @Test
    void testSorting_NormalCase() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSorting_AlreadySorted() {
        int[] input = {10, 20, 30, 40};
        int[] expected = {10, 20, 30, 40};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSorting_ReverseOrder() {
        int[] input = {50, 40, 30, 20, 10};
        int[] expected = {10, 20, 30, 40, 50};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSorting_WithDuplicates() {
        int[] input = {30, 10, 30, 20};
        int[] expected = {10, 20, 30, 30};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSorting_SingleElement() {
        int[] input = {42};
        int[] expected = {42};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSorting_EmptyArray() {
        int[] input = {};
        int[] expected = {};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testOriginalArrayUnchanged() {
        int[] input = {72, 56, 24};
        int[] copy = input.clone();

        bubbleSort(input);

        assertArrayEquals(copy, input); // original should remain unchanged
    }
}