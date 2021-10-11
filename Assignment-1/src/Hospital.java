import java.util.*;

public class Hospital {
    private static ArrayList<Hospital> hospital_list =new ArrayList<Hospital>();
    private String name;
    private String Pincode;
    private int hosptial_uid;
    private static ArrayList<Integer> hospital_id_list=new ArrayList<Integer>();
    private ArrayList<Slot> slots=new ArrayList<Slot>();

    public Hospital(){
        hospital_list.add(this);
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public String setPincode() {
        Scanner sc = new Scanner(System.in);
        int l;
        while(true){
            System.out.print("Pincode");
            String uid=sc.nextLine();
            if (uid == null || uid.length()!=6) {
                System.out.println("Enter Valid Pincode");
                continue;
            }
            try {
                l = Integer.parseInt(uid);
            } catch (NumberFormatException nfe) {
                System.out.println("Enter Valid Pincode");
                continue;
            }
            if (l<0){
                System.out.println("Enter Valid Pincode");
                continue;
            }
            return uid;
        }
    }

    public String getPincode() {
        return Pincode;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Hospital> getHospital_list() {
        return hospital_list;
    }

    public int getHosptial_uid() {
        return hosptial_uid;
    }

    public int setHosptial_uid() {
        while (true){
            int n = 100000 + new Random().nextInt(900000);
            if(hospital_id_list.contains(n)){
                continue;
            }
            else {
                return n;
            }
        }
    }
    public void display(){
        System.out.println("Hospital Details: ");
        System.out.println("Hospital Name: "+name+", Pincode: "+Pincode+", Unique ID: "+hosptial_uid);
    }

    public void Register_Hospital(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Hospital Name: ");
        name= sc.nextLine();
        Pincode=setPincode();
        hosptial_uid=setHosptial_uid();
        System.out.println("Hospital Added Successfully");
        this.display();
    }
    public static void add_slots(){
        boolean found=false;
        Scanner sc=new Scanner(System.in);
        int id= sc.nextInt();
        for(Hospital hospital:hospital_list){
            if(hospital.hosptial_uid==id){
                found=true;
                System.out.print("Enter number of Slots to be added: ");
                int i=0;
                int no_of_slots= sc.nextInt();
                while (i<no_of_slots){
                    hospital.add_new_slot(id);
                    i++;
                }
            }
        }
        if(!found){
            System.out.println("No hospital found with entered ID. Try Again!");
        }
    }
    public static void all_slots_for_hospital(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Hospital ID: ");
        int HID= sc.nextInt();
        if(hospital_id_list.contains(HID)){
            for(Hospital hospital:hospital_list){
                if(hospital.getHosptial_uid()==HID){
                    hospital.display_all_slot();
                    break;
                }
            }
        }
        else {
            System.out.println("Hospital Not Found");
        }
    }
    public static void display_all_hospital_slots(){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Hospital ID: ");
        int Id= sc.nextInt();
        for (Hospital hospital:Hospital.getHospital_list()){
            if(hospital.getHosptial_uid()==Id){
                hospital.display_all_slot();
                break;
            }
        }
    }
    public void display_all_slot(){
        if(slots.size()==0){
            System.out.println("No slot found");
        }
        else
            System.out.println("Availabe Slots: ");
        for (Slot slot:slots){
            slot.display();
        }
    }
    public void add_new_slot(int hosptial_id){
        Slot new_slot =new Slot();
        new_slot.create_slot();
        if (new_slot.isValid_slot()){
            slots.add(new_slot);
            System.out.println("Slot added by Hospital "+hosptial_id+" for Day: "+new_slot.getDay_no()+" Available Quantity: "+new_slot.getQty()+" of Vaccine "+new_slot.getVaccine().getName());
        }
    }
    public static int find_vaccine_by_area(String pcode){
        ArrayList<Integer> search_id_list=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);
        int choice=-1;
        boolean found=false;
        for (Hospital hospital:getHospital_list()){
            if(hospital.getPincode().equals(pcode)){
                found=true;
                System.out.println("Hospital ID: "+hospital.getHosptial_uid()+" Name: "+hospital.getName());
                search_id_list.add(hospital.getHosptial_uid());
            }
        }
        if (!found){
            System.out.println("No Hospital Found");
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
    public void update_slots(Slot slot){
        for (Slot sl:slots){
            if (sl.equals(slot)){
                sl.book();
                if (sl.getQty()==0){
                    slots.remove(sl);
                }
                break;
            }
        }
    }
}
