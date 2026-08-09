package estruturastests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estruturas.Log;

class LogTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testInfoPrintsMessageWhenActive() {
        Log.info("EstruturaTeste", "Mensagem de teste");

        String expected = "[LOG][EstruturaTeste] Mensagem de teste" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }
}
