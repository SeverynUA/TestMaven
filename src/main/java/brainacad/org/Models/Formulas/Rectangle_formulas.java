package brainacad.org.Models.Formulas;


public class Rectangle_formulas
{
    private double area;

    public Rectangle_formulas(){}

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

    public void Found_by_Sides(double a, double b)
    {
    // Формула для площі трикутника
    // S = 1/2 * a * h

     double area = (a * b);

     setArea(area);
    }

    public void printArea()
    {
        System.out.println("Area of Rectangle: " + getArea());
    }
}
