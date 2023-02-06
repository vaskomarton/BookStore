package org.view;

import org.controller.Controller;
import org.controller.HibernateContext;

import java.util.List;
import java.util.Scanner;

public class Menu<T>{

    private List<String> menuElements = List.of("List","Add", "Delete", "Modify", "Deactivate");

    private T t;

    private Controller<T> controller;

    public Menu(T t, HibernateContext model) {
        this.t = t;
        controller = new Controller<>(this.t, model);
    }

    public void menuLogic(UI ui, HibernateContext model){
        boolean run = true;
        String[] strings = t.getClass().getName().split("\\.");
        String name = strings[strings.length -1];
        while (run) {
            ui.displayMenu(menuElements, name);
            switch (ui.inputInt("")){
                case 0:
                    run = false;
                    break;
                case 1:
                    controller.printAll();
                    break;
                case 2:
                    controller.addObject();
                    break;
                case 3:
                    controller.delete(1L);
                    break;
                case 4:
                    controller.modify(1L);
                case 5:
                    controller.deactivate(1L);
                    default:
                    System.out.println("Not a valid option, please select an other one");
            }
        }
    }
}
