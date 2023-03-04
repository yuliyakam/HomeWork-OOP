package Calc;

import java.util.Scanner;

public class Rational extends Number {
    public static Scanner input = new Scanner(System.in);

    private int numerator;
    private int denominator;

    public  Rational(int a) {
       setNumerator();
       setDenominator();
    }


    public Rational() {

    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setNumerator() {
        System.out.println("Введите числитель");
        int in = input.nextInt();
        this.numerator = in;
    }

    public void setDenominator() {
        System.out.println("Введите знаменатель");
        int inp = input.nextInt();
        this.denominator = inp;
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
