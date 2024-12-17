package brainacad.org.Figuras_Formulas;


import brainacad.org.Models.Formulas.Rectangle_formulas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Rectangle_formulasTest
{

    private Rectangle_formulas rectangle;

    @BeforeEach
    public void setUp()
    {
        rectangle = new Rectangle_formulas();
    }

    @Test
    public void testFound_by_Sides()
    {
        rectangle.Found_by_Sides(5, 10);
        assertEquals(50, rectangle.getArea(), "Area should be 50");
    }

    @Test
    public void testSetArea_InvalidValue()
    {
        // Тестуємо випадок, коли площа повинна бути від'ємною або нульовою
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rectangle.setArea(-5);
        });
        assertEquals(0, rectangle.getArea(), "Area should be 0 for invalid input");
    }

    @Test
    public void testSetArea_ValidValue()
    {
        rectangle.setArea(20);
        assertEquals(20, rectangle.getArea(), "Area should be 20");
    }
}
