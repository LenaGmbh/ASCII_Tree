import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Get the height of the tree from the user
        int height = getHeight(scanner);

        // Ask the user if they want a star on top of the tree
        boolean star = askForStar(scanner);

        // Build the Christmas tree with the given height and star option
        buildTree(height, star);

        // Close the scanner to release resources
        scanner.close();
    }

    // Function to get the height of the tree from the user
    private static int getHeight(Scanner scanner) {
        int height;
        do {
            // Prompt the user to enter the height
            System.out.print("Enter the height of the tree: ");

            // Check if the user input is a valid integer
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next(); // Consume the invalid input
            }

            // Read the valid integer as the height of the tree
            height = scanner.nextInt();

            // Consume the newline character after reading the integer
            scanner.nextLine();
        } while (height <= 0); // Continue until a positive height is entered
        return height;
    }

    // Function to ask the user if they want a star on top of the tree
    private static boolean askForStar(Scanner scanner) {
        while (true) {
            // Prompt the user for the star option
            System.out.print("Do you want a star on top of the tree? (y/n): ");
            String input = scanner.nextLine();

            // Check if the user input matches "yes" or "y" (case-insensitive)
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                return true; // The user wants a star on top
            }
            // Check if the user input matches "no" or "n" (case-insensitive)
            else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                return false; // The user does not want a star on top
            } else {
                // The user input is invalid, prompt them again
                System.out.println("Please enter either 'yes' or 'no'.");
            }
        }
    }

    // Function to build the Christmas tree with the given height and star option
    private static void buildTree(int height, boolean star) {
        // Print the star on top of the tree if the star option is true
        if (star) {
            for (int i = 0; i < height - 1; i++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        // Print the rows of the tree with the given height
        for (int i = 1; i <= height; i++) {
            // Print spaces to center the 'X's and create a triangle shape
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }

            // Print the 'X's for the current row, forming the branches of the tree
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("X");
            }
            System.out.println();
        }

        // Print the trunk of the tree
        for (int i = 0; i < height - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("I");
    }
}
