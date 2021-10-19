import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Instructor implements Comment_Section, Materials_Assessments {
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

    public void add_class_material(){
        System.out.println("1. Add Lecture Slide\n" +
                "2. Add Lecture Video");
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Choice: ");
        int inp=sc.nextInt();
        Class_Content material=new Class_Content();
        if (inp==1){
            material.create_slide(getId());
            getCourse_taught().add_Material(material);
        }
        else if (inp==2){
            material.add_video(getId());
            getCourse_taught().add_Material(material);
        }
    }
    public void add_assessments(){
        System.out.println("1. Add Assignment\n" +
                "2. Add Quiz");
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Choice: ");
        int inp=sc.nextInt();
        Class_Content Assessment=new Class_Content();
        if (inp==1){
            Assessment.create_Assignment();
            getCourse_taught().add_Assessment(Assessment);
        }
        else if (inp==2){
            Assessment.create_Quiz();
            getCourse_taught().add_Assessment(Assessment);
        }
    }
    public void grade_assessments(){

        view_assessments(getCourse_taught().getAssessments());
        if(getCourse_taught().getAssessments().isEmpty() || getCourse_taught().getAssessments().size()==0){
            return;
        }
        System.out.print("Enter ID of Assessments to view Submissions: ");
        Scanner sc =new Scanner(System.in);
        int i= sc.nextInt();
        String marks;
        System.out.println();
        Class_Content Assessment=getCourse_taught().getAssessments().get(i);
        ArrayList<Student> Students_to_Grade=new ArrayList<Student>();
        for (Student student:getCourse_taught().getStudents()){
            if(student.getUngradedAssessment_wo_file().contains(Assessment)){
                Students_to_Grade.add(student);
            }
        }
        if(Students_to_Grade.isEmpty()){
            System.out.println("No submissions");
            return;
        }
        System.out.println("Choose ID from these ungraded submissions");
        int j=0;
        for (Student student:Students_to_Grade){

            System.out.println(j+". "+student);
            j++;
        }
        System.out.print("Enter id: ");
        int id=sc.nextInt();
        Student selected_student=Students_to_Grade.get(id);
        //System.out.println(selected_student+selected_student.getUngradedAssessment().toString());
        int index_of_Assessment=selected_student.getUngradedAssessment_wo_file().indexOf(Assessment);
            System.out.println("Submission: "+selected_student.getUngradedAssessment().get(index_of_Assessment).getSubmission());
            System.out.println("Max Marks: "+Assessment.getAssessment().get(2));
            System.out.println("Marks Scored: ");
            Scanner mmc=new Scanner(System.in);
            marks=mmc.nextLine();
            Class_Content asm=new Class_Content();
            asm=selected_student.getUngradedAssessment().get(index_of_Assessment);
            asm.change_marks(marks);
            asm.setGrader(getId());
            selected_student.getUngradedAssessment().remove(index_of_Assessment);
            selected_student.getUngradedAssessment_wo_file().remove(index_of_Assessment);
            selected_student.grade_asm(asm);
    }
    public void close_assessments(){
        ArrayList<Class_Content> open_Assessments=new ArrayList<Class_Content>();
        for (Class_Content Assessment: getCourse_taught().getAssessments()){
            if(Assessment.getStatus().equals("Open")){
                open_Assessments.add(Assessment);
            }
        }
        System.out.println("List Of Open Assessments: ");
        view_assessments(open_Assessments);
        System.out.print("Enter ID of assignment to close: ");
        Scanner sc=new Scanner(System.in);
        int index= sc.nextInt();
        Class_Content Assessment_to_close= open_Assessments.get(index);
        int x=getCourse_taught().getAssessments().indexOf(Assessment_to_close);
        getCourse_taught().getAssessments().set(x,Assessment_to_close);
        for (Student student: getCourse_taught().getStudents()){
            student.refresh_Assignments();
        }
        System.out.println("Assignment Closed");
    }
    @Override
    public void add_comments() {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Comment");
        String comment=sc.nextLine();
        s=comment+" -"+getId()+"\n"+new Date()+"";
        getCourse_taught().addComment(s);
    }

    @Override
    public void view_comments() {
        System.out.println("Comments: ");
        for (String comment:course_taught.getComment_section()){
            System.out.println(comment);
        }
    }

    @Override
    public String toString() {
        return "Instructor Id: '" + Id + '\'';
    }
}
