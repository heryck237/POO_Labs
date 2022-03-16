package ch.heigvd.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * Test for professor constructor
     */
    @Test
    public void shouldCreateProfessor(){

        Professeur p1 = new Professeur("Donini" , "Pier", "PDO");
        Professeur p2 = new Professeur("Evequoz" , "Claude", "CEZ");

        assertEquals("Pier Donini (PDO)", p1.toString());
        assertEquals("Claude Evequoz (CEZ)", p2.toString());

    }
}
