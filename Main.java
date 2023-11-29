import java.util.Scanner;

public class Main {
    ///Base project created by (Team Leader)

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to atypon store");

        while (true) {
            System.out.println("Enter (1) for show all available products");
            System.out.println("Enter (2) for checkout cart");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println("show all available products under creation");///for developer 1
            } else if (option.equals("2")) {
                System.out.println("checkout cart under creation");///developer 2
            } else {
                System.out.println("Invalid operation please choose (1-2)");
            }
        }

    }

}
