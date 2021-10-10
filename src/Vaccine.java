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
}

