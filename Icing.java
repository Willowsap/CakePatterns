public class Icing extends Topping {
    public static final double CALORIES = 500;
    public static final double COST = 7.50;

    private String color;

    public Icing(Cake cake, String color) {
        super(cake, color + " Icing", CALORIES, COST);
        this.color = color;
    }
    
    public String getColor() { return color; }
}
