package core;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Food;
import util.FileReadWrite;

public class Main extends FileReadWrite {

//    private static
    private static Map<String, Food> foodMap;
    private static Main main;
    

    public Main(String fileName) {

        super(fileName);
    }

    public static void main(String[] args) throws FileNotFoundException {

        main = new Main("foods.txt");
        main.initializeFoodItems();
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
                    main.close();
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

        System.out.println("---------------------------------------------");
        System.out.printf("|%-8s%-30s%-5s|\n", "Code", "Item Name", "Price");
        System.out.println("---------------------------------------------");
        foodMap.entrySet().stream().forEach(food -> {

            Food tempFood = food.getValue();
            System.out.printf("|%-8s%-30s%-5s|\n", tempFood.getMenuCode(), tempFood.getMenuName(), tempFood.getMenuPrice());
            System.out.println("---------------------------------------------");
        });
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

    @Override
    public void close() {

        this.getScanner().close();
    }

    private void initializeFoodItems() {

        foodMap = new HashMap<>();

        String[] foods = this.getFoodItems();

        for (String food : foods) {
            String[] item = food.split(";;");
            Food foodObject = new Food(item[0], item[1], Integer.parseInt(item[2]));
            foodMap.put(foodObject.getMenuCode(), foodObject);
        }
    }
}
