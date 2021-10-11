import java.util.*;

public class Slot {
    private int day_no;
    private int qty;
    private Vaccine vaccine;
    private boolean valid_slot=true;

    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }

    public int getDay_no() {
        return day_no;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isValid_slot() {
        return valid_slot;
    }

    public void setVaccine() {
        Scanner sc = new Scanner(System.in);
        if(Vaccine.getVaccine_list().size()==0){
            System.out.println("No Vaccines Available for Slot creation");
            valid_slot=false;
            return;
        }
        System.out.println("Select Vaccine");
        for (int i=0;i<Vaccine.getVaccine_list().size();i++){
            System.out.println((i+1)+". "+Vaccine.getVaccine_list().get(i).getName());
        }
        System.out.print("Enter Choice: ");
        int choice= sc.nextInt();
        while(choice>Vaccine.getVaccine_list().size() && choice<1){
            System.out.print("Enter Valid Choice: ");
            choice= sc.nextInt();
        }
        this.vaccine = Vaccine.getVaccine_list().get(choice-1);

    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void create_slot(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Day Number: ");
        setDay_no(sc.nextInt());
        System.out.print("Enter Quantity: ");
        int qt= sc.nextInt();
        while (qt<=0){
            System.out.println("Quantity must be greater than 0 for new slot creation");
            qt= sc.nextInt();
        }
        setQty(qt);
        setVaccine();
    }
    public void display(){
        System.out.println("Day: "+day_no+" Available Quantity: "+qty+" Vaccine: "+vaccine.getName());
    }
    public void book(){
        setQty(getQty()-1);
    }

}
