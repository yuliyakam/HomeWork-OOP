package Calc;

import java.util.Scanner;

public class Complex extends Number {
    public static Scanner input = new Scanner(System.in);

    double realPart;
    double imaginaryPart;

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    public Complex(int a){
        setRealPart();
        setImaginaryPart();
    }
    public Complex(){

    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart() {
        System.out.println("Введите действительную часть числа");
        double real = input.nextDouble();
        this.realPart = real;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart() {
        System.out.println("Введите мнимую часть числа");
        double imag = input.nextDouble();
        this.imaginaryPart = imag;
    }

    @Override
    public String toString() {
        if (imaginaryPart > 0)
        return realPart + "+" + imaginaryPart +"i";
        else return realPart + " " + imaginaryPart +"i";
    }
}
