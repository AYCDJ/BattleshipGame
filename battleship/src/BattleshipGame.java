import java.util.Scanner;

public class BattleshipGame {
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public BattleshipGame() {
        player1 = new Player();
        player2 = new Player();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Player 1, place your ships.");
        setupShips(player1);
        System.out.println("Player 2, place your ships.");
        setupShips(player2);

        boolean gameOver = false;
        Player currentPlayer = player1;
        Player opponent = player2;

        while (!gameOver) {
            System.out.println("Current Player's turn:");
            currentPlayer.getBoard().displayBoard();
            System.out.print("Enter attack coordinates (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String result = currentPlayer.attack(opponent, x, y);
            System.out.println(result);

            // Swap turns
            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }
    }

    public void setupShips(Player player) {
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter ship position (x y) and orientation (0 for horizontal, 1 for vertical): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int orientation = scanner.nextInt();

            boolean placed = player.placeShip(x, y, i, orientation == 0);
            if (!placed) {
                System.out.println("Invalid placement. Try again.");
                i--;
            }
        }
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}
