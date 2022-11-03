public class CakeCritic implements Viewer {

    private Cake judgee;
    private String contestant;

    public CakeCritic(String contestant) {
        this.contestant = contestant;
    }

    public CakeCritic(String contestant, Cake cake) {
        this.contestant = contestant;
        judgeCake(cake);
    }

    public void judgeCake(Cake cake) {
        cake.addViewer(this);
        judgee = cake;
    }

    public void addedFirstTopping(Cake cake) {
        System.out.printf("Critic: %s has begun adding toppings to their cake!\n", contestant);
        System.out.printf("Critic: Their %s is now a %s\n", judgee.getName(), cake.getName());
        System.out.printf("Critic: What an %s choice!\n", Math.random() < 0.5 ? "excellent" : "awful");
    }

    public void addedNewTopping(Cake cake) {
        System.out.printf("Critic: %s has added a new topping to their cake!\n", contestant);
        System.out.printf("Critic: Their %s is now a %s\n", judgee.getName(), cake.getName());
        System.out.printf("Critic: What an %s choice!\n", Math.random() < 0.5 ? "excellent" : "awful");
    }

    public String getContestant() {
        return this.contestant;
    }

    @Override
    public void update(Viewable v, Object arg) {
        Cake newCake = (Cake) v;
        if (v != judgee) {
            if (newCake instanceof Topping) {
                if (!(judgee instanceof Topping)) {
                    addedFirstTopping(newCake);
                } else {
                    addedNewTopping(newCake);
                }
            }
            judgee = newCake;
        }
    }
    
}
