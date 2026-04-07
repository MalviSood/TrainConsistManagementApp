public class TrainConsistManagementApp {
    public static void main(String[] args) {
        String[] bogieIds = {};
        String searchKey = "BG309";

        System.out.println("====================================");
        System.out.println("UC20 - Safe Search Validation");
        System.out.println("====================================\n");

        try {
            if (bogieIds.length == 0) {
                throw new IllegalStateException("No bogies available in the train consist.");
            }

            int low = 0;
            int high = bogieIds.length - 1;
            boolean found = false;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (bogieIds[mid].compareTo(searchKey) == 0) {
                    found = true;
                    break;
                } else if (bogieIds[mid].compareTo(searchKey) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (found) {
                System.out.println("Bogie " + searchKey + " found in train consist.");
            } else {
                System.out.println("Bogie " + searchKey + " not found in train consist.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 operation completed...");
    }
}