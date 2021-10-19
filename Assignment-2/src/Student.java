public class Student implements Comment_Section,Materials_Assements{
    //no detailed implementation of student details since not required for assignment
    //full association between course and student
    private String Id;
    private Course course_enrolled;
    public Student(String id){
        this.setId(id);
    }
    public Student(String id, Course course){
        this.setId(id);
        this.setCourse_enrolled(course);
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setCourse_enrolled(Course course_enrolled) {
        this.course_enrolled = course_enrolled;
    }

    public Course getCourse_enrolled() {
        return course_enrolled;
    }
    
    public void submit_assessments(){
        // TODO: 19-10-2021
    }
    public void view_grades(){
        // TODO: 19-10-2021
    }
    @Override
    public void add_comments() {
        // TODO: 19-10-2021  
    }

    @Override
    public String toString() {
        return "Student Id: '" + Id + '\'';
    }
}
