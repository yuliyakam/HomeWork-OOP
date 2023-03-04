package Calc;

import java.util.Scanner;

public class Menu {
    private Rational rat1;
    private Rational rat2;
    private Complex com1;
    private Complex com2;
    public static Scanner input = new Scanner(System.in);
    public Rational getRat1() {
        return rat1;
    }

    public Rational getRat2() {
        return rat2;
    }

    public Complex getCom1() {
        return com1;
    }

    public Complex getCom2() {
        return com2;
    }

    public int startMenu(){
        System.out.println("Выбирите с какими числами хотите работать 1 - рациональные 2 - комплексные");
        int inp = input.nextInt();

        return inp;
    }
    public int doChoice(){
        System.out.println("Выбирите действие\n1-сложение 2-вычитание 3-умножение 4-деление");
        int chek = input.nextInt();
        return chek;
    }

}
