package com.twu.biblioteca.console;

import com.twu.biblioteca.BibliotecaUtil;
import com.twu.biblioteca.DataProvidedApp;
import com.twu.biblioteca.auth.*;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;
import com.twu.biblioteca.library.Item;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class Console {
    private final PrintStream printer = System.out;
    private final Scanner scanner = new Scanner(System.in);
    private Library<Book> libraryBooks;
    private Library<Movie> libraryMovies;
    private Authenticator authenticator;
    private User user;
    private UserInfo userInfo;

    public Console(Library<Book> libraryBooks, Library<Movie> libraryMoviess) {
        this.libraryBooks = libraryBooks;
        this.libraryMovies = libraryMoviess;
        this.authenticator = new AuthenticatorTest(DataProvidedApp.provideUsers());
        this.userInfo = new UserInfo();
    }

    public void start() {
        this.welcome();
        this.login();
        this.main();
    }

    public void welcome() {
        printer.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listBooks() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s\n";
        printer.println("Listing all the books message in Biblioteca:");
        printer.printf(ENTRY_FORMAT, "-BookNo-","-AUTHOR-", "-PUBLISH YEAR-");
        libraryBooks.getAllItems().stream().filter(Item::isIn).forEach(book -> printer.printf(ENTRY_FORMAT, book.getItemNo(),book.getAuthor(), book.getPublishYear()));
    }


    public void checkBook() {
        String bookNo = inputWithInfo("Please Choose the BookNo and Input it:");
        Optional<Book> checkBook = libraryBooks.getItemInfoByItemNo(bookNo);
        if(checkBook.isPresent()) {
            printer.println("Thank you!Enjoy the book");
            userInfo.getUserItemInfoMap().put(user, checkBook.get());
        } else {
            printer.println("Sorry,that book is not available");
        }
    }

    public void returnBook() {
        String bookNo = inputWithInfo("Please Return the BookNo and Input it:");
        boolean isReturn = libraryBooks.returnItemByItemNo(bookNo);
        if(isReturn) {
            printer.println("Thank you for returning the book!");
            return;
        }
        printer.println("That is not a valid book to return.");
    }

    public void listMovies() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s |  %-20s | %-20s\n";
        printer.println("Listing all the movies message in Biblioteca:");
        printer.printf(ENTRY_FORMAT, "-MovieNo-", "-MovieName-", "-MovieReleaseYear-", "-MovieDirector-", "-MovieRating-");
        libraryMovies.getAllItems().stream().filter(Item::isIn).forEach(movie -> printer.printf(ENTRY_FORMAT,
                movie.getItemNo(), movie.getMovieName(), movie.getMovieReleaseYear(), movie.getMovieDirector(), movie.getMovieRating()));
    }

    public void checkMovie() {
        String movieNo = inputWithInfo("Please Choose the MovieNo and Input it:");
        Optional<Movie> checkMovie = libraryMovies.getItemInfoByItemNo(movieNo);
        if(checkMovie.isPresent()) {
            printer.println("Thank you!Enjoy the movie");
            userInfo.getUserItemInfoMap().put(user, checkMovie.get());
        } else {
            printer.println("Sorry,that movie is not available");
        }
    }

    public void main() {
        this.listOptios();
        this.runOption();
    }

    public void listOptios(){
        Menu bibliotecaMenu = new Menu(BibliotecaUtil.getAllOptions());
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
            if(Integer.parseInt(optionNo) == 3) {
                listMovies();
                continue;
            }
            if(Integer.parseInt(optionNo) == 4) {
                checkMovie();
                continue;
            }
            if(Integer.parseInt(optionNo) == 5) {
                listUserInfo();
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

    public void login() {
        while (true) {
            try {
                String userNo = inputWithInfo("Please input your card ID:");
                String userPassword = inputWithInfo("Please input your card PASSWORD:");
                user = new User(userNo, userPassword);
                authenticator.authenticatorLogin(user);
                break;
            } catch (ErrorValidationException e) {
                printer.println("Please input the correct ID or PASSWORD!");
            }
        }
    }

    public void listUserInfo() {
        if(!user.getUserId().equals("admin")) {
            printer.println("You dont have the jurisdiction to use this option, Choose other one!");
            return;
        }
        printer.println("Listing all the checked out message in Biblioteca:");
        userInfo.getUserItemInfoMap().forEach((user, item) -> printer.println(user.toString()+item.toString()));
    }

}
