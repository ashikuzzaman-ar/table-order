package core;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Food;
import model.Order;
import util.FileReadWrite;

public class Main extends FileReadWrite {

    private static final Scanner IN = new Scanner(System.in);
    private static Map<String, Food> foodMap;
    private static Main main;
    private static Order order;

    public Main(String fileName) {

        super(fileName);
    }

    public static void main(String[] args) throws FileNotFoundException {

        main = new Main("foods.txt");
        main.initializeFoodItems();

        int choice;
        do {
            //print menu and read choice
            menu();
            choice = IN.nextInt();
            switch (choice) {
                case 1:
                    showFoodItems();
                    break;
                case 2:
                    orderFood();
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
    private static void orderFood() {

        if (order == null) {

            System.out.print("Enter table number: ");
            order = new Order(IN.nextInt());
        }

        char iteration;
        do {

            System.out.print("Enter food code: ");
            String foodCode = IN.next().trim().toUpperCase();

            if (foodMap.containsKey(foodCode)) {

                System.out.printf("Enter quantity of %s : ", foodCode);
                int foodQuantity = IN.nextInt();

                if (!order.getFoodItems().containsKey(foodCode)) {

                    order.getFoodItems().put(foodCode, foodQuantity);
                } else {

                    order.getFoodItems().replace(foodCode, order.getFoodItems().get(foodCode) + foodQuantity);
                }
            } else {

                System.out.println("This item is not available! Please try again.");
            }

            System.out.print("Add more? Y/n: ");
            iteration = (IN.next().trim().toLowerCase()).charAt(0);
        } while (iteration == 'y');
    }

    /**
     * Print food ordered list
     */
    private static void showOrderedList() {

        Map<String, Integer> foodItems = order.getFoodItems();
        System.out.println("Food items for table number " + order.getTableNumber() + " : ");

        System.out.printf("%-8s%-30s%-10s%-5s\n", "Code", "Food Name", "Quantity", "Cost");
        System.out.println("-----------------------------------------------------");
        
        order.setFinalBill(0);

        foodItems.entrySet().stream().forEach(item -> {

            String key = item.getKey();
            String name = foodMap.get(key).getMenuName();
            int quantity = item.getValue();
            int cost = foodMap.get(key).getMenuPrice() * quantity;
            order.setFinalBill(order.getFinalBill() + cost);
            System.out.printf("%-8s%-30s%-10s%-5s\n", key, name, quantity, cost);
        });

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-8s%-30s%-10s%-5s\n", "", "Total:", "", order.getFinalBill());
//        System.out.println("Final Bill: " + order.getFinalBill() + "\n\n");2
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
