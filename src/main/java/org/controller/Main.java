package org.controller;

import org.view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (
                Scanner scanner = new Scanner(System.in);
                Controller controller = new Controller();
                ){
            Menu menu = new Menu();
            menu.start(scanner, controller);
        }

    }
}