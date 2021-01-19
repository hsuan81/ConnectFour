import java.util.Random;
import java.util.Arrays;

public class ComputerPlayer extends Player{
  private int row;
  private int col;
  private Random r;

  public ComputerPlayer(char token, int row, int col){
    // computer player need to know the setting of the game
    super(token);
    this.row = row;
    this.col = col;
    r = new Random();
  }
  public int getMove(){
    int move;
    move = r.nextInt(col);
    // the random module will generate number between 0 inclusive and col exclusive
    return move += 1;
  }
}