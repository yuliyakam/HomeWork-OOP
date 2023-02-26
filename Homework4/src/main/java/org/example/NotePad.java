package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NotePad <E> implements Iterable{
    public static Scanner input = new Scanner(System.in);

    private List<Task> tasksList = new ArrayList<>();



    public List<Task> getTasksList() {
        return tasksList;
    }
    public void addTask(Task task){
        tasksList.add(task);
    }

    public void addTaskFromUserByCheck(int chek){
        SaveNotepad sv = new SaveNotepad();

        System.out.println("Введите дату (2023,07,22-год,месяц,день через зпт и без пробелов)");
        String data = input.next();
        String[] dataArr = data.split(",");
        LocalDate d = LocalDate.of(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]));
        System.out.println("Добавьте задачу");
        String strTask = input.next();
        System.out.println("Установите время дедлайна (16:50 - часы(от 1-23), минуты(от 0-59) через : и без пробелов)");
        String deadLineTime = input.next();
        System.out.println("Установите дату дедлайна(2023,07,22-год,месяц,день через зпт и без пробелов)");
        String deadLineDate = input.next();
        System.out.println("Укажите автора");
        String avtor = input.next();


        switch (chek){
            case (1): {
                tasksList.add(new Task<YesterdayYet>(d, strTask, deadLineTime, deadLineDate, avtor));
                sv.save(tasksList);
            }
            case (2): {
                tasksList.add(new Task<MidleImportant>(d, strTask, deadLineTime, deadLineDate, avtor));
                sv.save(tasksList);
            }
            case (3): {
                tasksList.add(new Task<NotImportant>(d, strTask, deadLineTime, deadLineDate, avtor));
                sv.save(tasksList);
            }
            }
        }

    public void createTask(){

    }


    @Override
    public String toString() {
        return "Имеются записи: \n" +
               tasksList +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int ind = 0;
            @Override
            public boolean hasNext() {
                return ind < tasksList.size();
            }

            @Override
            public Object next() {
                return tasksList.get(ind++);
            }
        };
    }
}

