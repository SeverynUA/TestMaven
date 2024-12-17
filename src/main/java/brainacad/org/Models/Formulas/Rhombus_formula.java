package brainacad.org.Models.Formulas;

import static java.lang.Math.sin;

public class Rhombus_formula
{
    private double area;

    public Rhombus_formula() {}

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

    public void Found_by_Diagonals(double d1, double d2)
    {
        // Формула для площі ромба (через діагоналі)
        // S = 1/2 * d1 * d2
        // де d1, d2 - діагоналі ромба
        double area = 0.5 * d1 * d2;

        setArea(area);
    }

    public void Found_by_Height(double a_base, double h_height)
    {
        // Формула для площі ромба (через сторону та висоту)
        // S = a * h
        // де a - довжина сторони, h - висота

        double area = a_base * h_height;

        setArea(area);
    }

    public void Found_by_SideAndAngle(double a_side, double alpha_angle)
    {
        // Формула для площі ромба (через сторону та кут)
        // S = a^2 * sin(alpha)
        // де a - довжина сторони, alpha - внутрішній кут

        double area = a_side * a_side * sin(alpha_angle);

        setArea(area);
    }

    public void printArea()
    {
        System.out.println("Area of Rhombus: " + getArea());
    }
}
