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
        console = new Console(DataProvidedApp.provideBookLibrary());
    }

    @Test
    public void should_print_welcome_message_when_console_is_start(){
        console.start();
        verify(console, times(1)).welcome();
    }
}
