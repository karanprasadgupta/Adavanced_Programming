import java.util.Scanner;

public class Main {
    public static void menu_display(){
        System.out.println("""
                -----------------------------------
                1. Add Vaccine
                2. Register Hospital
                3. Register Citizen
                4. Add Slot for Vaccination
                5. Book Slot for Vaccination
                6. List all slots for a hospital
                7. Check Vaccination Status
                8. Exit
                -----------------------------------""");
        menu_selection();
    }
    public static void menu_selection(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Choice(input 8 or other value to exit):");
        String inp_choice=sc.nextLine();
        switch (inp_choice) {
            case "1":
                Vaccine vaccine = new Vaccine();
                vaccine.add_vaccine();
                break;
            case "2":
                Hospital hospital = new Hospital();
                hospital.Register_Hospital();
                break;
            case "3":
                Citizen citizen = new Citizen();
                citizen.add_Citizen();
                break;
            case "4":
                Hospital.add_slots();
                break;
            case "5":
                Citizen.book_slot();
                break;
            case "6":
                Hospital.all_slots_for_hospital();
                break;
            case "7":
                Citizen.check_vaccination_status();
                break;
            default:
                return;
        }
        menu_display();
    }
    public static void main(String[] args) {
        System.out.println("CoWin Portal initialized....");
        System.out.println("-----------------------------------");
        menu_display();
    }
}
