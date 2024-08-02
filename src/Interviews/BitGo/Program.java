package Interviews.BitGo;
import java.util.*;
import java.io.*;

class Program {


    public static void main (String[] args) {
        //System.out.print(Foo("hello"));
        System.out.println("Started the game");

        int[][] snakes = {{10, 3}, {54, 20}, {94, 54}, {93, 45}, {86, 36}};
        int[][] ladders = {{22, 32}, {43, 65}};
        String[] players = {"A", "B", "C"};

        GameService service = new GameService();
        for(int[] snake : snakes){
            service.addSnake(snake[0], snake[1]);
        }

        for(int[] ladder : ladders){
            service.addLadder(ladder[0], ladder[1]);
        }

        for(String p : players){
            service.addPlayer(p);
        }

        service.createGame();
        while(true){
            boolean result = service.playMove();

            if(result){
                break;
            }
        }

    }

}

class Dice{

    Random rand = new Random();

    public int roll(){

        return rand.nextInt(6) + 1;
    }
}

class GameService{

    List<Player> players;
    List<Snake> snakes;
    List<Ladder> ladders;
    Game game;
    Dice dice;

    public GameService(){
        this.players = new ArrayList<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.dice = new Dice();
        this.game = null;
    }

    public boolean playMove(){
        int moves = dice.roll();
        boolean result = game.playMove(moves);
        return result;
    }

    public void createGame(){
        Board board = new Board(100);
        for(Snake snake : snakes){
            board.addPortal(snake);
        }

        for(Ladder ladder : ladders){
            board.addPortal(ladder);
        }

        this.game = new Game(board, players, 0);
    }

    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public void addSnake(int head, int tail){
        snakes.add(new Snake(head, tail));
    }

    public void addLadder(int start, int end){
        ladders.add(new Ladder(start, end));
    }
}

abstract class Portal{
    int start;
    int end;
    public Portal(int start, int end){
        this.start = start;
        this.end = end;
    }

    public boolean isNext(){
        return start != end;
    }

    public int next(){
        return end;
    }
}
class Ladder extends Portal{
    public Ladder(int start, int end){
        super(start, end);
    }
}

class Snake extends Portal{

    public Snake(int head, int tail){
        super(head, tail);
    }
}

class BlackHole extends Portal{

    Random rand;

    public BlackHole(int start) {
        super(start, -1);
        this.rand = new Random();
    }

    @Override
    public int next() {
        return this.rand.nextInt(this.start, 101);
    }
}

class Cell{
    int number;
    Portal portal;

    public Cell(int number){
        this.number = number;
    }

    public boolean isPortal(){
        return portal != null;
    }

}


class Board {
    List<Cell> cells;

    public Board(int cellsCount){
        this.cells = new ArrayList<>();
        for(int i=0; i<=cellsCount; i++){
            cells.add(new Cell(i));
        }
    }

    public void addPortal(Portal portal) {
        int start = portal.start;
        Cell cell = cells.get(start);
        cell.portal = portal;
    }
}

class Game{
    int id;
    public List<Player> players;
    int currentPlayer;
    Board board;

    public Game(Board board, List<Player> players, int currentPlayer){
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
    }

    public boolean playMove(int move){
        Player player = players.get(currentPlayer);
        int curr = player.position;
        int newPostion = curr + move;

        if(newPostion > 100) {
            currentPlayer = (currentPlayer + 1) % players.size();
            return false;
        }

        Cell cell = board.cells.get(newPostion);

        while(cell.isPortal() && cell.portal.isNext()){
            newPostion = cell.portal.next();
            cell = board.cells.get(newPostion);
        }

        System.out.println(player.name +" rolled "+ move + " and moved from "+curr + " to "+ newPostion);
        if(newPostion == 100){
            System.out.println(player.name + " wins the game");
            return true;
        }

        player.position = newPostion;
        currentPlayer = (currentPlayer + 1) % players.size();
        return false;
    }

}

class Player{
    public String name;
    public int position;

    public Player(String name){
        this.name = name;
        this.position = 0;
    }
}

/*
Snakes -> two pints
Ladder -> start piont and end point

Player -> name


print all the moves
current player -> 1- 6 dice roll initial and final position based on ther


wining

Rule :
100 cells
dice -> 6 sided
initial position is 0


Compute/Service
 - Main

Player
 - name

Game
  - List<Player> players
  - current player : int
  - Board

  play move

  is there winner

Board
  List<Cell> cells

Cell
   - number
   - Snake
   - Ladder

Snake
  - head
  - tail

Ladder
  - start
  - end

Dice
  - roll dice



*/