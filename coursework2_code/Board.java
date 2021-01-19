public class Board{
  private char[][] board;

  public Board(int row, int col){
    this.board = new char[row][col];
  }
  
  public int getRow(){
    return board.length;
  }

  public int getCol(){
    return board[0].length;
  }

  public char getCell(int row, int col){
    return board[row][col];
  }

  public boolean checkFull(int move){
    // check whether the column is full, designed for computer player
    // empty cell is null and can be judged by 0 in java
    if(getCell(0, move - 1) != 0){
      return true;
    }
    return false;
  }

  public String toString(){
    String result = "";
    for(int i=0; i<getRow(); i++){
			for(int j=0; j<getCol(); j++){
				if(this.board[i][j] != 0){
					result += ("| " + getCell(i,j) + " ");
				}
				else{
					result += ("|   ");
				}
			}
			result += ("|");
      result += String.format("%n");
		}
		result += ("  ");
    for(int i=1; i<=getCol(); i++){
      result += (i + "   ");
    }
    return result;
  }

  public void print(){
    // optional function
    System.out.println(this.toString());
  }

  public void placeCounter(char token, int move){
    boolean placed = false;
    for(int i=getRow()-1; i>=0; i--){
      if(!placed){
        if(getCell(i, move-1) == 0){
          // place token at empty position
          this.board[i][move-1] = token;
          placed = true;
        }
      }
    }
	}
    
}