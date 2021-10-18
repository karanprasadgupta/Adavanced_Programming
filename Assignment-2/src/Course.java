import java.util.*;

public class Course {
    private String course_name;
    private ArrayList<String> instructors=new ArrayList<String>();
    private ArrayList<String> students=new ArrayList<String>();
    private int no_of_instructors;
    private int no_of_students;
    public Course(){
        this.course_name="Unknown";
        this.no_of_students = students.size();
        this.no_of_instructors = instructors.size();
    }
    public Course(String name){
        this.course_name=name;
        this.no_of_students = students.size();
        this.no_of_instructors = instructors.size();
    }
    public String getCourse_name() {
        return course_name;
    }

    public ArrayList<String> getInstructors() {
        return instructors;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    private void setNo_of_students() {
        this.no_of_students = students.size();
    }

    private void setNo_of_instructors() {
        this.no_of_instructors = instructors.size();
    }

    public int getNo_of_instructors() {
        return no_of_instructors;
    }

    public int getNo_of_students() {
        return no_of_students;
    }

    public void add_students(String Student_id){
        students.add(Student_id);
        setNo_of_students();
    }
    public void add_Instructor(String Instructor_id){
        instructors.add(Instructor_id);
        setNo_of_instructors();
    }

    @Override
    public String toString() {
        return "{ " +
                "Course Name: '" + course_name + '\'' +
                ", instructors=" + instructors +
                ", students=" + students + " }";
    }
}
