package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        NotePad np = new NotePad();

        np.addTask(new Task<YesterdayYet>(LocalDate.of(2023, 02, 25), "Matting",
                "10:30", "2023 03 20","Gin"));
        np.addTask(new Task<MidleImportant>(LocalDate.of(2023, 02, 25), "Visit Bos",
                "","","Gin"));
        np.addTask(new Task<NotImportant>(LocalDate.of(2023, 03, 20), "Cinema",
                "", "","Gin"));

        System.out.println("Какую по приоритету задачу нужно создать? Нажмите цифру\n1-высокую 2-среднюю 3-низкую");
        int chek = input.nextInt();
        np.addTaskFromUserByCheck(chek);
        System.out.println(np);

    }
}