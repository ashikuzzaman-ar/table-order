
package core;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice;
        do {
            //print menu and read choice
            menu();
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    showFoodItems();
                    break;
                case 2:
                    order();
                    break;
                case 3:
                    showOrderedList();
                    break;
                case 4:
                    deleteOrderList();
                    break;
                case 5:
                    finalizeOrder();
                    break;
                case 6:
                    System.out.println("Thank you for using our System.");
                    System.out.println("GoodBye");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (choice != 6);

        System.exit(0);
    }

    /**
     * print menu
     */
    private static void menu() {
        System.out.println("---------------------------------");
        System.out.println("|        Main Menu              |");
        System.out.println("|   1. Show Food Menu           |");
        System.out.println("|   2. Order Food               |");
        System.out.println("|   3. Show Ordered List        |");
        System.out.println("|   4. Delete Item Form List    |");
        System.out.println("|   5. Finalize Order           |");
        System.out.println("|   6. Exit                     |");
        System.out.println("---------------------------------");
        System.out.print("Please, Enter your choice: ");
    }

    /**
     * Print all food items menu
     */
    private static void showFoodItems() {

        //TODO: Have to write logic here
    }

    /**
     * Order food items
     */
    private static void order() {

        //TODO: Have to write logic here
    }

    /**
     * Print food ordered list
     */
    private static void showOrderedList() {
        //TODO: Have to write logic here
    }

    /**
     * Delete items from the ordered list
     */
    private static void deleteOrderList() {

        //TODO: Have to write logic here
    }

    private static void finalizeOrder() {
    
        //TODO: Have to write logic here
    }
}
