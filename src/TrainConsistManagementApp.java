import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC11 - Validate Train ID & Cargo Codes");
        System.out.println("========================================\n");

        // Sample inputs
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        // Regex patterns
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "PET-[A-Z]{2}";

        // Validate using Pattern.matches()
        boolean isTrainValid = Pattern.matches(trainPattern, trainId);
        boolean isCargoValid = Pattern.matches(cargoPattern, cargoCode);

        System.out.println("Train ID: " + trainId);
        System.out.println("Is Train ID Valid? : " + isTrainValid + "\n");

        System.out.println("Cargo Code: " + cargoCode);
        System.out.println("Is Cargo Code Valid? : " + isCargoValid + "\n");

        System.out.println("UC11 validation completed...");
    }
}