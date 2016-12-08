package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {

    private final int tableNumber;
    private final Map<String, Integer> foodItems;
    private int finalBill;

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.foodItems = new HashMap<>();
        this.finalBill = 0;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Map<String, Integer> getFoodItems() {
        return foodItems;
    }

    public void setFinalBill(int finalBill) {
        this.finalBill = finalBill;
    }

    public int getFinalBill() {
        return finalBill;
    }
}
