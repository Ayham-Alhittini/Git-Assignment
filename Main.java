import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ///Base project created by (Team Leader)

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to atypon store");
        System.out.println();
        System.out.println("Enter your balance");

        double totalBalance = scanner.nextDouble();

        ArrayList<Product> cartProducts = new ArrayList<>();

        while (true) {
            System.out.println("Enter (1) for show all available products");
            System.out.println("Enter (2) for checkout cart");

            String option = scanner.nextLine();

            if (option.equals("1")) {


                int productIndex = scanner.nextInt() - 1;
                int wantedQuantity = scanner.nextInt();

                int exampleProductPrice = 12;

                if (totalBalance >= exampleProductPrice * wantedQuantity) {///could buy it
                    totalBalance -= exampleProductPrice * wantedQuantity;

                    cartProducts.add(new Product("example product", exampleProductPrice, wantedQuantity));

                } else {
                    System.out.println("Your balance can't afford it");
                }





            } else if (option.equals("2")) {
                //Author: Developer 2

                double totalPrice = 0;
                for (int i = 0; i < cartProducts.size(); i++) {
                    System.out.println((i + 1) + "- " + cartProducts.get(i).getName() + " X " + cartProducts.get(i).getQuantity());
                    totalPrice += cartProducts.get(i).getPrice();
                }
                System.out.println("Your total price = " + totalPrice);
            } else {
                System.out.println("Invalid operation please choose (1-2)");
            }
        }

    }

}
