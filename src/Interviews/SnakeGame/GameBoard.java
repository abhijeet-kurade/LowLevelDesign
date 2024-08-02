package Interviews.SnakeGame;

import java.util.Random;

public class GameBoard {
    private final int width;
    private final int height;
    private Snake snake;
    private Food food;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        snake = new Snake(new Position(width / 2, height / 2));
        generateFood();
    }

    public void generateFood() {
        Random random = new Random();
        Position foodPosition;
        do {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            foodPosition = new Position(x, y);
        } while (snake.checkCollision(foodPosition));

        food = new Food(foodPosition);
    }

    public void update() {
        snake.move();

        // Check if the snake eats the food
        if (snake.getHead().equals(food.getPosition())) {
            snake.grow();
            generateFood();
        }

        // Check for collision with walls
        Position head = snake.getHead();
        if (head.getX() < 0 || head.getX() >= width || head.getY() < 0 || head.getY() >= height) {
            System.out.println("Game Over! You hit the wall.");
            System.exit(0);
        }

        // Check for collision with itself
        if (snake.getBody().stream().skip(1).anyMatch(segment -> segment.equals(head))) {
            System.out.println("Game Over! You ran into yourself.");
            System.exit(0);
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }
}
