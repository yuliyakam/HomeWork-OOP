package TreeGenealogi;

import java.time.LocalDate;

public class People extends Person {
    private int id;
    private String fname;
    private String name;
    private String getLname;
    private LocalDate birghtday;
    private String sex;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return getLname;
    }

    public void setLname(String lname) {
        this.getLname = lname;
    }

    public LocalDate getBirghtday() {
        return birghtday;
    }

    public void setBirghtday(LocalDate birghtday) {
        this.birghtday = birghtday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", name='" + name + '\'' +
                ", lname='" + getLname + '\'' +
                ", birghtday=" + birghtday +
                ", sex='" + sex + '\'' +
                '}';
    }
}

