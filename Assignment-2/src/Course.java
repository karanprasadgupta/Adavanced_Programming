import java.util.*;

public class Course {
    private String course_name;
    private ArrayList<Instructor> instructors=new ArrayList<Instructor>();
    private ArrayList<Student> students=new ArrayList<Student>();
    private int no_of_instructors;
    private int no_of_students;
    private ArrayList<String> comment_section=new ArrayList<String>();

    public ArrayList<String> getComment_section() {
        return comment_section;
    }

    public void addComment(String comment) {
        this.comment_section.add(comment);
    }

    private ArrayList<Class_Content> Materials=new ArrayList<Class_Content>();
    private ArrayList<Class_Content> Assessments=new ArrayList<Class_Content>();
    public Course(){
        this.course_name="Unknown";
    }
    public Course(String name){
        this.course_name=name;
    }
    public String getCourse_name() {
        return course_name;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
    public ArrayList<Student> getStudents() {
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
        students.add(new Student(Student_id,this));
        setNo_of_students();
    }
    public void add_Instructor(String Instructor_id){
        instructors.add(new Instructor(Instructor_id));
        setNo_of_instructors();
    }
    public void add_Material(Class_Content material){
        Materials.add(material);
    }
    public void add_Assessment(Class_Content Assessment){
        Assessments.add(Assessment);
    }

    public ArrayList<Class_Content> getMaterials() {
        return Materials;
    }

    public ArrayList<Class_Content> getAssessments() {
        return Assessments;
    }

    @Override
    public String toString() {
        return "{ " +
                "Course Name: '" + course_name + '\'' +
                ", Instructors=" + instructors +
                ", Students=" + students + " }";
    }
}
