package Calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Menu m = new Menu();
        Operation o = new Operation(new MainLogger());

        List<Option> operationsList = new ArrayList<>();
        operationsList.add(new SumRational());
        operationsList.add(new SumComplex());
        operationsList.add(new MinusRational());
        operationsList.add(new MinusComplex());
        operationsList.add(new MultRational());
        operationsList.add(new MultComplex());
        operationsList.add(new DivRational());
        operationsList.add(new DivComplex());

        boolean flag = true;
        while (flag){
            System.out.println("Выберите номер действия:");
            for (int i = 0; i < operationsList.size(); i++) {
                System.out.println(i+" - "+operationsList.get(i).discription());
            }
            int chek = input.nextInt();
            operationsList.get(chek).execute();

            System.out.println("Хотите продолжить? Нажмите 1 если да, 2 - нет");
            int in = input.nextInt();
            if (in == 2) flag = false;

        }
    }
}



