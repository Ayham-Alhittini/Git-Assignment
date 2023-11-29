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
            BrowseProduct browseProduct = new BrowseProduct();

            if (option.equals("1")) {
                ///author: developer 1

                int selectedProductNumber = 0;
                while (true) {

                    System.out.println("Choose one from there products and -1 to exit");
                    browseProduct.showAvailableProducts();


                    selectedProductNumber = scanner.nextInt();

                    if (selectedProductNumber == -1)
                        break;


                    if (selectedProductNumber < 1 || selectedProductNumber > browseProduct.getProductCount()) {
                        System.out.println("Product not exists");
                        continue;
                    }

                    selectedProductNumber -= 1;//convert it to index

                    System.out.println("You choose " + browseProduct.getProductInfo(selectedProductNumber));
                    System.out.print("Enter the wanted quantity: ");

                    int wantedQuantity = scanner.nextInt();

                    if (browseProduct.takeProduct(selectedProductNumber, wantedQuantity)) {
                        System.out.println("Added to your list");
                    } else {
                        System.out.println("No enough quantity in stock");
                    }
                }

            } else if (option.equals("2")) {
                System.out.println("checkout cart under creation");///developer 2
            } else {
                System.out.println("Invalid operation please choose (1-2)");
            }
        }

    }

}

