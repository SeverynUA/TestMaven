package brainacad.org.Figuras_Formulas;

import brainacad.org.Models.Formulas.Rhombus_formula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Rhombus_formulaTest
{
    private Rhombus_formula rhombus;

    @BeforeEach
    public void setUp() {
        rhombus = new Rhombus_formula();
    }

    @Test
    public void testFound_by_Diagonals() {
        // Тестуємо площу ромба за допомогою діагоналей
        rhombus.Found_by_Diagonals(6, 8);
        assertEquals(24, rhombus.getArea(), "Площа ромба повинна бути 24 (1/2 * 6 * 8)");
    }

    @Test
    public void testFound_by_Height() {
        // Тестуємо площу ромба за допомогою сторони та висоти
        rhombus.Found_by_Height(5, 7);
        assertEquals(35, rhombus.getArea(), "Площа ромба повинна бути 35 (5 * 7)");
    }

    @Test
    public void testFound_by_SideAndAngle() {
        // Тестуємо площу ромба за допомогою сторони та кута
        rhombus.Found_by_SideAndAngle(6, Math.toRadians(30));
        double delta = 0.0001;
        assertEquals(18, rhombus.getArea(),delta, "Площа ромба повинна бути 18 (6^2 * sin(30°))");
    }

    @Test
    public void testInvalidArea()
    {
        // Тестуємо випадок, коли площа повинна бути від'ємною або нульовою
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rhombus.setArea(-1);
        });
        assertEquals("Area must be greater than 0: -1.0", exception.getMessage());
    }

    @Test
    public void testPrintArea() {
        // Тестуємо, чи виводиться площа правильно
        rhombus.Found_by_Height(5, 7);
        rhombus.printArea();  // Має вивести: "Area of Rhombus: 35"
    }
}
