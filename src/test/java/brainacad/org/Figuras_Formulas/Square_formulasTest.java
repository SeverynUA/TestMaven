package brainacad.org.Figuras_Formulas;

import brainacad.org.Models.Formulas.Square_formula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Square_formulasTest
{

    private Square_formula square;

    @BeforeEach
    public void setUp()
    {
        square = new Square_formula();
    }

    @Test
    public void testFound_by_Side()
    {
        square.Found_by_Sides(5);
        assertEquals(25, square.getArea(), "Area should be 25");
    }

    @Test
    public void testSetArea_InvalidValue()
    {
        // Тестуємо випадок, коли площа повинна бути від'ємною або нульовою
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            square.setArea(-5);
        });
        assertEquals(0, square.getArea(), "Area should be 0 for invalid input");
    }

    @Test
    public void testSetArea_ValidValue()
    {
        square.setArea(20);
        assertEquals(20, square.getArea(), "Area should be 20");
    }
}
