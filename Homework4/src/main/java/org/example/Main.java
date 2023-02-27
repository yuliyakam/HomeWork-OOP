package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        NotePad np = new NotePad();

        np.addTask(new YesterdayYet(LocalDate.of(2023, 02, 25), "Matting",
                "10:30", "2023 03 20", "Gin"));
        np.addTask(new MidleImportant(LocalDate.of(2023, 02, 25), "Visit Bos",
                "8:00", "2023 02 28", "Gin"));
        np.addTask(new NotImportant(LocalDate.of(2023, 03, 20), "Cinema",
                "17:00", "2023 03 20", "Gin"));
        np.addTask(new YesterdayYet(LocalDate.of(2023, 02, 25), "Matting",
                "10:30", "2023 03 20", "Gin"));
        System.out.println(np);
        System.out.println("--------------------------------------------------------");

//При помощи методов showHiPriority(), showMidlePriority(), showLowPriority() получаем задачи по приоритетам
        System.out.println("Задача среднего приоритета:");
        np.showMidlePriority();
        System.out.println("--------------------------------------------------------");

//Для удаления записи вызываем метод deleteTask()
        System.out.println("Введите id записи для удаления");
        int id = input.nextInt();
        np.deleteTask(id);
        System.out.println("--------------------------------------------------------");
        System.out.println(np);
        System.out.println("--------------------------------------------------------");

        System.out.println("Какую по приоритету задачу нужно создать? Нажмите цифру\n1-высокую 2-среднюю 3-низкую");
        int chek = input.nextInt();
//Метод формирует задачу и записывает её в файл NotePad.csv
        np.addTaskFromUserByCheck(chek);

// Метод считывает данные из файла NotePad.csv и выводит данные в консоль
        ReadNotepad rd = new ReadNotepad();
        rd.readFile();
    }
}