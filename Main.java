import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ///Base project created by (Team Leader)

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to atypon store");
        System.out.println();
        System.out.print("Enter your balance: ");

        double totalBalance = Double.parseDouble(scanner.nextLine());

        ArrayList<Product> cartProducts = new ArrayList<>();

        while (true) {
            System.out.println("Enter (1) for show all available products");
            System.out.println("Enter (2) for checkout cart");

            String option = scanner.nextLine();
            BrowseProduct browseProduct = new BrowseProduct();

            if (option.equals("1")) {
                ///author: developer 1

                int selectedProductNumber = 0;
                while (true) {

                    System.out.println("Choose one from there products and -1 to exit");
                    browseProduct.showAvailableProducts();

                    selectedProductNumber = Integer.parseInt(scanner.nextLine());

                    if (selectedProductNumber == -1)
                        break;


                    if (selectedProductNumber < 1 || selectedProductNumber > browseProduct.getProductCount()) {
                        System.out.println("Product not exists");
                        continue;
                    }

                    selectedProductNumber -= 1;//convert it to index

                    System.out.println("You choose " + browseProduct.getProductInfo(selectedProductNumber));
                    System.out.print("Enter the wanted quantity: ");

                    int wantedQuantity = Integer.parseInt(scanner.nextLine());

                    if (browseProduct.takeProduct(selectedProductNumber, wantedQuantity)) {

                        Product product = browseProduct.getProduct(selectedProductNumber);

                        if (totalBalance >= product.getPrice() * wantedQuantity) {///could buy it
                            totalBalance -= product.getPrice() * wantedQuantity;
                            cartProducts.add(product);
                            System.out.println("Added to your list, your balance now = " + totalBalance);
                        } else {
                            System.out.println("Your balance can't afford it");
                        }
                    } else {
                        System.out.println("No enough quantity in stock");
                    }
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

