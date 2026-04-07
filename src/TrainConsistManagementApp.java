public class TrainConsistManagementApp {
    public static void main(String[] args) {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("====================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("====================================\n");

        System.out.println("Available Bogie IDs:");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.println(bogieIds[i]);
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

        System.out.println();

        if (found) {
            System.out.println("Bogie " + searchKey + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchKey + " not found in train consist.");
        }

        System.out.println("\nUC19 search completed...");
    }
}