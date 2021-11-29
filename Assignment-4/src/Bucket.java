import java.util.ArrayList;

public class Bucket {
    private ArrayList<Toy> toys= new ArrayList<>();

    public ArrayList<Toy> getToys() {
        return toys;
    }
    public void StoreToy(Toy toy){
        toys.add(toy);
    }
    @Override
    public String toString() {
        return "Toys: "+toys;
    }
    public boolean isEmpty(){
        return toys.isEmpty();
    }
}
