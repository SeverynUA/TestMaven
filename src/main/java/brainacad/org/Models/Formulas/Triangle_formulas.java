package brainacad.org.Models.Formulas;

import static java.lang.Math.sqrt;

public class Triangle_formulas
{
    private double area;

    public Triangle_formulas(){}

    public void setArea(double area)
    {
        if (area > 0)
        {
            this.area = area;
        } else {
            throw new IllegalArgumentException("Area must be greater than 0: " + area);
        }
    }

    public double getArea(){return this.area;}

    public void Found_by_BaseAndHeight(double a_base, double h_height)
    {
        // Формула для площі трикутника
        // S = 1/2 * a * h

        double area = (0.5 * a_base * h_height);

        setArea(area);
    }

    public void Found_by_Sides(double a,double b,double c)
    {
        // Формула для площі трикутника (через сторони, за формулою Герона)
        // S = sqrt(p * (p - a) * (p - b) * (p - c))
        // де a, b, c - сторони трикутника, p = (a + b + c) / 2 - півпериметр

        double p = (a + b + c) / 2;
        double area = sqrt(p * (p - a) * (p - b) * (p - c));

        setArea(area);
    }

    public void printArea()
    {
        System.out.println("Area of Triangle: " + getArea());
    }
}
