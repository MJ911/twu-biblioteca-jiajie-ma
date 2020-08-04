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
import java.util.regex.Pattern;

public class Console {
    private final PrintStream printer = System.out;
    private final Scanner scanner = new Scanner(System.in);
    private Library<Book> libraryBooks;
    private Library<Movie> libraryMovies;
    private Authenticator authenticator;
    private LoginInfo loginInfo;
    private UserInfo userInfos;

    public Console(Library<Book> libraryBooks, Library<Movie> libraryMoviess) {
        this.libraryBooks = libraryBooks;
        this.libraryMovies = libraryMoviess;
        this.authenticator = new TestAuthenticator(DataProvidedApp.provideUsers());
        this.userInfos = new UserInfo();
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
            userInfos.getUserItemInfoMap().put(loginInfo, checkBook.get());
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
            userInfos.getUserItemInfoMap().put(loginInfo, checkMovie.get());
        } else {
            printer.println("Sorry,that movie is not available");
        }
    }

    public void main() {
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
            listOptios();
            String optionNo = inputWithInfo("Please Choose the OptionNo and Input it:");
            if("Q".equals(optionNo)) {
                exit();
                break;
            }
            if(!isNumeric(optionNo) || Integer.parseInt(optionNo) < 1 || Integer.parseInt(optionNo) > 6) {
                errorOption();
                continue;
            }
            int optionNumber = Integer.parseInt(optionNo);
            if(optionNumber == 1) {
                listBooks();
                checkBook();
                continue;
            }
            if(optionNumber == 2) {
                returnBook();
                continue;
            }
            if(optionNumber == 3) {
                listMovies();
                continue;
            }
            if(optionNumber == 4) {
                checkMovie();
                continue;
            }
            if(optionNumber == 5) {
                listUserInfo();
                continue;
            }
            if(optionNumber == 6) {
                viewOwnInfo();
            }
        }
    }

    private boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public void errorOption() {
        printer.println("Please select a valid option!");
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
                loginInfo = new LoginInfo(userNo, userPassword);
                authenticator.authenticatorLogin(loginInfo);
                break;
            } catch (ErrorValidationException e) {
                printer.println("Please input the correct ID or PASSWORD!");
            }
        }
    }

    public void listUserInfo() {
        if(!loginInfo.getUserId().equals("admin")) {
            printer.println("You dont have the jurisdiction to use this option, Choose other one!");
            return;
        }
        printer.println("Listing all the checked out message in Biblioteca:");
        userInfos.getUserItemInfoMap().forEach((loginInfo, item) -> printer.println(loginInfo.toString()+item.toString()));
    }

    public void viewOwnInfo() {
        User ownUser = authenticator.getUserInfoByLoginInfo(loginInfo);
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s |  %-30s | %-20s\n";
        printer.println("The following info is your own info:");
        printer.printf(ENTRY_FORMAT, "-userId-", "-userPassword-", "-userName-", "-userEmail-", "-userPhone-");
        printer.printf(ENTRY_FORMAT, ownUser.getUserId(), ownUser.getUserPassword(), ownUser.getUserName(), ownUser.getUserEmail(), ownUser.getUserPhone());
    }

}
