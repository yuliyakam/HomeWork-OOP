package TreeGenealogi;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PeopleRepository extends People implements TreeModelable, Serializable {

    public static Scanner input = new Scanner(System.in);
    private List<List<Node>> family = new ArrayList<>();
    private Kinship newKinship = new Kinship(new ArrayList<>());


    public People addInfoAboutNewPeople() {

        System.out.println("Введите Фамилию и нажмите Enter");
        String fn = input.next();
        System.out.println("Введите Имя и нажмите Enter");
        String name = input.next();
        System.out.println("Введите Отчество и нажмите Enter");
        String ln = input.next();
        System.out.println("Введите Дату рождения(1960,07,22-год,месяц,день через зпт и без пробелов) и нажимайте Enter");
        String year = input.next();
        String[] arr = year.split(",");
        LocalDate d = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        System.out.println("Введите Пол(м/ж) и нажмите Enter");
        String sex = input.next();
        System.out.println("Введите статус(допустимые значения мать, отец, сестра, брат, жена, муж, дочь, " +
                "сын) и нажмите Enter");
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
    public void setNewKinship(People people){

        System.out.println("Введите фамилию человека с которым устанавливается связь и нажмите Enter");
        String fn = input.next();
        System.out.println("Введите Имя и нажмите Enter");
        String name = input.next();
        System.out.println("Введите Отчество и нажмите Enter");
        String ln = input.next();

        People findPerson = new People();
//ищем родственника с которым будет установлена новая связь
        for (var elem : family) {
            for (Node el : elem) {
                if (el.p1.getFname().equals(fn) && el.p1.getName().equals(name) && el.p1.getLname().equals(ln)) {
                    findPerson = el.p1;
                }
                if (findPerson == null){
                    if (el.p2.getFname().equals(fn) && el.p2.getName().equals(name) && el.p2.getLname().equals(ln)) {
                        findPerson = el.p2;
                    }
                }
            }
        }
//устанавливаем нужные отношения и результата добавляем в нашу колекцию семьи
        if (people.getStatus().equals("мать")) {
            newKinship.setKinship(people, Relationship.MOTHER, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("отец")) {
            newKinship.setKinship(people, Relationship.FATHER, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("сестра")) {
            newKinship.setKinship(people, Relationship.SISTER, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("брат")) {
            newKinship.setKinship(people, Relationship.BROTHER, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("жена")) {
            newKinship.setKinship(people, Relationship.WIFE, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("муж")) {
            newKinship.setKinship(people, Relationship.HUSBAND, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("дочь")) {
            newKinship.setKinship(people, Relationship.DAUGHTER, findPerson);
            this.setFamily(newKinship.getPairs());
        }
        if (people.getStatus().equals("сын")) {
            newKinship.setKinship(people, Relationship.SON, findPerson);
            this.setFamily(newKinship.getPairs());
        }
    }

    @Override
    public void getTreeByOnePeople() {
        System.out.println("Для вывода древа по кокретному человеку\n Введите Фамилию и нажмите Enter");
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



