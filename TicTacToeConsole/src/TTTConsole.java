import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TTTConsole  {
                                                     
      public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static TicTacToe TTTboard = new TicTacToe();
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      
	   int currentState = TicTacToe.PLAYING;
	   String userInput;
	   int move;
	   //game loop
	   do {
		   while(currentState == TicTacToe.PLAYING) {
		    TTTboard.printBoard();
		    // Print message if game-over

         	/**
         	* get player input here and call setMove(). user should input a number between 0-8
         	*/
         	System.out.println("Please enter what spot you want (0-8).");
         	move = in.nextInt();
         	TTTboard.setMove(0, move);
         	TTTboard.getComputerMove();
			currentState = TTTboard.checkForWinner();
		   }

		   if (currentState == ITicTacToe.CROSS_WON) {
			   TTTboard.printBoard();
        		System.out.println("'X' won! Bye!");
        	} else if (currentState == ITicTacToe.NOUGHT_WON) {
        		TTTboard.printBoard();
        		System.out.println("'O' won! Bye!");
        	} else if (currentState == ITicTacToe.TIE) {
        		TTTboard.printBoard();
        		System.out.println("It's a TIE! Bye!");
        	}

         //user can break the loop. remove this line when you finish implementation.
         userInput = in.next();
         
      } while ((currentState == ITicTacToe.PLAYING) && (!userInput.equals("q"))); // repeat if not game-over
   
   }    
}