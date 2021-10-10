import java.util.*;

public class Vaccine {
    static ArrayList<Vaccine> vaccine_list= new ArrayList<Vaccine>();
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
        System.out.print("Gap between Doses (in days): ");
        dosage_gap= sc.nextInt();
        System.out.println("Vaccine added succesfully");
        this.display();
    }
    public void display(){
        System.out.println("Vaccine Details: ");
        System.out.println("Vaccine Name: "+name+", Number of Doses: "+no_of_doses+", Gap Between Doses: "+dosage_gap);
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

