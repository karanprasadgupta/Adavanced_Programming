import java.util.*;

public class Game {
    private ArrayList<Object> Tile_Carpet= new ArrayList<Object>();
    private ArrayList<Toy> toySet=new ArrayList<Toy>();
    private int round_no;
    private Player p1;
    public Game(){
        this.round_no=1;
        this.p1=new Player();
        this.CreateToySet();
        this.setTileCarpet();
    }
    private void CreateToySet(){
        //setting this as private since game creating its own toys we are not creating or adding toys toys defined by user
        toySet.add(new Toy("Mickey Mouse",500));//1
        toySet.add(new Toy("Jerry",400));//2
        toySet.add(new Toy("Doraemon",600));//3
        toySet.add(new Toy("Pooh",450));//4
        toySet.add(new Toy("SpongeBob",600));//5
        toySet.add(new Toy("Patrick",500));//6
        toySet.add(new Toy("ScoobyDoo",700));//7
        toySet.add(new Toy("Donald Duck",450));//8
        toySet.add(new Toy("Goofy",550));//9
        toySet.add(new Toy("Tom",450));//10
        toySet.add(new Toy("Minion",300));//11
        toySet.add(new Toy("Popeye",300));//12
        toySet.add(new Toy("Panda",350));//13
        toySet.add(new Toy("Pickachu",350));//14
        toySet.add(new Toy("Shinchan",300));//15
        toySet.add(new Toy("Pluto",350));//16
        toySet.add(new Toy("Noddy",300));//17
        toySet.add(new Toy("Tweety",400));//18
        toySet.add(new Toy("Droopy",500));//19
        toySet.add(new Toy("Minnie Mouse",500));//20
    }
    private void setTileCarpet(){
        Collections.shuffle(toySet);
        for (int i=0;i<20;i++){
            try {
                Tile tile = new Tile(i + 1, toySet.get(i));
                Tile_Carpet.add(tile);
            }
            catch (IndexOutOfBoundsException e){
                Tile_Carpet.add(new Tile(i+1));
            }
        }
        for (int i=20;i<25;i++){
            //setting muddy puddles for tile 20-25;//max jump is 25
            //using string to represent muddy puddles
            Tile_Carpet.add("Muddy Puddle");
        }
    }
    public void StartGame(){
        while (p1.hasHopsLeft()){
            play();
        }
        System.out.println("Game Over");
        if (p1.getBucket().isEmpty()){
            System.out.println("Better luck next time, you didn't win any toy");
        }
        else {
            System.out.println("Soft toys won by you are: ");
            System.out.println(p1.getBucket());
        }
    }
    private void play(){
        System.out.println("Round: " +round_no+" Hit Enter to Hop");
        round_no++;
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        int x= p1.hop()-1;
        if(Tile_Carpet.get(x) instanceof Tile){

            Tile landed_tile=((Tile) Tile_Carpet.get(x));
            if((landed_tile.getTile_no())%2==0){
                System.out.println("You landed on tile: "+landed_tile.getTile_no());
                Toy winning= landed_tile.getTile_Toy().clone();
                p1.getBucket().StoreToy(winning);
                System.out.println("You won a "+winning.getToy_name()+" soft toy");
            }
            else {
                System.out.println("You landed on tile: "+landed_tile.getTile_no());
                boolean answered_correctly=AskQuestion();
                if (answered_correctly){
                    Toy winning= landed_tile.getTile_Toy().clone();
                    p1.getBucket().StoreToy(winning);
                    System.out.println("You Entered Correct Answer");
                    System.out.println("You won a "+winning.getToy_name()+" soft toy");
                }
                else {
                    System.out.println("You Entered Incorrect Answer");
                    System.out.println("You did not win any soft toy");
                }
            }
        }
        else{
            System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
        }
    }
    private boolean AskQuestion(){
        //true-string , false-int;
        boolean done = false;
        boolean response=false;
        while(!done) {
            System.out.println("Question answer round. Integer or strings?");
            try {
                response=getQuestionChoice();
                done = true;
            }
            catch(InvalidChoiceException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }
        }
        Scanner sc=new Scanner(System.in);
        if(response){
            String Str1=generateRandStr4();
            String Str2=generateRandStr4();
            System.out.println("Calculate the concatenation of strings "+Str1+" and "+Str2);
            String inp="";
            inp=sc.nextLine();
            GenericCalculator<String> StringCalculator=new GenericCalculator<String>();
            String result= (String) StringCalculator.calculateResult(Str1,Str2);
            if(result.equals(inp)){
                return true;
            }
        }
        else {
            int int1=generateRandomInt();
            int int2=generateRandomIntnonZero();
            System.out.println("Calculate the result of "+int1+" divided by "+int2);
            int inp;
            try {
                inp= sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("You entered Invalid Value");
                return false;
            }
            catch (NullPointerException n){
                System.out.println("You lost your chance by entering null Value");
                return false;
            }
            GenericCalculator<Integer> integerCalculator=new GenericCalculator<Integer>();
            if(String.valueOf(inp).equals(integerCalculator.calculateResult(int1,int2))){
                return true;
            }
        }
        return false;
    }
    private boolean getQuestionChoice() throws InvalidChoiceException{
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        if(input.equalsIgnoreCase("string") || input.equalsIgnoreCase("strings")){
            return true;
        }
        else if(input.equalsIgnoreCase("integer") || input.equalsIgnoreCase("integers")){
            return false;
        }
        else {
            throw new InvalidChoiceException("Input must be a string named String or Integer");
        }
    }
    private int generateRandomInt(){
        Random rand1 = new Random();
        int random = rand1.nextInt(30000)-10000;
        return random;
    }
    private int generateRandomIntnonZero(){
        while (true){
            int rand_val=generateRandomInt();
            if(rand_val!=0){
                return rand_val;
            }
        }
    }
    private String generateRandStr4(){
        String ret="";
        String AlphaNumString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        for (int i = 0; i < 4; i++) {
            int index = (int)(AlphaNumString.length() * Math.random());
            ret+=AlphaNumString.charAt(index);
        }
        return ret;
    }
}
