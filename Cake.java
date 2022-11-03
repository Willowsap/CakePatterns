import java.util.ArrayList;

public abstract class Cake implements Viewable {
    protected String name;
    protected double calories;
    protected double cost;
    protected ArrayList<Viewer> viewers;

    public Cake(String name, double calories, double cost) {
        this.name = name;
        this.calories = calories;
        this.cost = cost;
        this.viewers = new ArrayList<Viewer>();
    }

    @Override
    public String toString() {
        return String.format("Cake: %s\nCalories: %.2f\nCost: $%.2f\n", name, calories, cost);
    }

    public String getName() { return name; }
    public double getCalories() { return calories; }
    public double getCost() { return cost; }
    public void addViewer(Viewer v) { viewers.add(v); }
    public void removeViewer(Viewer v) { viewers.remove(v); }
    public void updateViewers() { for (Viewer v : viewers) updateViewer(v); }
    protected void updateViewer(Viewer v) { v.update(this, null);}
}
