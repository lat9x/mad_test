package tuan.exam.studentmanagement.model;

public class Student {
    private int id;
    private String name;
    private String dob, town, year;

    public Student(String name, String dob, String town, String year) {
        this.name = name;
        this.dob = dob;
        this.town = town;
        this.year = year;
    }

    public Student(int id, String name, String dob, String town, String year) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.town = town;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
