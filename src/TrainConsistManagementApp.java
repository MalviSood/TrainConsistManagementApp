import java.util.*;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("========================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));

        // Safety rule check using allMatch()
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if (b.type.equals("Cylindrical")) {
                        return b.cargo.equals("Petroleum");
                    }
                    return true;
                });

        System.out.println("Goods Bogies:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        System.out.println("\nIs Train Safety Compliant? : " + isSafe);

        System.out.println("\nUC12 safety validation completed...");
    }
}