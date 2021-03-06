import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Student implements Comment_Section, Materials_Assessments {
    //working
    //no detailed implementation of student details since not required for assignment
    //full association between course and student
    private String Id;
    private Course course_enrolled;
    private ArrayList<Class_Content> OpenAssessment=new ArrayList<Class_Content>();
    private ArrayList<Class_Content> ClosedAssessment=new ArrayList<Class_Content>();
    private ArrayList<Class_Content> GradedAssessment=new ArrayList<Class_Content>();
    private ArrayList<Class_Content> UngradedAssessment=new ArrayList<Class_Content>();
    private ArrayList<Class_Content> UngradedAssessment_wo_file=new ArrayList<Class_Content>();
    private ArrayList<Class_Content> Submissions=new ArrayList<Class_Content>();
    public Student(String id){
        this.setId(id);
    }
    public Student(String id, Course course){
        this.setId(id);
        this.setCourse_enrolled(course);
        this.setClosedAssessment(course_enrolled.getAssessments());
        this.setOpenAssessment(course_enrolled.getAssessments());
    }
    public void refresh_Assignments(){
        this.setClosedAssessment(course_enrolled.getAssessments());
        this.setOpenAssessment(course_enrolled.getAssessments());
    }
    private void setClosedAssessment(ArrayList<Class_Content> closedAssessment) {
        ClosedAssessment = fetch_assignments("Closed");
    }

    public void setOpenAssessment(ArrayList<Class_Content> openAssessment) {
        OpenAssessment = fetch_assignments("Open");
    }
    public void grade_asm(Class_Content asm){
        this.GradedAssessment.add(asm);
    }
    public ArrayList<Class_Content> getClosedAssessment() {
        return ClosedAssessment;
    }

    public ArrayList<Class_Content> getUngradedAssessment_wo_file() {
        return UngradedAssessment_wo_file;
    }

    public ArrayList<Class_Content> getGradedAssessment() {
        return GradedAssessment;
    }

    public ArrayList<Class_Content> getOpenAssessment() {
        return OpenAssessment;
    }

    public ArrayList<Class_Content> getUngradedAssessment() {
        return UngradedAssessment;
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
    private ArrayList<Class_Content> fetch_assignments(String S){
        ArrayList<Class_Content> assessments=new ArrayList<Class_Content>();
        for (Class_Content Assessment: course_enrolled.getAssessments()){
            if (Assessment.getAssessment().get(3).equals(S)){
                Class_Content ass=new Class_Content();
                ass=Assessment;
                if (S.equals("Open")) {
                    if(GradedAssessment.contains(Assessment) || UngradedAssessment_wo_file.contains(Assessment)){
                        int c=1;
                    }
                    else {
                    assessments.add(ass);}
                }
                else if (S.equals("Closed")){
                    assessments.add(ass);
                }
            }
        }
        return assessments;
    }
    private boolean checkoneword(String s){
        if(s.split(" ").length==1){
            return true;
        }
        return false;
    }
    private String  acceptAssessment(String type,String problem){
        Scanner sc=new Scanner(System.in);
        String inp;
        if (type.equals("Quiz")){
            System.out.println(problem);
            while (true){
            System.out.print("Enter One word Answer: ");
                inp=sc.nextLine();
                if (checkoneword(inp)){
                    break;
                }
            }
        }
        else {
            System.out.println("Enter Filename of Assignment");
            while (true){
                inp=sc.nextLine();
                if (isValidZip(inp)){
                    break;
                }
                System.out.println("Enter valid File: ");
            }
        }
        return inp;
    }
    private boolean isValidZip(String filename){
        if (filename.length()<5){
            return false;
        }
        String extension_name=filename.substring(filename.length()-4);
        if(extension_name.equals(".zip")){
            return true;
        }
        return false;
    }
    public void submit_assessments(){
        refresh_Assignments();
        if(OpenAssessment.isEmpty() || OpenAssessment.size()==0){
            System.out.println("No pending Assessments");
            return;
        }
        //System.out.println(""+OpenAssessment);
        ArrayList<Class_Content> pendingsubs=new ArrayList<Class_Content>();
        for (Class_Content Asigns: OpenAssessment){
            if (!Submissions.contains(Asigns)){
                pendingsubs.add(Asigns);
            }
        }
        if (pendingsubs.isEmpty() || pendingsubs.size()==0){
            System.out.println("No Pending Submission");
            return;
        }
        System.out.println("Pending Assessments: ");
        view_assessments(pendingsubs);
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Assessment ID: ");
        int id=sc.nextInt();
        System.out.println();
        if (id>=0 && id<pendingsubs.size()){
                Class_Content Assessment=new Class_Content(pendingsubs.get(id));
                if(UngradedAssessment.contains(Assessment) || GradedAssessment.contains(Assessment)){
                    System.out.println("Already Submitted");
                    return;
                }

                this.UngradedAssessment_wo_file.add(pendingsubs.get(id));
                this.Submissions.add(pendingsubs.get(id));
                String submission=acceptAssessment(Assessment.getAssessment().get(0),Assessment.getAssessment().get(1));
                Assessment.setFilename(submission);
                //Assessment.change_Status("Closed");
                //ClosedAssessment.add(Assessment);
                //System.out.println(OpenAssessment.get(id)+"-osgid"+Assessment.toString()+"-asm");
                this.UngradedAssessment.add(Assessment);
                OpenAssessment.remove(pendingsubs.get(id));
            //System.out.println(""+OpenAssessment);
        }
        else {
            System.out.println("Invalid ID");
        }
    }
    public void view_grades(){
        System.out.println("Graded Submissions: ");
        for (Class_Content assessment: getGradedAssessment()){
            assessment.display_submission_grade();
            System.out.println();
        }
        System.out.println();
        System.out.println("Ungraded Submissions: ");
        for (Class_Content assessment: getUngradedAssessment()){
            assessment.display_submission_ungrade();
            System.out.println();
        }
    }
    @Override
    public void add_comments() {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Comment");
        String comment=sc.nextLine();
        s=comment+" -"+getId()+"\n"+new Date()+"";
        getCourse_enrolled().addComment(s);
    }

    @Override
    public void view_comments() {
        System.out.println("Comments: ");
        for (String comment:course_enrolled.getComment_section()){
            System.out.println(comment);
        }
    }

    @Override
    public String toString() {
        return "Student Id: '" + Id + '\'';
    }
}
