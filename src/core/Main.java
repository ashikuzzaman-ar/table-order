/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Scanner;

/**
 *
 * @author ashif
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 0;
        do {
            //print menu and read choice
            menu();
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    printAllAuthors();
                    break;
                case 2:
                    printAllTitlesForAuthor();
                    break;
                case 3:
                    printAllAuthorsForTitle();
                    break;
                case 4:
                    printAllAuthorsRanking();
                    break;
                case 5:
                    printAllAuthorsRankingFromTitle();
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
        System.out.println("");
        System.out.println("###########################################################");
        System.out.println("Enter valid choice: ");
        System.out.println("1. Select All Authors");
        System.out.println("2. Select All Titles for Author");
        System.out.println("3. Select All Authors for Title");
        System.out.println("4. Author's Ranking");
        System.out.println("5. Author's Ranking by Book Title");
        System.out.println("6. Exit");
        System.out.print(">>>>> ");
    }

    /**
     * Print all authors
     */
    private static void printAllAuthors() {

        //TODO: Have to write logic here
    }

    /**
     * Print all authors for title
     */
    private static void printAllAuthorsForTitle() {

        //TODO: Have to write logic here
    }

    /**
     * Print all titles for authors
     */
    private static void printAllTitlesForAuthor() {
        //TODO: Have to write logic here
    }

    /**
     * Print all author's ranking respect to published books
     */
    private static void printAllAuthorsRanking() {

        //TODO: Have to write logic here
    }

    /**
     * Print all author's ranking respect to popularity
     */
    private static void printAllAuthorsRankingFromTitle() {

        //TODO: Have to write logic here
    }
}
