import java.util.ArrayList;

public class Topping extends Cake {

    protected Cake cake;

    public Topping(Cake cake, String name, double calories, double cost) {
        super(name, calories, cost);
        this.cake = cake;
        transferViewers(cake);
    }

    @Override
    public String toString() {
        return String.format("Cake: %s\nCalories: %.2f\nCost: $%.2f\n",
            getName(), getCalories(), getCost());
    }

    @Override
    public String getName() {
        return cake.getName() + " with " + super.getName();
    }

    @Override
    public double getCalories() {
        return cake.getCalories() + super.getCalories();
    }

    @Override
    public double getCost() {
        return cake.getCost() + super.getCost();
    }

    private void transferViewers(Cake cake) {
        this.viewers.addAll(cake.viewers);
        cake.viewers = new ArrayList<Viewer>();
        updateViewers();
    }
}
