import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player{
  private char token;
  private BufferedReader in;

  public Player(char token) {
    this.token = token;
    in = new BufferedReader(new InputStreamReader(System.in));
  }

  public char getToken(){
    return this.token;
  }
  
  public int getMove(){
    // get the input of movement and return move in the form of int
    // In case the input is not integer 
    try {
			return Integer.parseInt(in.readLine());
		}
		catch(IOException e) {
			return -1;
		}
  }
} 