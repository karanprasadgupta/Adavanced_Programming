import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Game");
        System.out.println("Hit Enter to initialize the Game");
        Scanner sc= new Scanner(System.in);
        sc.nextLine();
        Game new_game= new Game();
        System.out.println("Game is ready");
        new_game.StartGame();
    }
}
