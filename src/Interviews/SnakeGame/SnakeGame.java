package Interviews.SnakeGame;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGame {
    private GameBoard gameBoard;
    private Timer timer;

    public SnakeGame(int width, int height) {
        gameBoard = new GameBoard(width, height);
        timer = new Timer();
    }

    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameBoard.update();
                printBoard();
            }
        }, 0, 500); // Update the game every 500ms
    }

    private void printBoard() {
        int width = gameBoard.getSnake().getBody().get(0).getX();
        int height = gameBoard.getSnake().getBody().get(0).getY();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Position position = new Position(x, y);

                if (gameBoard.getSnake().getHead().equals(position)) {
                    System.out.print("S");
                } else if (gameBoard.getFood().getPosition().equals(position)) {
                    System.out.print("F");
                } else if (gameBoard.getSnake().getBody().contains(position)) {
                    System.out.print("s");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SnakeGame game = new SnakeGame(20, 20);

        game.start();

        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "w" -> game.gameBoard.getSnake().setDirection(Direction.UP);
                case "s" -> game.gameBoard.getSnake().setDirection(Direction.DOWN);
                case "a" -> game.gameBoard.getSnake().setDirection(Direction.LEFT);
                case "d" -> game.gameBoard.getSnake().setDirection(Direction.RIGHT);
            }
        }
    }
}
