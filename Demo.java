import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = kb.nextLine();
        CakeMakingStation station = new CakeMakingStation(name, kb);
        System.out.printf("Would you like calorie updates on your cake? (y/n): ");
        CalorieBuddy cb = getYOrN(kb) ? new CalorieBuddy(name + "'s Cake"): null;
        System.out.printf("Would you like to hear the critic's remarks? (y/n): ");
        CakeCritic cc = getYOrN(kb) ? new CakeCritic(name): null;
        station.bakeCake();
        if (cb != null) cb.watchCake(station.getCake());
        if (cc != null) cc.judgeCake(station.getCake());
        System.out.printf("Would you like to add toppings? (y/n): ");
        boolean choice = getYOrN(kb);
        while (choice) {
            station.addTopping();
            System.out.printf("Would you like to add another topping? (y/n): ");
            choice = getYOrN(kb);
        }
        System.out.printf("Your final cake:\n%s", station.getCake());
        kb.close();
    }

    public static boolean getYOrN(Scanner kb) {
        char c = kb.nextLine().toLowerCase().charAt(0);
        while (c != 'n' && c != 'y') {
            System.out.printf("Please enter a y for yes or an n for no: ");
            c = kb.nextLine().toLowerCase().charAt(0);
        }
        return c == 'y';
    }
}
