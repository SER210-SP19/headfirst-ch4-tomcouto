/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	   
	   //0 = player 1, 1 = computer
	   private int player = 0;
	   
	   private int score = 0;
	   
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		clearBoard();
		player = 0;
	}
	/**
	 * runs through each row and column setting the spot to ' '
	 */
	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub
		//clears the board
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
		
		//sets turn (not implemented)
		if(player == 1)
			player = 0;
		else player = 1;
		
	}

	@Override
	public void setMove(int player, int location) {
		// TODO Auto-generated method stub
			switch(location) {
			
			case 0: if(board[0][0] == EMPTY) {
				if(player == 0) {
					board[0][0] = CROSS;
				}
				else if(player == 1) {
					board[0][0] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 0");
			break;
			
			case 1: if(board[0][1] == EMPTY) {
				if(player == 0) {
					board[0][1] = CROSS;
				}
				else if(player == 1) {
					board[0][1] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 1");
			break;
			
			case 2: if(board[0][2] == EMPTY) {
				if(player == 0) {
					board[0][2] = CROSS;
				}
				else if(player == 1) {
					board[0][2] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 2");
			break;
			
			case 3: if(board[1][0] == EMPTY) {
				if(player == 0) {
					board[1][0] = CROSS;
				}
				else if(player == 1) {
					board[1][0] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 3");
			break;
			
			case 4: if(board[1][1] == EMPTY) {
				if(player == 0) {
					board[1][1] = CROSS;
				}
				else if(player == 1) {
					board[1][1] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 4");
			break;
			
			case 5: if(board[1][2] == EMPTY) {
				if(player == 0) {
					board[1][2] = CROSS;
				}
				else if(player == 1) {
					board[1][2] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 5");
			break;
			
			case 6: if(board[2][0] == EMPTY) {
				if(player == 0) {
					board[2][0] = CROSS;
				}
				else if(player == 1) {
					board[2][0] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 6");
			break;
			
			case 7: if(board[2][1] == EMPTY) {
				if(player == 0) {
					board[2][1] = CROSS;
				}
				else if(player == 1) {
					board[2][1] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 7");
			break;
			
			case 8: if(board[2][2] == EMPTY) {
				if(player == 0) {
					board[2][2] = CROSS;
				}
				else if(player == 1) {
					board[2][2] = NOUGHT;
				}
			} else
				System.out.println("This spot is already taken! 8");
			break;
			}
			score++;
	}

	@Override
	public int getComputerMove() {
		//Only blocks win case on the left side of the board to make game beatable
		
		//if middle left is win case block that spot
		if(((board[0][0] == CROSS && board[0][2] == CROSS) || (board[1][1] == CROSS && board[1][2] == CROSS)) && board[1][0] == EMPTY) {
			setMove(1,3);
		}
		//if top left is win case block that spot
		else if(((board[1][1] == CROSS && board[1][2] == CROSS) || (board[0][1] == CROSS && board[0][2] == CROSS) || (board[1][1] == CROSS && board[2][2] == CROSS)) && board[0][0] == EMPTY) {
			setMove(1,0);
		}
		//if bottom left is win case block that spot
		else if(((board[0][0] == CROSS && board[1][0] == CROSS) || (board[1][2] == CROSS && board[0][2] == CROSS) || (board[2][1] == CROSS && board[2][2] == CROSS)) && board[2][0] == EMPTY) {
			setMove(1,6);
		}
		else if(((board[2][0] == CROSS && board[1][1] == CROSS) || (board[1][2] == CROSS && board[2][2] == CROSS) || (board[0][0] == CROSS && board[0][1] == CROSS)) && board[0][2] == EMPTY) {
			setMove(1,2);
		}
		// finds best 3 spots first then picks based on whatever is open
		else {
		if(board[1][1] == EMPTY)
			setMove(1, 4);
		else if(board[0][0] == EMPTY)
			setMove(1, 0);
		else if(board[2][2] == EMPTY) 
			setMove(1, 8); 
		else if(board[0][2] == EMPTY)
			setMove(1, 2);
		else if(board[2][0] == EMPTY)
			setMove(1, 6);
		else if(board[0][1] == EMPTY)
			setMove(1, 1);
		else if(board[1][0] == EMPTY)
			setMove(1, 3);
		else if(board[2][1] == EMPTY)
			setMove(1, 7);
		else if(board[1][2] == EMPTY)
			setMove(1, 5);
		}
		
		return 0;
	}

	@Override
	public int checkForWinner() {
		// TODO Auto-generated method stub
		if(score > 3) {
		if(board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == CROSS || 
	            board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == CROSS || 
	            board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == CROSS || 
	            board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == CROSS || 
	            board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == CROSS || 
	            board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == CROSS || 
	            board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS ||            
	            board[2][0] == CROSS && board[1][1] == CROSS && board[0][2] == CROSS)
		return 2;
		else if(board[0][0] == NOUGHT && board[0][1] == NOUGHT && board[0][2] == NOUGHT || 
	            board[1][0] == NOUGHT && board[1][1] == NOUGHT && board[1][2] == NOUGHT || 
	            board[2][0] == NOUGHT && board[2][1] == NOUGHT && board[2][2] == NOUGHT || 
	            board[0][0] == NOUGHT && board[1][0] == NOUGHT && board[2][0] == NOUGHT || 
	            board[0][1] == NOUGHT && board[1][1] == NOUGHT && board[2][1] == NOUGHT || 
	            board[0][2] == NOUGHT && board[1][2] == NOUGHT && board[2][2] == NOUGHT || 
	            board[0][0] == NOUGHT && board[1][1] == NOUGHT && board[2][2] == NOUGHT ||           
	            board[2][0] == NOUGHT && board[1][1] == NOUGHT && board[0][2] == NOUGHT)
		return 3;
		else
		return 0;
		}
		else if(score ==9) {
			if(board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == CROSS || 
		            board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == CROSS || 
		            board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == CROSS || 
		            board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == CROSS || 
		            board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == CROSS || 
		            board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == CROSS || 
		            board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS ||            
		            board[2][0] == CROSS && board[1][1] == CROSS && board[0][2] == CROSS)
			return 2;
			else if(board[0][0] == NOUGHT && board[0][1] == NOUGHT && board[0][2] == NOUGHT || 
		            board[1][0] == NOUGHT && board[1][1] == NOUGHT && board[1][2] == NOUGHT || 
		            board[2][0] == NOUGHT && board[2][1] == NOUGHT && board[2][2] == NOUGHT || 
		            board[0][0] == NOUGHT && board[1][0] == NOUGHT && board[2][0] == NOUGHT || 
		            board[0][1] == NOUGHT && board[1][1] == NOUGHT && board[2][1] == NOUGHT || 
		            board[0][2] == NOUGHT && board[1][2] == NOUGHT && board[2][2] == NOUGHT || 
		            board[0][0] == NOUGHT && board[1][1] == NOUGHT && board[2][2] == NOUGHT ||           
		            board[2][0] == NOUGHT && board[1][1] == NOUGHT && board[0][2] == NOUGHT)
			return 3;
			else
			return 1;
		}
		else return 0;

	}
	
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }

}
