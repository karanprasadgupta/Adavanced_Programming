import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
    private void create_slide(){
        //Slide=[Title, No. of Slides, Slides, Date of Upload, Instructor]
        ArrayList<ArrayList<String>> new_slide=new ArrayList<ArrayList<String>>();
        ArrayList<String> title = new ArrayList<>(),slides=new ArrayList<>(),no_of_slides = new ArrayList<>(),date_of_upload=new ArrayList<>(),instructor=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Topic of Slides: ");
        title.add(sc.nextLine());
        new_slide.add(title);
        System.out.print("Enter number of slides: ");
        String n=sc.nextLine();
        no_of_slides.add(n);
        new_slide.add(no_of_slides);
        System.out.println("Enter content of Slides");
        for (int i=1;i<(Integer.parseInt(n)+1);i++){
            System.out.print("Content of Slide "+i+":");
            slides.add(sc.nextLine());
        }
        new_slide.add(slides);
        date_of_upload.add(new Date()+"");
        new_slide.add(date_of_upload);
        instructor.add(getId());
        new_slide.add(instructor);
    }
    public void add_class_material(){
        // TODO: 19-10-2021
    }
    public void add_assessments(){
        // TODO: 19-10-2021
    }
    public void grade_assessments(){
        // TODO: 19-10-2021
    }
    public void close_assessments(){
        // TODO: 19-10-2021
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
