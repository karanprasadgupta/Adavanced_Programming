import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Course> Course_list=new ArrayList<Course>();
    private Course new_course;
    //not implementing other functions since those are not part of assignment
    public void main_menu_display(){
        System.out.println("""
                -----------------------------------
                Welcome to Backpack, Select your role for the course:
                        1. Enter as instructor
                        2. Enter as student
                        3. Exit
                -----------------------------------""");
        this.main_menu_selection();
    }

    private void main_menu_selection(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Choice(input 3 or other value to exit):");
        String inp_choice=sc.nextLine();
        int i=0;
        Course course=Course_list.get(0);//can be modified for multiple courses
        switch (inp_choice) {

            case "1":
                System.out.println("Instructors: ");
                for (Instructor instructor:course.getInstructors()){
                    i++;
                    System.out.println(i+"- "+instructor.getId());
                }
                System.out.print("Choose Id:");
                i= sc.nextInt();
                this.Instructor_menu_display(course.getInstructors().get(i));
                break;
            case "2":
                System.out.println("Students: ");
                i=0;
                for (Student student:course.getStudents()){
                    i++;
                    System.out.println(i+"- "+student.getId());
                }
                System.out.print("Choose Id:");
                i= sc.nextInt();
                this.Student_menu_display(course.getStudents().get(i));
                break;
            default:
                return;
        }
        this.main_menu_display();
    }
    private void Instructor_menu_display(Instructor instructor){
        System.out.println("Welcome "+ instructor.getId());
        System.out.println("""
                -----------------------------------
                INSTRUCTOR MENU
                       1. Add class material
                       2. Add assessments
                       3. View lecture materials
                       4. View assessments
                       5. Grade assessments
                       6. Close assessment
                       7. View comments
                       8. Add comments
                       9. Logout
                -----------------------------------""");
        this.Instructor_menu_selection(instructor);
    }
    private void Instructor_menu_selection(Instructor instructor){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Choice(input 9 or other value to logout):");
        String inp_choice=sc.nextLine();
        switch (inp_choice) {
            case "1":
                instructor.add_class_material();
                break;
            case "2":
                instructor.add_assessments();
                break;
            case "3":
                instructor.view_lecture_material(instructor.getCourse_taught().getMaterials());
                break;
            case "4":
                instructor.view_assessments(instructor.getCourse_taught().getAssessments());
                break;
            case "5":
                instructor.grade_assessments();
                break;
            case "6":
                instructor.close_assessments();
                break;
            case "7":
                instructor.view_comments();
                break;
            case "8":
                instructor.add_comments();
                break;
            default:
                System.out.println("Logged Out Successfully");
                return;
        }
        this.Instructor_menu_display(instructor);
    }
    private void Student_menu_display(Student student){
        System.out.println("Welcome "+student.getId());
        System.out.println("""
                -----------------------------------
                STUDENT MENU
                        1. View lecture materials
                        2. View assessments
                        3. Submit assessment
                        4. View grades
                        5. View comments
                        6. Add comments
                        7. Logout
                -----------------------------------""");
        this.Student_menu_selection(student);
    }
    private void Student_menu_selection(Student student){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Choice(input 9 or other value to logout):");
        String inp_choice=sc.nextLine();
        switch (inp_choice) {
            case "1":
                student.view_lecture_material(student.getCourse_enrolled().getMaterials());
                break;
            case "2":
                student.view_assessments(student.getCourse_enrolled().getAssessments());
                break;
            case "3":
                student.submit_assessments();
                break;
            case "4":
                student.view_grades();
                break;
            case "5":
                student.view_comments();
                break;
            case "6":
                student.add_comments();
                break;
            default:
                System.out.println("Logged Out Successfully");
                return;
        }
        this.Student_menu_display(student);
    }
    public void add_course(){
        //This can be modified as per requirement, but here we are using it to generate the sample test case with 2 instructors and 3 students for the course
        new_course=new Course("CSE201-Advanced Programming");
        new_course.add_Instructor("L0");
        new_course.add_Instructor("L1");
        new_course.add_students("S0");
        new_course.add_students("S1");
        new_course.add_students("S2");
        Course_list.add(new_course);
        System.out.println("New Course added to IIITD BackPack");
        System.out.println("Course Details: ");
        System.out.println(new_course);
    }
    public static void main(String[] args) {
        //complete
        System.out.println("          BACKPACK IIITD");
        Main BackPack=new Main();
        BackPack.add_course();
        BackPack.main_menu_display();
    }
}
