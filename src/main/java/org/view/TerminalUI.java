package org.view;

import java.util.List;
import java.util.Scanner;

public class TerminalUI implements UI{

    private String ending = "Back to main menu";

    public TerminalUI(String ending) {
        this.ending = ending;
    }

    public TerminalUI() {
    }

    @Override
    public void displayMenu(List<String> menuElements, String type) {
        System.out.println(type + " menu\n");
        for (int i = 0; i < menuElements.size(); i++) {
            if (i == 0) {
                System.out.println(i + 1 + ". " + menuElements.get(i) + " " + type + "s");
            } else {
                System.out.println(i + 1 + ". " + menuElements.get(i) + " " + type);
            }
        }
        System.out.println("\n0. " + ending);
    }

    @Override
    public int inputInt(String message) {
        Integer result = 0;
        byte trys = 0;
        Scanner scanner = new Scanner(System.in);
        while (++trys <=5){
            try {
                System.out.println(message);
                return result =  Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e ){
                System.out.println("Not valid input type");
            }
        }
        scanner.close();
        return result;
    }

    @Override
    public String inputString(String message) {
        String result = "";
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println(message);
            result = scanner.nextLine();
        }
        return result;
    }
}
