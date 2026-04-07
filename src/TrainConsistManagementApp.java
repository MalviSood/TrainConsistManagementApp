public class TrainConsistManagementApp {
    public static void main(String[] args) {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("====================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("====================================\n");

        System.out.println("Available Bogie IDs:");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.println(bogieIds[i]);
        }

        boolean found = false;

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break;
            }
        }

        System.out.println();

        if (found) {
            System.out.println("Bogie " + searchKey + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchKey + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}