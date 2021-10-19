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
        switch (inp_choice) {
            case "1":
                this.Instructor_menu_display();
                break;
            case "2":
                this.Student_menu_display();
                break;
            default:
                return;
        }
        this.main_menu_display();
    }
    private void Instructor_menu_display(){
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
        this.Instructor_menu_selection();
    }
    private void Instructor_menu_selection(){
        // TODO: 19-10-2021  
    }
    private void Student_menu_display(){
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
        this.Student_menu_selection();
    }
    private void Student_menu_selection(){
        // TODO: 19-10-2021  
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
        System.out.println("          BACKPACK IIITD");
        Main BackPack=new Main();
        BackPack.add_course();
        BackPack.main_menu_display();
    }
}
