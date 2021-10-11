import java.util.*;

public class Citizen {
    private static ArrayList<Citizen> Citizen_list= new ArrayList<Citizen>();
    private String name;
    private int age;
    private String Unique_Id;
    private String Vaccination_Status;
    private int dose_intake=0;
    private Vaccine vaccine_taken;
    private int last_dosage_day;


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

    public void setAge(int age) {
        this.age = age;
    }

    public int getLast_dosage_day() {
        return last_dosage_day;
    }

    public void setLast_dosage_day(int last_dosage_day) {
        this.last_dosage_day = last_dosage_day;
    }

    public String getUnique_Id() {
        return Unique_Id;
    }
    public String getVaccination_Status() {
        return Vaccination_Status;
    }

    public void setVaccine_taken(Vaccine vaccine_taken) {
        this.vaccine_taken = vaccine_taken;
    }

    public int getDose_intake() {
        return dose_intake;
    }

    public Vaccine getVaccine_taken() {
        return vaccine_taken;
    }

    public void setVaccination_Status(int dose_intake) {
        Vaccination_Status = "pv";
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
    public static void book_slot(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Citizen's Unique ID: ");
        String c_uid=sc.nextLine();
        boolean found=false;
        for (Citizen citizen:Citizen_list){
            if(citizen.getUnique_Id().equals(c_uid)){
                System.out.println("1. Search by area\n" + "2. Search by Vaccine\n" + "3. Exit");
                System.out.print("Enter Choice(3 or any other no. to exit): ");
                int c=sc.nextInt();
                if (c==1){
                    System.out.print("Enter Pincode: ");
                    String PinCode=sc.nextLine();
                    int choice=Hospital.find_vaccine_by_area(PinCode);
                    if(choice==-1){
                        return;
                    }
                    else {
                        citizen.book_slot_for_citizen(choice);
                    }
                }
                else if (c==2){
                    System.out.print("Enter vaccine name: ");
                    String vax_name=sc.nextLine();
                    //Vaccine vaccine;

                    int choice=Vaccine.find_hospital_by_vaccine(vax_name);
                    if(choice==-1){
                        return;
                    }
                    else {
                        for (Vaccine vaccine: Vaccine.getVaccine_list()){
                            if(vaccine.getName().equals(vax_name)){
                                citizen.book_slot_for_citizen(choice,vaccine);
                                break;
                            }
                        }

                    }
                }
                else {
                    return;
                }
                break;
            }
        }
        if (!found){
            System.out.println("Citizen not found");
        }
    }
    private void book_slot_for_citizen(int id){
        Scanner sc=new Scanner(System.in);
        for (Hospital hospital:Hospital.getHospital_list()){
            if (hospital.getHosptial_uid()==id){
                //ArrayList<Slot> slots=new ArrayList<Slot>();
                if(getVaccination_Status().equals("REGISTERED")){
                    //int slot_counter_for_citizen=0;
                    for (int i=0;i<hospital.getSlots().size();i++){
                        System.out.print(i+"-> ");
                        hospital.getSlots().get(i).display();
                    }
                    System.out.print("Enter choice: ");
                    int choice= sc.nextInt();
                    while (choice<0 || choice>hospital.getSlots().size()){
                        System.out.print("enter valid choice: ");
                        choice= sc.nextInt();
                    }
                    setVaccine_taken(hospital.getSlots().get(choice).getVaccine());
                    hospital.update_slots(hospital.getSlots().get(choice));
                    setLast_dosage_day(hospital.getSlots().get(choice).getDay_no());
                    dose_intake++;
                    setVaccination_Status(dose_intake);

                }
                else if (getVaccination_Status().equals("PARTIALLY VACCINATED")){
                    book_slot_for_citizen(id,getVaccine_taken());
                }
                else if (getVaccination_Status().equals("FULLY VACCINATED")){
                    System.out.println("cannot find any slot : Citizen is already fully vaccinated");
                }
                break;
            }
        }
    }

    private void book_slot_for_citizen(int id,Vaccine vaccine){
        Scanner sc=new Scanner(System.in);
        for (Hospital hospital:Hospital.getHospital_list()){
            if (hospital.getHosptial_uid()==id){
                ArrayList<Slot> slots=new ArrayList<Slot>();
                if(getVaccination_Status().equals("REGISTERED")){
                    int slot_counter_for_citizen=0;
                    for (int i=0;i<hospital.getSlots().size();i++){
                        if (hospital.getSlots().get(i).getVaccine().equals(vaccine)){
                            System.out.print(slot_counter_for_citizen+"-> ");
                            hospital.getSlots().get(i).display();
                            slots.add(hospital.getSlots().get(i));
                            slot_counter_for_citizen++;
                        }
                    }
                    System.out.print("Enter choice: ");
                    int choice= sc.nextInt();
                    while (choice<0 || choice>slots.size()){
                        System.out.print("enter valid choice: ");
                        choice= sc.nextInt();
                    }
                    setVaccine_taken(hospital.getSlots().get(choice).getVaccine());
                    hospital.update_slots(slots.get(choice));
                    setLast_dosage_day(hospital.getSlots().get(choice).getDay_no());
                    dose_intake++;
                    setVaccination_Status(dose_intake);

                }
                else if (getVaccination_Status().equals("PARTIALLY VACCINATED")){
                    if(!getVaccine_taken().equals(vaccine)){
                        System.out.println("You have already taken another vaccine, no slots found for you");
                    }
                    else {
                        int slot_counter_for_citizen=0;
                        for (int i=0;i<hospital.getSlots().size();i++){
                            if (hospital.getSlots().get(i).getVaccine().equals(vaccine)){
                                //here
                                System.out.print(slot_counter_for_citizen+"-> ");
                                hospital.getSlots().get(i).display();
                                slots.add(hospital.getSlots().get(i));
                                slot_counter_for_citizen++;
                            }
                        }
                        System.out.print("Enter choice: ");
                        int choice= sc.nextInt();
                        while (choice<0 || choice>slots.size()){
                            System.out.print("enter valid choice: ");
                            choice= sc.nextInt();
                        }
                        setVaccine_taken(hospital.getSlots().get(choice).getVaccine());
                        hospital.update_slots(slots.get(choice));
                        setLast_dosage_day(hospital.getSlots().get(choice).getDay_no());
                        dose_intake++;
                        setVaccination_Status(dose_intake);
                    }
                }
                else if (getVaccination_Status().equals("FULLY VACCINATED")){
                    System.out.println("cannot find any slot : Citizen is already fully vaccinated");
                }
                break;
            }
        }
    }
}
