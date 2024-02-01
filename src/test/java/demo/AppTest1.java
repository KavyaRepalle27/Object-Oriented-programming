package demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public abstract class AppTest1 
{
    /**
     * Rigorous Test :-)
     */

    public abstract int number();

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(number() == 2);
    }
}
