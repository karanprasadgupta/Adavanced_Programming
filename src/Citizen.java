import java.util.*;

public class Citizen {
    private static ArrayList<Citizen> Citizen_list= new ArrayList<Citizen>();
    private String name;
    private int age;
    private String Unique_Id;
    private String Vaccination_Status;

    public Citizen(){
        Citizen_list.add(this);
    }

    public static ArrayList<Citizen> getCitizen_list() {
        return Citizen_list;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getUnique_Id() {
        return Unique_Id;
    }
    public String getVaccination_Status() {
        return Vaccination_Status;
    }
    public void display(){
        System.out.println("Citizen Details: ");
        System.out.println("Citizen Name: "+name+", Age: "+age+", Unique ID: "+Unique_Id);
    }
    private String setUnique_Id(){
        Scanner sc = new Scanner(System.in);
        long l;
        while(true){
            System.out.print("Unique ID");
            String uid=sc.nextLine();
            if (uid == null || uid.length()!=12) {
                System.out.println("Enter Valid ID");
                continue;
            }
            try {
                l = Long.parseLong(uid);
            } catch (NumberFormatException nfe) {
                System.out.println("Enter Valid ID");
                continue;
            }
            if (l<0){
                System.out.println("Enter Valid ID");
                continue;
            }
            for(Citizen citizen: Citizen_list){
                if(citizen.getUnique_Id().equals(uid)){
                    System.out.println("Citizen with given UID already exists");
                    return "-1";
                }
            }
            return uid;
        }
    }
    private void remove_Citizen(){
        Citizen_list.remove(this);
    }
    public void add_Citizen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Citizen Name: ");
        name=sc.nextLine();
        System.out.print("Age: ");
        age=sc.nextInt();
        while (age<1){
            System.out.println("Invalid Age!!!");
            age= sc.nextInt();
        }
        Unique_Id = setUnique_Id();
        if(age<18){
            System.out.println("Only above 18 are allowed");
            remove_Citizen();
            return;
        }
        if (Unique_Id.equals("-1")){
            remove_Citizen();
        }
        Vaccination_Status="REGISTERED";
        this.display();
    }
}
