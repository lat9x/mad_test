package tuan.exam.studentmanagement.model;

public class StudentClass {
    private int student_id, class_id;
    private String semester;
    private int number; // tin chi

    public StudentClass(int student_id, int class_id, String semester, int number) {
        this.student_id = student_id;
        this.class_id = class_id;
        this.semester = semester;
        this.number = number;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
