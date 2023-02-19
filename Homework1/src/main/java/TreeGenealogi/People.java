package TreeGenealogi;

import java.time.LocalDate;
import java.util.ArrayList;

public class People {
    public int id;
    public String fname;
    public String name;
    public String lname;
    public LocalDate birghtday;
    public String  sex;
    public String status;


    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", name='" + name + '\'' +
                ", lname='" + lname + '\'' +
                ", birghtday=" + birghtday +
                ", sex='" + sex + '\'' +
                '}';
    }

}

