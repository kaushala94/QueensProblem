# QueensProblem
Solving queens problem using hill climbing method 

first create the main class

    public class main {
	
        /**
        * @param args
        */
	      public static void main(String[] args) {
		
		      chessboard board = new chessboard();
		      board.start();

	      }

    }
    
then create the class chessboard
		
	public class chessboard {

		private static int board[][];
		private int numQueens;
	
		public chessboard() {
			numQueens = 0;
			board = new int [8][8];
			for (int j=0; j<8; j++)
			{
				for(int k=0; k<8; k++)
				{
					board[j][k]=0;
				}
			}
		}
	
		public int getNumQueens()
		{
			return numQueens;
		}
	
		public void start()
		{
			solve (0);
		}
	
		public boolean solve(int numQueens)
		{
			if (numQueens == 8)
			{
				System.out.println("DONE");
				this.printBoard();
				return true;
			}
			else {
				for(int j=0; j<8; j++)
				{
					for(int k=0; k<8; k++)
					{
						if (validMove(j,k) == 0) {
							this.placeQeen(j, k, 0);
							numQueens++;
							if(solve(numQueens)) {
							return true;
						}
						else {
							this.placeQeen(j, k, 1);
							numQueens--;
						}
						
						}
					}
				}
			}
			return false;
		}
	
		public static int validMove(int x, int y)
		{
			for(int j=0; j<8; j++)
			{
				if(get(x,j) == 1 )
				{
					return -1;
				}
				if(get(j,y) == 1)
				{
					return -1;
				}
			 
			}
			for (int j=0; j<8; j++)
			{
				if(get(x-j,y-j) == 1)
				{
					return -1;
				}
				if(get(x-j,y+j) == 1)
				{
					return -1;
				}
				if(get(x+j,y-j) == 1)
				{
					return -1;
				}
				if(get(x+j,y+j) == 1)
				{ 
					return -1;
				}
			
			}
			return 0;
		}
	
		public int placeQeen(int x, int y, int type)
		{
			if (type == 0)
			{
				board[x][y]= 1;
				numQueens++;
				return 0;
			}
			else if (type == 1)
			{
				board [x][y]= 0;
				return 0;
			}
			System.out.println("wrong type");
			return -3;
		
		
		}
	
		public static int get(int x, int y)
		{
			if(x<0||y<0||x>7||y>7)
			{
				
				return -1;
			}
			return board[x][y];
		}
		public void printBoard()
		{
			for(int j=0; j<8; j++)
			{
				for (int k=0; k<8; k++)
				{
					System.out.print(this.get(j,k) + " ");
				
				}
				System.out.println("");
			}
		 
		}
	
	
	}


