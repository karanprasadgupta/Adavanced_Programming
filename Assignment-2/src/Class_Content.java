import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Class_Content {
    //working
    private ArrayList<String> material=new ArrayList<String >();
    private ArrayList<String> assessment=new ArrayList<String >();
    public  Class_Content(){
        this.material=new ArrayList<String>();
    }
    public Class_Content(Class_Content class_content) {
        this.material=new ArrayList<String >(class_content.material);
        this.assessment=new ArrayList<String>(class_content.assessment);
    }

    private void setMaterial(ArrayList<String> material) {
        this.material = material;
    }

    public ArrayList<String> getMaterial() {
        return material;
    }
    public void setFilename(String s){
        assessment.set(4,s);
    }
    public String getSubmission(){
        return assessment.get(4);

    }
    public void change_Status(String status){
        assessment.set(3,status);
    }
    public String getStatus(){
        return assessment.get(3);
    }
    private void setAssessment(ArrayList<String> assessment) {
        this.assessment = assessment;
    }
    public void change_marks(String marks){
        assessment.set(5,marks);
    }
    public ArrayList<String> getAssessment() {
        return assessment;
    }
    public void setGrader(String s){
        assessment.set(6,s);
    }

    public void create_slide(String uploader_id){
        //Slide=[type, Title, No. of Slides, Date of Upload, Instructor,Slide1,Slide2....]
        ArrayList<String> new_slide=new ArrayList<String>();
        String type="Slide",title,slides,no_of_slides,date_of_upload;
        new_slide.add(type);
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Topic of Slides: ");
        title=sc.nextLine();
        new_slide.add(title);
        System.out.print("Enter number of slides: ");
        no_of_slides=sc.nextLine();
        new_slide.add(no_of_slides);
        date_of_upload=new Date()+"";
        new_slide.add(date_of_upload);
        new_slide.add(uploader_id);
        System.out.println("Enter content of Slides");
        for (int i=1;i<(Integer.parseInt(no_of_slides)+1);i++){
            System.out.print("Content of Slide "+i+":");
            slides=sc.nextLine();
            new_slide.add(slides);
        }
        setMaterial(new_slide);
    }
    public void display_slide(){
        int n=1;
        System.out.println("Title: "+material.get(1));
        for (int i=5;i<material.size();i++){
            System.out.println("Slide "+n+": "+material.get(i));
        }
        System.out.println("Number of Slides: "+material.get(2));
        System.out.println("Date Of Upload: "+ material.get(3));
        System.out.println("Uploaded by: "+material.get(4));
    }
    public void display_video(){
        System.out.println("Title of Video: "+material.get(1));
        System.out.println("Video file: "+material.get(2));
        System.out.println("Date Of Upload: "+ material.get(3));
        System.out.println("Uploaded by: "+material.get(4));
    }
    private String getValid_Video(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Filename of video: ");
        String filename;
        filename=sc.nextLine();
        while (true){
            String extension_name=filename.substring(filename.length()-4);
            if(extension_name.equals(".mp4") || extension_name.equals(".MP4")){break;}
            System.out.print("Enter Valid file: ");
            filename=sc.nextLine();
        }
        return filename;
    }
    public void add_video(String uploader_id){
        //Video=[type, Title, filename, Date of Upload, Instructor]
        ArrayList<String> new_video=new ArrayList<String>();
        Scanner sc= new Scanner(System.in);
        String type="Video",title,filename,date_of_upload;
        new_video.add(type);
        System.out.print("Enter topic of video: ");
        title=sc.nextLine();
        new_video.add(title);
        filename=getValid_Video();
        new_video.add(filename);
        date_of_upload=new Date()+"";
        new_video.add(date_of_upload);
        new_video.add(uploader_id);
        setMaterial(new_video);
    }
    public void create_Assignment(){
        //Assignment=[type,problem,max_marks,Status,file,marks_scored]
        ArrayList<String> new_Assignment=new ArrayList<String>();
        Scanner sc= new Scanner(System.in);
        String type="Assignment",problem,max_marks,Status="Open",file="";
        new_Assignment.add(type);
        System.out.print("Enter Problem Statement: ");
        problem=sc.nextLine();
        new_Assignment.add(problem);
        System.out.print("Enter Max Marks: ");
        max_marks=sc.nextLine();
        new_Assignment.add(max_marks);
        new_Assignment.add(Status);
        new_Assignment.add(file);
        new_Assignment.add("0");
        new_Assignment.add("Unknown");
        setAssessment(new_Assignment);
    }
    public void display_Assignment(){
        System.out.println("Assignment: "+assessment.get(1)+ " Max Marks: "+assessment.get(2));
    }
    public void display_Quiz(){
        System.out.println("Question: "+assessment.get(1));
    }
    public void create_Quiz(){
        //Quiz=[type,problem,marks,Status,answer,marks_scored,grader]
        ArrayList<String> new_Quiz=new ArrayList<String>();
        Scanner sc= new Scanner(System.in);
        String type="Quiz",problem,max_marks="1",Status="Open",answer="";
        new_Quiz.add(type);
        System.out.print("Enter Problem Statement: ");
        problem=sc.nextLine();
        new_Quiz.add(problem);
        new_Quiz.add(max_marks);
        new_Quiz.add(Status);
        new_Quiz.add(answer);
        new_Quiz.add("0");
        new_Quiz.add("Unknown");
        setAssessment(new_Quiz);
    }
    public void display_submission_grade(){
        System.out.println("Submission: "+assessment.get(4));
        System.out.println("Marks Scored: "+assessment.get(5));
        System.out.println("Graded by: "+assessment.get(6));
    }
    public void display_submission_ungrade(){
        System.out.println("Submission: "+assessment.get(4));
    }

    @Override
    public String toString() {
        return "Class_Content{" +
                "material=" + material +
                ", assessment=" + assessment +
                '}';
    }
}
