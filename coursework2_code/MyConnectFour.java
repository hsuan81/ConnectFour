import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyConnectFour {
	
	private Board board;
  private int playerNum;
  private ArrayList<Player> players = new ArrayList<>();
  private int row = 6;
  private int col = 7;
	
	public MyConnectFour(){
		board = new Board(row, col);
    // need to get input if more than 2 players
    playerNum = 2;  
		playGame();
	}
	
	private void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in"); 
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		board.print();
    players.add(new Player('r'));
    players.add(new ComputerPlayer('y', row, col));
    int currentPlayer = 0;
		boolean win = false;
		while(!win){
      int move;
      // ensure the computer player will not select the column already full
      do{
        move = players.get(currentPlayer).getMove();
      }
      while(board.checkFull(move));
      // get token and place it
      char token = players.get(currentPlayer).getToken();
      board.placeCounter(token, move);
      // check winning
      if(checkHorizontal(token)|checkVertical(token)|checkRightDiagonal(token)|checkLeftDiagonal(token)){
        win = true;
      }
      board.print();
      if(win){
        // human player is always set to the first one to play
        if(currentPlayer == 0){
          System.out.println("You Have Won!!!");
        }
        else{
          System.out.println("Computer Has Won!!!");
        }
      }
      // make turn of the player
      else{
        currentPlayer = (currentPlayer + 1) % playerNum;
      }
    }
	}

  private boolean checkHorizontal(char token){
		int count = 0;
		for(int i=0; i<board.getRow(); i++){
      for(int j=0; j<board.getCol(); j++){
        if(board.getCell(i, j) == token){
          count = count + 1;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
      }
      // reset count to zero after going through one column
      count = 0;
    }
    return false;
  }

  private boolean checkVertical(char token){
		int count = 0;
		for(int i=0; i<board.getCol(); i++){
      for(int j=0; j<board.getRow(); j++){
        if(board.getCell(j, i) == token){
          count = count + 1;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
      }
      count = 0;
    }
    return false;
  }

  private boolean checkLeftDiagonal(char token){
    // go through every cell that's possible to have four tokens in a row
    int count = 0;
    int row = board.getRow();
    int col = board.getCol();
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        if(i+3<row && j+3<col){
          // check the four diagonal cell from the current cell
          for(int k=0; k<4; k++){
            if(board.getCell(i+k, j+k) == token){
              count = count + 1;
              if(count >= 4){
                return true;
              }
            }
            else{
              count = 0;
            }
          }
          count = 0;
        }	
      }	
    }
    return false;
  }
  private boolean checkRightDiagonal(char token){
    int count = 0;
    int row = board.getRow();
    int col = board.getCol();
    for(int i=0; i<row; i++){
      for(int j=col-1; j>=0; j--){
        if(i+3<row && j-3>=0){
          for(int k=0; k<4; k++){
            if(board.getCell(i+k, j-k) == token){
              count = count + 1;
              if(count >= 4){
                return true;
              }
            }
            else{
              count = 0;
            }
          }
          count = 0;
        }	
      }	
    }
    return false;
  }
  
}
