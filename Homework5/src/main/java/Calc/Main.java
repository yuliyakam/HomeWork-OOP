package Calc;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Menu m = new Menu();
        boolean flag = true;
        while (flag){
            int chek = m.startMenu();
            if (chek == 1){

                Rational rat1 = new Rational(1);
                Rational rat2 = new Rational(1);
                Operation o1 = new Operation( m.doChoice(), rat1, rat2);

            }

            if (chek == 2){
                Complex com1 = new Complex(1);
                Complex com2 = new Complex(1);
                Operation o2 = new Operation(m.doChoice(), com1, com2);
            }
            System.out.println("Хотите продолжить? Нажмите 1 если да, 2 - нет");
            int in = input.nextInt();
            if (in == 2) flag = false;

        }
    }
}



//        Null n = new Null();

//        Integer i = null;
//        if (n.testNull1(i)) System.out.println("Attention NULL!");
//        n.testNull2(i);
//
//        //int num = i; Operation o = new Operation(new MainLogger());