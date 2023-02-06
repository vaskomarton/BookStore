package org.view;

import org.controller.HibernateContext;
import org.model.Address;
import org.model.Author;
import org.model.Book;
import org.model.BookStore;

import java.util.*;

public class MainMenu implements AutoCloseable{

    public HibernateContext model = new HibernateContext();

    public void start(UI ui) throws Exception {
        boolean run = true;
        Author author = new Author("a", new Date(11,11,11), new ArrayList<Book>());
        Book book = new Book(author, "a");
        BookStore bookStore = new BookStore(Map.of(book, 1),new Address("a", "a", "a", 3, 3));
        while (run) {
            printMenu();
            switch ( ui.inputInt("")){
                case 0:
                    run = false;
                    System.out.println("Bye");
                    break;
                case 1:
                    Menu<Author> authorMenu = new Menu<>(author, model);
                    authorMenu.menuLogic(ui, model);
                    break;
                case 2:
                   Menu<Book> bookMenu = new Menu<>(book, model);
                   bookMenu.menuLogic(ui, model);
                   break;
                case 3:
                    Menu<BookStore> bookStoreMenu = new Menu<>(bookStore, model);
                    bookStoreMenu.menuLogic(ui, model);
                    break;
                default:
                    System.out.println("Not a valid option, please select an other one");
            }
        }
    }

    public void printMenu() {
        System.out.println("""
                1. Author menu
                2. Book menu
                3. Store menu
                
                0. Exit""");
    }

    @Override
    public void close() throws Exception {
        model.close();
    }
}
