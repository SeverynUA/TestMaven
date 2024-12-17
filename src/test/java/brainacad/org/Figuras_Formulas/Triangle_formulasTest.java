package brainacad.org.Figuras_Formulas;

import brainacad.org.Models.Formulas.Triangle_formulas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Triangle_formulasTest
{

    private Triangle_formulas triangle;

    @BeforeEach
    public void setUp() {
        triangle = new Triangle_formulas();
    }

    @Test
    public void testFound_by_BaseAndHeight() {
        // Тестуємо площу трикутника за допомогою бази та висоти
        triangle.Found_by_BaseAndHeight(6, 4);
        assertEquals(12, triangle.getArea(), "Площа трикутника повинна бути 12 (1/2 * 6 * 4)");
    }

    @Test
    public void testFound_by_Sides() {
        // Тестуємо площу трикутника за допомогою формули Герона (для трикутника зі сторонами 3, 4, 5)
        triangle.Found_by_Sides(3, 4, 5);
        assertEquals(6, triangle.getArea(), "Площа трикутника повинна бути 6 (за формулою Герона)");
    }

    @Test
    public void testInvalidArea()
    {
        // Тестуємо випадок, коли площа повинна бути від'ємною або нульовою
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            triangle.setArea(-1);
        });
        assertEquals("Area must be greater than 0: -1.0", exception.getMessage());
    }

    @Test
    public void testPrintArea() {
        // Тестуємо, чи виводиться площа правильно
        triangle.Found_by_BaseAndHeight(6, 4);
        triangle.printArea();  // Має вивести: "Area of Triangle: 12"
    }
}
