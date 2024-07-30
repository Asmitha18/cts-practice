import java.util.Arrays;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerceSearch {
    // Linear Search implementation
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search implementation (requires sorted array)
    public static Product binarySearch(Product[] products, int productId) {
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].productId == productId) {
                return products[mid];
            } else if (products[mid].productId < productId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Setup some products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Appliances"),
            new Product(4, "Desk Chair", "Furniture")
        };

        // Sorting products by productId for binary search
        Arrays.sort(products, (a, b) -> Integer.compare(a.productId, b.productId));

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            int option = sc.nextInt();
            sc.nextLine();  // Consume the newline

            if (option == 1 || option == 2) {
                System.out.print("Enter product ID to search: ");
                int productId = sc.nextInt();
                sc.nextLine();  // Consume the newline

                long startTime, endTime, duration;
                Product result = null;

                if (option == 1) {
                    // Linear Search
                    startTime = System.nanoTime();
                    result = linearSearch(products, productId);
                    endTime = System.nanoTime();
                    duration = endTime - startTime;
                    System.out.println("Linear Search took " + duration + " nanoseconds.");
                } else if (option == 2) {
                    // Binary Search
                    startTime = System.nanoTime();
                    result = binarySearch(products, productId);
                    endTime = System.nanoTime();
                    duration = endTime - startTime;
                    System.out.println("Binary Search took " + duration + " nanoseconds.");
                }

                if (result != null) {
                    
                    System.out.println("Product found: " + result);
                } else {
                    System.out.println("Product not found.");
                }
            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}
