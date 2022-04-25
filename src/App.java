import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int numOfPlayers = 0;
        List<Player> playerList = new ArrayList<>();
        
        System.out.println("Enter number of players: ");
        numOfPlayers = sc.nextInt();

        for(int i = 0; i < numOfPlayers; i++){
            sc.reset();
            sc.nextLine();
            System.out.println("Enter name of player "+ (i + 1) + ": ");
            String playerName = sc.nextLine();

            Player player = new Player(playerName);

            playerList.add(player);
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < numOfPlayers; j++){
                playerList.get(j).play();
            }
        }

        Player winner = Collections.max(playerList, Comparator.comparing(p -> p.getScore()));

        System.out.println("The winner is: " + winner.getName() + "\nScore: " + winner.getScore());

        sc.close();
    }
}

