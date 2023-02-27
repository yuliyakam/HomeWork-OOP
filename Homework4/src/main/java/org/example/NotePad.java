package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NotePad implements Iterable<Task>, Serializable {
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

        System.out.println("Введите дату (2023 07 22-год,месяц,день через зпт и без пробелов)");
        String data = input.nextLine();
        String[] dataArr = data.split(" ");
        LocalDate d = LocalDate.of(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]));
        System.out.println("Добавьте задачу");
       // input.nextLine();т
        String strTask = input.nextLine();
        System.out.println("Установите время дедлайна (16:50 - часы(от 1-23), минуты(от 0-59) через : и без пробелов)");
        String deadLineTime = input.next();
        System.out.println("Установите дату дедлайна(2023,07,22-год,месяц,день через зпт и без пробелов)");
        String deadLineDate = input.next();
        System.out.println("Укажите автора");
        input.nextLine();//необходимо дублирование nextLine, если он идет после next() или nextInt(), тк эти оераторы
        // оставляют символ \n который считывется nextLine и он переходит на следующий пунк
        String avtor = input.next();


        switch (chek){
            case (1):
                tasksList.add(new YesterdayYet(d, strTask, deadLineTime, deadLineDate, avtor));
                sv.save(tasksList);
                break;

            case (2):
                tasksList.add(new MidleImportant(d, strTask, deadLineTime, deadLineDate, avtor));
                sv.save(tasksList);
                break;

            case (3):
                tasksList.add(new NotImportant(d, strTask, deadLineTime, deadLineDate, avtor));
                sv.save(tasksList);
                break;

            }
        }
    public void showHiPriority(){
        for(Task item:tasksList){
            if(item instanceof YesterdayYet){
                System.out.println(item);
            }
        }
    }
    public void showMidlePriority(){
        for(Task item:tasksList){
            if(item instanceof MidleImportant){
                System.out.println(item);
            }
        }
    }
    public void showLowPriority(){
        for(Task item:tasksList){
            if(item instanceof NotImportant){
                System.out.println(item);
            }
        }
    }
    public  int getTaskById(int id){
        int i = 0;
        boolean not = true;
        while (not && i < tasksList.size()){
            if(tasksList.get(i).getId() == id) not = false;
            else i++;
        }
        if(not){
            i = -1;
        }
        return i;
    }
    public void deleteTask(int id){
        if(getTaskById(id) > -1){
            int i = getTaskById(id);
            tasksList.remove(i);
        }
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

