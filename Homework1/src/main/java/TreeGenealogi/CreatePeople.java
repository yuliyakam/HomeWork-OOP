package TreeGenealogi;

import java.time.LocalDate;
import java.time.Month;

public class CreatePeople {
private static CreatePeople instance;
public static CreatePeople getInstance(){
    if (instance == null) instance = new CreatePeople();
    instance.init();
    return instance;
}
private CreatePeople(){

}
People person;
int count = 1;
private void init(){
    person = new People();

    person.id = count;
    person.fname = "";
    person.name = "";
    person.lname = "";
    person.birghtday = LocalDate.of(1900, 7, 1);
    person.sex = "";

}
public CreatePeople setId(){
    person.id = count;
    count++;
    return this;
}
public CreatePeople setFname(String fname){
        person.fname = fname;
        return this;
    }
public CreatePeople setName(String name){
    person.name = name;
    return this;
}
public CreatePeople setLname(String lname){
    person.lname = lname;
    return this;
}
public CreatePeople setBirghtday(LocalDate ofBirth){
    person.birghtday = ofBirth;
    return this;
}
public CreatePeople setSex(String sex){
    person.sex = sex;
    return this;
}
public CreatePeople setStatus(String status) {
    person.status = status;
    return this;
}
public  People create(){
    return person;
}

}
