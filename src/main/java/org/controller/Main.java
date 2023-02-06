package org.controller;



import org.view.MainMenu;
import org.view.TerminalUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (
                MainMenu menu = new MainMenu()
        ){
            menu.start(new TerminalUI());
        }

    }
}