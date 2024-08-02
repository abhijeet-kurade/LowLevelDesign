package Interviews.SnakeGame;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Position> body;
    private Direction direction;

    public Snake(Position initialPosition) {
        body = new LinkedList<>();
        body.add(initialPosition);
        direction = Direction.RIGHT;
    }

    public void setDirection(Direction newDirection) {
        // Prevent the snake from reversing
        if ((this.direction == Direction.UP && newDirection != Direction.DOWN) ||
                (this.direction == Direction.DOWN && newDirection != Direction.UP) ||
                (this.direction == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (this.direction == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.direction = newDirection;
        }
    }

    public void move() {
        Position head = body.getFirst();
        Position newHead = null;

        switch (direction) {
            case UP -> newHead = new Position(head.getX(), head.getY() - 1);
            case DOWN -> newHead = new Position(head.getX(), head.getY() + 1);
            case LEFT -> newHead = new Position(head.getX() - 1, head.getY());
            case RIGHT -> newHead = new Position(head.getX() + 1, head.getY());
        }

        body.addFirst(newHead);
        body.removeLast();
    }

    public void grow() {
        // Add a new segment at the end
        body.addLast(body.getLast());
    }

    public boolean checkCollision(Position position) {
        return body.contains(position);
    }

    public Position getHead() {
        return body.getFirst();
    }

    public List<Position> getBody() {
        return body;
    }
}
