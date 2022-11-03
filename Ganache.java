public class Ganache extends Topping {
    public static final double CALORIES = 250;
    public static final double COST = 5.50;
    public Ganache(Cake cake) {
        super(cake, "Ganache", CALORIES, COST);
    }
}
