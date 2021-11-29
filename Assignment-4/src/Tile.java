public class Tile {
    private int Tile_no;
    private Toy Tile_Toy;
    public Tile(int Tile_no, Toy toy){
        this.Tile_no=Tile_no;
        this.Tile_Toy=toy;
    }
    public Tile(int Tile_no){
        this.Tile_no=Tile_no;
        this.Tile_Toy= new Toy();
    }
    public Toy giveToyPrize(){
        return Tile_Toy.clone();
    }

    public int getTile_no() {
        return Tile_no;
    }

    public Toy getTile_Toy() {
        return Tile_Toy;
    }

    @Override
    public String toString() {
        return "Tile {" +
                "Tile no=" + Tile_no +
                ", Tile Toy=" + Tile_Toy +
                '}';
    }
}
