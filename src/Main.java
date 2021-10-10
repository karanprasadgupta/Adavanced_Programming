public class Main {
    public static void sf(Vaccine vax){
        System.out.println("vv");
        System.out.println(vax.getNo_of_doses());
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!!!");
        Vaccine covax= new Vaccine();
        covax.add_vaccine();
        for (Vaccine covi: Vaccine.vaccine_list){
            covi.display();
            if (covi.getName().equals("covi")){
                System.out.println("found");
                //sf(Vaccine("covi"));
            }
            else{
                System.out.println("not found");
            }
        }

        System.out.println(covax.getDosage_gap());
    }
}
