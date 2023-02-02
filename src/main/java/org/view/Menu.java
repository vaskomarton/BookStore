package org.view;

import org.controller.Controller;
import org.model.Author;
import org.model.Book;

import java.util.Date;
import java.util.Scanner;

public class Menu {

    public void start(Scanner scanner, Controller controller) {
        boolean run = true;
        while (run) {
            printMenu();
            switch (scanner.nextLine()){
                case "0":
                    run = false;
                    System.out.println("Bye");
                case "1":
                    Author author = new Author("Géza", new Date(91,0,12));
                    controller.addObject(author);
                    controller.addObject(new Book(author,"myIsbn", "Micimackó"));
                    break;
                default:
                    System.out.println("Not a valid option, please select an other one");
            }
        }

    }

    public void printMenu() {
        System.out.println("""
                1. Add book
                2. 
                
                0. Exit""");
    }
}
