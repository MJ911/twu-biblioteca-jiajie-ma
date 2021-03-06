package com.twu.biblioteca.consoleTest;

import com.twu.biblioteca.DataProvidedApp;
import com.twu.biblioteca.console.Console;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ConsoleTest {
    Console console;

    @Before
    public void setUp() {
        console = spy(new Console(DataProvidedApp.provideBookLibrary(), DataProvidedApp.provideMovieLibrary()));
    }

    @Test
    public void should_print_welcome_message_when_console_is_start(){
        doReturn("1").when(console).inputWithInfo("Please Choose the OptionNo and Input it:");
        console.start();
        verify(console, times(1)).welcome();
    }

    @Test
    public void should_view_the_list_of_all_library_books(){
        doReturn("1").when(console).inputWithInfo("Please Choose the OptionNo and Input it:");
        console.start();
        verify(console, times(1)).listBooks();
    }

    @Test
    public void should_view_the_list_of_all_menu_options(){
        doReturn("1").when(console).inputWithInfo("Please Choose the OptionNo and Input it:");
        console.start();
        verify(console, times(1)).listOptios();
    }

    @Test
    public void should_quit_the_application_when_user_input_Q_option(){
        doReturn("Q").when(console).inputWithInfo("Please Choose the OptionNo and Input it:");
        console.start();
        verify(console, times(1)).exit();
    }
}
