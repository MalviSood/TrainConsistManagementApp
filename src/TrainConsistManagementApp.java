import java.util.Arrays;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        Arrays.sort(bogieNames);

        System.out.println(Arrays.toString(bogieNames));
    }
}