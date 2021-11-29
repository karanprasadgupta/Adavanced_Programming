import java.util.Random;

public class Player {
    private int no_of_hops;
    private String energy_Status;
    private Bucket bucket;
    public Player(){
        this.no_of_hops =5;
        this.setEnergy_Status();
        this.bucket=new Bucket();
    }

    public void setEnergy_Status() {
        if(no_of_hops>=4){
            this.energy_Status="Energetic";
        }
        else {
            this.energy_Status="Low-Energy";
        }
    }

    public int getNo_of_hops() {
        return no_of_hops;
    }

    public Bucket getBucket() {
        return bucket;
    }
    public int hop(){
        int hop_value;
        if(energy_Status.equals("Energetic")){
            Random ran = new Random();
            hop_value = ran.nextInt(25) + 1;
        }
        else {
            Random ran = new Random();
            hop_value = ran.nextInt(20) + 1;
        }
        no_of_hops--;
        setEnergy_Status();
        return hop_value;
    }
    public boolean hasHopsLeft(){
        if(no_of_hops<=0){
            return false;
        }
        return true;
    }
}
