package TreeGenealogi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PeopleRepository extends People implements TreeModelable {
    public static Scanner input = new Scanner(System.in);
    private List<List<Node>> family = new ArrayList<>();


    public People addInfoAboutNewPeople() {

        System.out.println("Введите Фамилию и нажмите Enter");
        String fn = input.next();
        System.out.println("Введите Имя и нажмите Enter");
        String name = input.next();
        System.out.println("Введите Отчество и нажмите Enter");
        String ln = input.next();
        System.out.println("Введите Дату рождения(1960 07 22) и нажмите Enter");
        String day = input.nextLine();
        System.out.println(day);
        String[] arr = day.split(" ");
        System.out.println(Arrays.toString(arr));
        LocalDate d = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        System.out.println("Введите Пол(м/ж) и нажмите Enter");
        String sex = input.next();
        System.out.println("Введите статус(сын, мать и т.д) и нажмите Enter");
        String status = input.next();

        return CreatePeople.getInstance()
                .setId()
                .setFname(fn)
                .setName(name)
                .setLname(ln)
                .setBirghtday(d)
                .setSex(sex)
                .setStatus(status)
                .create();
    }

    @Override
    public void getTreeByOnePeople() {
        System.out.println("Для поиска человека");
        System.out.println("Введите Фамилию и нажмите Enter");
        String fn = input.next();
        System.out.println("Введите Имя и нажмите Enter");
        String name = input.next();
        System.out.println("Введите Отчество и нажмите Enter");
        String ln = input.next();

        for (var elem : family) {
            for (Node el : elem) {
                if (el.p1.getFname().equals(fn) && el.p1.getName().equals(name) && el.p1.getLname().equals(ln)) {
                    System.out.println(el.p1.getFname() + " " + el.p1.getName() + " " + el.p1.getLname() + " " + el.r);
                    System.out.println(el.p2.getFname() + " " + el.p2.getName() + " " + el.p2.getLname());
                }
            }
        }
    }

    public void getAllTree() {
        System.out.println(family);
    }

    public void setFamily(List<Node> relatives) {
        this.family.add(relatives);
    }

}


//    // ToDo
//    public void Export(List<People> peop) {
//    }
//    public void Import() {
//
//    }

//    public People findPeople(){
//
//    }
//    void addPeople(People people) {
//        family.add(people);
//    }


