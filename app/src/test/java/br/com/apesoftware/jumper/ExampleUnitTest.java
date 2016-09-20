package br.com.apesoftware.jumper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void subtrair_isCorreto() throws Exception {
        // Apenas para testar o servidor de integracao continua
        assertEquals(4, 20-10);
    }

}