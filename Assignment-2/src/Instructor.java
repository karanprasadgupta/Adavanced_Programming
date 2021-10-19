public class Instructor implements Comment_Section,Materials_Assements{
    //no detailed implementation of instructor details since not required for assignment
    //full association between course and Instructor
    private String Id;
    private Course course_taught;
    public Instructor(String id){
        this.setId(id);
    }
    public Instructor(String id,Course course){
        this.setId(id);
        this.setCourse_taught(course);
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setCourse_taught(Course course_taught) {
        this.course_taught = course_taught;
    }

    public Course getCourse_taught() {
        return course_taught;
    }

    @Override
    public void add_comments() {
        // TODO: 19-10-2021  
    }

    @Override
    public String toString() {
        return "Instructor Id: '" + Id + '\'';
    }
}
