import java.util.Scanner;

public class CakeMakingStation {
    private String maker;
    private Cake cake;
    private Scanner input;

    public CakeMakingStation(String maker, Scanner input) {
        this.maker = maker;
        this.input = input;
    }

    public void bakeCake() {
        System.out.println("What kind of cake would you like to make?");
        System.out.println("1) Red Velvet\n2) Carrot Cake\n3) Marble Cake");
        switch (getInput(input, 1, 3)) {
            case 1:
                cake = new RedVelvetCake();
                break;
            case 2:
                cake = new CarrotCake();
                break;
            case 3:
                cake = new MarbleCake();
                break;
        }
        System.out.printf("Finished baking a %s\n", cake.getName());
    }

    public void addTopping() {
        if (cake == null) {
            System.out.println("You need to bake a cake before you can add toppings.");
            return;
        }
        System.out.printf("What kind of topping would like to add to your %s?\n", cake.getName());
        System.out.println("1) Icing\n2) Sprinkles\n3) Ganache");
        
        switch (getInput(input, 1, 3)) {
            case 1:
                System.out.println("What color icing would you like to use?");
                cake = new Icing(cake, input.nextLine());
                break;
            case 2:
                cake = new Sprinkles(cake);
                break;
            case 3:
                cake = new Ganache(cake);
                break;
        }
        System.out.printf("Finished adding your topping. Your cake: \n%s", cake);
    }

    public Cake getCake() {
        return this.cake;
    }
    
    public String getMaker() {
        return this.maker;
    }

    private int getInput(Scanner kb, int l, int h) {
        int choice = -1;
        do {
            try {
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf("Please enter a number between %d and %d\n", l, h);
            }
            if (choice < l || choice > h) {
                System.out.printf("Please enter a number between %d and %d\n", l, h);
            }
        } while (choice < l || choice > h);
        return choice;
    }
}
