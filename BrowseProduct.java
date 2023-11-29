import java.util.ArrayList;

public class BrowseProduct {

    private ArrayList<Product> products;

    BrowseProduct() {
        products = new ArrayList<>();

        products.add(new Product("Laptop", 156, 12));
        products.add(new Product("Mobile", 156, 23));
        products.add(new Product("Video games", 156, 11));
        products.add(new Product("Camera", 156, 6));
        products.add(new Product("Tv", 156, 9));
        products.add(new Product("Air Conditioner", 156, 3));
        products.add(new Product("Sport Equipment", 156, 3));
    }

    public void showAvailableProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(getProductInfo(i));
        }
    }

    public boolean takeProduct(int productIndex, int wantedQuantity) {

        Product product = getProduct(productIndex);

        if (product.getQuantity() >= wantedQuantity) {

            products.set(productIndex, new Product(product.getName(), product.getPrice(), product.getQuantity() - wantedQuantity));
            return true;
        }

        return false;//not exists on stock
    }


    public Product getProduct(int productIndex) {
        return products.get(productIndex);
    }

    public String getProductInfo(int productIndex) {
        Product product = getProduct(productIndex);
        //1-(laptop, 230) X 21
        return (productIndex + 1) + "-(" + product.getName() + ", " + product.getPrice() + ") X " + product.getQuantity();
    }

    public int getProductCount() {
        return products.size();
    }

}
