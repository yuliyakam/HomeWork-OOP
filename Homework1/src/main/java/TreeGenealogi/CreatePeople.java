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

    person.setId(count);
    person.setFname("");
    person.setName("");
    person.setLname("");
    person.setBirghtday(LocalDate.of(1900, 7, 1));
    person.setSex("");

}
public CreatePeople setId(){
    person.setId(count);
    count++;
    return this;
}
public CreatePeople setFname(String fname){
        person.setFname(fname);
        return this;
    }
public CreatePeople setName(String name){
    person.setName(name);
    return this;
}
public CreatePeople setLname(String lname){
    person.setLname(lname);
    return this;
}
public CreatePeople setBirghtday(LocalDate ofBirth){
    person.setBirghtday(ofBirth);
    return this;
}
public CreatePeople setSex(String sex){
    person.setSex(sex);
    return this;
}
public CreatePeople setStatus(String status) {
    person.setStatus(status);
    return this;
}
public  People create(){
    return person;
}

}
