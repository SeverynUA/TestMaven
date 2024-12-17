package brainacad.org.Models.Formulas;


public class Square_formula
{
    private double area;

    public Square_formula(){}

    public void setArea(double area)
    {
        if (area > 0)
        {
            this.area = area;
        } else
        {
            throw new IllegalArgumentException("Area must be greater than 0: " + area);
        }
    }

    public double getArea(){return this.area;}

    public void Found_by_Sides(double a)
    {
        // Формула для площі квадрата
        // S = a^2
        // де a - довжина сторони квадрата

        double area = a*a;

        setArea(area);
    }

    public void printArea()
    {
        System.out.println("Area of Square: " + getArea());
    }
}
