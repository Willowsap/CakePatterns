import java.util.ArrayList;

public class CalorieBuddy implements Viewer {

    private double highCals;
    private double lowCals;
    private double currCals;
    private String label;
    private ArrayList<Double> pastCals;

    public CalorieBuddy(String label) {
        this.label = label;
        this.pastCals = new ArrayList<Double>();
    }

    public CalorieBuddy(Cake cake, String label) {
        this.label = label;
        this.pastCals = new ArrayList<Double>();
        watchCake(cake);
    }

    public void watchCake(Cake cake) {
        cake.addViewer(this);
        currCals = lowCals = highCals = cake.getCalories();
    }

    public double[] getPastCals() {
        double[] a = new double[pastCals.size()];
        for (int i = 0; i < a.length; i++) a[i] = pastCals.get(i);
        return a;
    }

    public String getLabel() {
        return this.label;
    }

    public double getCurrCals() {
        return this.currCals;
    }

    public double getHighCals() {
        return this.highCals;
    }

    public double getLowCals() {
        return this.lowCals;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void report() {
        System.out.printf("CalorieBuddy: %s has %s from %.2f to %.2f calories.\n",
            label, currCals > pastCals.get(pastCals.size() - 1) ? "increased" : "decreased",
            pastCals.get(pastCals.size() - 1), currCals);
    }

    @Override
    public void update(Viewable v, Object arg) {
        Cake cake = (Cake) v;
        if (cake.getCalories() != currCals) {
            pastCals.add(currCals);
            currCals = cake.getCalories();
            if (currCals > highCals) highCals = currCals;
            if (currCals < lowCals) lowCals = currCals;
            report();
        }
    }
}