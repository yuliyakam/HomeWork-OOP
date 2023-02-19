package TreeGenealogi;

import java.time.LocalDate;
import java.util.*;


public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<ArrayList<Node>> family = new ArrayList<>();

        People p1 = CreatePeople.getInstance()
                .setId()
                .setFname("Белоконь")
                .setName("Иван")
                .setLname("Васильевич")
                .setBirghtday(LocalDate.of(1960, 02, 27))
                .setSex("м")
                .setStatus("отец")
                .create();

        People p2 = CreatePeople.getInstance()
                .setId()
                .setFname("Белоконь")
                .setName("Инна")
                .setLname("Валерьевна")
                .setBirghtday(LocalDate.of(1963, 02, 20))
                .setSex("ж")
                .setStatus("мать")
                .create();
//как только добавили пару родственников, устанавливаем связи между ними
        Kinship k1 = new Kinship();
        Kinship k2 = new Kinship();
// при установлении связи формируем её в две стороны, например от мамы к детям и от детей до мамы
        k1.setKinship(p1, Relationship.husband , p2);
        k2.setKinship(p2, Relationship.wife, p1);

        People p3 = CreatePeople.getInstance()
                .setId()
                .setFname("Белоконь")
                .setName("Михаил")
                .setLname("Иванович")
                .setBirghtday(LocalDate.of(1983, 05, 27))
                .setSex("м")
                .setStatus("сын")
                .create();
//далее после добавления очередного родственника устанавливаем все возможные связи его с другими уже  существующими
        Kinship k3 = new Kinship();
        k3.setKinship(p1, Relationship.father , p3);
        k3.setKinship(p2, Relationship.mother, p3);
        k1.setKinship(p3, Relationship.son, p1);
        k2.setKinship(p3, Relationship.son, p2);

        People p4 = CreatePeople.getInstance()
                .setId()
                .setFname("Белоконь")
                .setName("Елена")
                .setLname("Ивановна")
                .setBirghtday(LocalDate.of(1986, 02, 15))
                .setSex("ж")
                .setStatus("дочь")
                .create();

        Kinship k4 = new Kinship();
        k4.setKinship(p1, Relationship.father, p4);
        k4.setKinship(p2, Relationship.mother, p4);
        k1.setKinship(p4, Relationship.daughter, p1);
        k2.setKinship(p4, Relationship.daughter, p2);
        k4.setKinship(p4, Relationship.sister, p3);
        k3.setKinship(p3, Relationship.brother, p4);
//для получения информации по человеку на отношениях вида ki, где i это номер отнощений, которые возникли при его
// добавлении, вызываем метод getPairs(). Пример ниже
        //k2.printPairs();
        family.add(k1.pairs);
        family.add(k2.pairs);
        family.add(k3.pairs);
        family.add(k4.pairs);

        SaveTxt infoOnePeople = new SaveTxt();
        infoOnePeople.savePairs(k4);

        SaveTxt infoAllFamily = new SaveTxt();
        infoAllFamily.saveFamilyTree(family);














//        System.out.println("Здравствуйте! Давайте создадим ваше родовое древо\n Необходимо ввести следующие данные");

//        Map<Integer, People> family = new HashMap<>();

//        //нужно вынести в отдельный класс добавление
//        System.out.println("Введите Фамилию и нажмите Enter");
//        String fn = input.next();
//        System.out.println("Введите Имя и нажмите Enter");
//        String name = input.next();
//        System.out.println("Введите Отчество и нажмите Enter");
//        String ln = input.next();
//        System.out.println("Введите Дату рождения(1960 07 22) и нажмите Enter");
//        String day = input.nextLine();
//        System.out.println(day);
//        String[] arr = day.split(" ");
//        System.out.println(Arrays.toString(arr));
//        LocalDate d = LocalDate.of(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
//        System.out.println("Введите Пол(м/ж) и нажмите Enter");
//        String sex = input.next();
//        System.out.println("Введите статус(сын, мать и т.д) и нажмите Enter");
//        String status = input.next();
//
//        People p1 = CreatePeople.getInstance()
//                .setId()
//                .setFname(fn)
//                .setName(name)
//                .setLname(ln)
//                .setBirghtday(d)
//                .setSex(sex)
//                .setStatus()
//                .create();
//        System.out.println(p1);
//
//        if (!family.containsKey(p1.id))  family.put(p1.id, p1);
//        else //человек есть в базе и нужно проверить в каком он статусе там существует
//            for(People el: family.values()){//если существующий статус не совпадает, добавляем новый
//                if (! p1.status.equals(el.status)) el.status += "," + p1.status;}//разобрать как сделать через StringBil








    }
}