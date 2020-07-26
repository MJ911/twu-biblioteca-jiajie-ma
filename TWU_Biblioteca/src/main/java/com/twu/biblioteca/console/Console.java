package com.twu.biblioteca.console;

import com.twu.biblioteca.BibliotecaUtil;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class Console {
    private final PrintStream printer = System.out;
    private final Scanner scanner = new Scanner(System.in);
    private Library libraryBooks;
    private Menu bibliotecaMenu;

    public Console(Library libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void start() {
        this.welcome();
        this.main();
    }

    public void welcome() {
        printer.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listBooks() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s\n";
        printer.println("Listing all the books message in Biblioteca:");
        printer.printf(ENTRY_FORMAT, "-BookNo-","-AUTHOR-", "-PUBLISH YEAR-");
        libraryBooks.getAllBooks().stream().filter(Book::isIn).forEach(book -> printer.printf(ENTRY_FORMAT, book.getBookNo(),book.getAuthor(), book.getPublishYear()));
    }


    public void checkBook() {
        String bookNo = inputWithInfo("Please Choose the BookNo and Input it:");
        Optional<Book> checkBook = libraryBooks.getBookInfoByBookNo(bookNo);
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s\n";
        if(checkBook.isPresent()) {
            printer.println("Thank you!Enjoy the book");
        } else {
            printer.println("Sorry,that book is not available");
        }
    }

    public void returnBook() {
        String bookNo = inputWithInfo("Please Return the BookNo and Input it:");
        boolean isReturn = libraryBooks.returnBook(bookNo);
        if(isReturn) {
            printer.println("Thank you for returning the book!");
            return;
        }
        printer.println("Please select a right bookNo!");
    }

    public void main() {
        this.listOptios();
        this.runOption();
    }

    public void listOptios(){
        bibliotecaMenu = new Menu(BibliotecaUtil.getAllOptions());
        final String ENTRY_FORMAT = "%-16s | %16s\n";
        printer.println("Listing of Biblioteca menu:");
        printer.printf(ENTRY_FORMAT, "-OptionNo-", "-Description-");
        bibliotecaMenu.getMenuItems().forEach(option -> printer.printf(ENTRY_FORMAT, option.getOptionNo(), option.getDescription()));
    }

    public void runOption(){
        while(true) {
            String optionNo = inputWithInfo("Please Choose the OptionNo and Input it:");
            if("Q".equals(optionNo)) {
                exit();
                break;
            }
            if(Integer.parseInt(optionNo) == 1) {
                listBooks();
                checkBook();
                continue;
            }
            if(Integer.parseInt(optionNo) == 2) {
                returnBook();
                continue;
            }
            printer.println("Please select a valid option!");
        }
    }

    public String inputWithInfo(String info) {
        printer.println(info);
        return scanner.nextLine();
    }

    public void exit() {
        printer.println("Thanks your usage!");
    }
}
