import java.util.*;

public class Vaccine {
    private static ArrayList<Vaccine> vaccine_list= new ArrayList<Vaccine>();
    private String name;
    private int no_of_doses;
    private int dosage_gap;

    public Vaccine(){
        vaccine_list.add(this);
    }
    public void add_vaccine(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vaccine Name: ");
        name=sc.nextLine();
        System.out.print("Number of Doses: ");
        no_of_doses=sc.nextInt();
        while (no_of_doses<1){
            System.out.println("No. of doses should be atleast 1");
            System.out.print("No. of doses: ");
            no_of_doses= sc.nextInt();
        }
        if(no_of_doses==1){
            dosage_gap=0;
        }
        else {
            System.out.print("Gap between Doses (in days): ");
            dosage_gap= sc.nextInt();
        }
        System.out.println("Vaccine added succesfully");
        this.display();
    }
    public void display(){
        System.out.println("Vaccine Details: ");
        System.out.println("Vaccine Name: "+name+", Number of Doses: "+no_of_doses+", Gap Between Doses: "+dosage_gap);
    }
    public static ArrayList<Vaccine> getVaccine_list(){
        return vaccine_list;
    }
    public String getName(){
        return name;
    }
    public int getDosage_gap() {
        return dosage_gap;
    }
    public int getNo_of_doses(){
        return no_of_doses;
    }
    public static int find_hospital_by_vaccine(String name){
        ArrayList<Integer> search_id_list=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);
        int choice=-1;
        boolean found=false;
        for (Vaccine vaccine: getVaccine_list()){
            if(vaccine.getName().equals(name)){
                found=true;
                for (Hospital hospital:Hospital.getHospital_list()){
                    if(hospital.getSlots().size()!=0){
                        for(Slot slot: hospital.getSlots()){
                            if(slot.getVaccine().getName().equals(name)){
                                found=true;
                                System.out.println("Hospital ID: "+hospital.getHosptial_uid()+" Name: "+hospital.getName());
                                search_id_list.add(hospital.getHosptial_uid());
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (!found){
            System.out.println("No Such Vaccine Found");
        }
        else {
            System.out.print("Enter Hospital from above list: ");
            choice=sc.nextInt();
            while(!search_id_list.contains(choice)){
                System.out.print("Re-enter hospital ID from above listed IDs': ");
                choice=sc.nextInt();
            }
        }
        return choice;
    }
}

