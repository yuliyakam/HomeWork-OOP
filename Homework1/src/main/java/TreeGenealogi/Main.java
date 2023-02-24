package TreeGenealogi;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Main implements Serializable {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        PeopleRepository pr = new PeopleRepository();

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
        k1.setKinship(p1, Relationship.HUSBAND, p2);
        k2.setKinship(p2, Relationship.WIFE, p1);

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
        k3.setKinship(p1, Relationship.FATHER, p3);
        k3.setKinship(p2, Relationship.MOTHER, p3);
        k1.setKinship(p3, Relationship.SON, p1);
        k2.setKinship(p3, Relationship.SON, p2);

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
        k4.setKinship(p1, Relationship.FATHER, p4);
        k4.setKinship(p2, Relationship.MOTHER, p4);
        k1.setKinship(p4, Relationship.DAUGHTER, p1);
        k2.setKinship(p4, Relationship.DAUGHTER, p2);
        k4.setKinship(p4, Relationship.SISTER, p3);
        k3.setKinship(p3, Relationship.BROTHER, p4);

//для получения информации по человеку на отношениях вида ki, где i это номер отнощений, которые возникли при его
//добавлении, вызываем метод getPairs(). Пример ниже
//        System.out.println(k2.getPairs());

        pr.setFamily(k1.getPairs());
        pr.setFamily(k2.getPairs());
        pr.setFamily(k3.getPairs());
        pr.setFamily(k4.getPairs());


        System.out.println("Хотите добавить нового члена семьи? Если да, нажмите 1");
        int step = input.nextInt();
        if (step == 1) {
            People newPeople = new People();
            newPeople = pr.addInfoAboutNewPeople();
            pr.setNewKinship(newPeople);//Здесь можно добавить цикл и установить все необходимые связи, в качестве теста
            //добавляла инфу по жене сына Михаила, т.к она с семьей не имеет кровной связи установилась связь только с
            //Михаилом. В консоль получила результат Браун Мария Сергеевна WIFE Белоконь Михаил Иванович
            System.out.println("----------------------------------------");
            //выводим в консоль подтверждение, что новый член семьи добавлен, в метод вводим данные нового члена
            pr.getTreeByOnePeople();
        } else System.out.println("Всего доброго!");
//Экспорт в файл temp.out через сериализацию текущего древа
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ;
        oos.writeObject(pr);
        oos.flush();
        oos.close();

//Для импорта древа из файла temp.out. Создаем новый объект класса PeopleRepository. Экспортируем в него сохраненное древо
//Для проверки выводим информацию по семье вызвав на этом объекте метод getAllTree()
        PeopleRepository prExport = new PeopleRepository();
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        prExport = (PeopleRepository) oin.readObject();
        prExport.getAllTree();

////запись в файл информации по 1 человеку
//        SaveTxt infoOnePeople = new SaveTxt();
//        infoOnePeople.savePairs(k4);

////запись в файл информации по семье
//        SaveTxt infoAllFamily = new SaveTxt();
//        infoAllFamily.saveFamilyTree(family);













//      System.out.println("Здравствуйте! Давайте создадим ваше родовое древо\n Необходимо ввести следующие данные");
//        if (!family.containsKey(p1.id))  family.put(p1.id, p1);
//        else //человек есть в базе и нужно проверить в каком он статусе там существует
//            for(People el: family.values()){//если существующий статус не совпадает, добавляем новый
//                if (! p1.status.equals(el.status)) el.status += "," + p1.status;}//разобрать как сделать через StringBil


    }
}