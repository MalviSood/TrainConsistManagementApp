class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

abstract class GoodsBogie {
    String shape;
    String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            if (shape.equalsIgnoreCase("Rectangular") && cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment: Petroleum cannot be loaded into Rectangular bogie");
            }
            this.cargo = cargoType;
            System.out.println("Cargo assigned: " + cargoType + " to " + shape + " bogie");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Assignment attempt completed for " + shape + " bogie");
        }
    }
}

class RectangularBogie extends GoodsBogie {
    public RectangularBogie() {
        super("Rectangular");
    }
}

class CylindricalBogie extends GoodsBogie {
    public CylindricalBogie() {
        super("Cylindrical");
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        GoodsBogie b1 = new CylindricalBogie();
        b1.assignCargo("Petroleum");

        GoodsBogie b2 = new RectangularBogie();
        b2.assignCargo("Petroleum");

        GoodsBogie b3 = new RectangularBogie();
        b3.assignCargo("Grain");
    }
}