public class Toy implements Cloneable{
    private final String toy_name;
    private final int toy_price;
    public Toy(){
        this.toy_name="Teddy";
        this.toy_price=100;
    }
    public Toy(String name,int price ){
        this.toy_price=price;
        this.toy_name=name;
    }
    public String getToy_name() {
        return toy_name;
    }

    public int getToy_price() {
        return toy_price;
    }
    @Override
    public Toy clone(){
        try{
            Toy toy_clone= (Toy) super.clone();
            return toy_clone;
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }
    @Override
    public String toString() {
        return toy_name;
    }
}
