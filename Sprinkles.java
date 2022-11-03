public class Sprinkles extends Topping {
    public static final double CALORIES = 100;
    public static final double COST = 1.50;

    public Sprinkles(Cake cake) {
        super(cake, "Sprinkles", CALORIES, COST);
    }
}
