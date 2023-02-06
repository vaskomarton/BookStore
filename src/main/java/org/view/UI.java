package org.view;

import java.util.List;

public interface UI {

    public void displayMenu(List<String> menuElements, String type);

    public int inputInt(String message);

    public String inputString(String message);
}
