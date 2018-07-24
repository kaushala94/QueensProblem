
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
			System.out.println("solution\n");
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
	
	public static int validMove(int a, int b)
	{
		for(int j=0; j<8; j++)
		{
			if(get(a,j) == 1 )
			{
				return -1;
			}
			if(get(j,b) == 1)
			{
				return -1;
			}
			 
		}
		for (int j=0; j<8; j++)
		{
			if(get(a-j,b-j) == 1)
			{
				return -1;
			}
			if(get(a-j,b+j) == 1)
			{
				return -1;
			}
			if(get(a+j,b-j) == 1)
			{
				return -1;
			}
			if(get(a+j,b+j) == 1)
			{ 
				return -1;
			}
			
		}
		return 0;
	}
	
	public int placeQeen(int a, int b, int type)
	{
		if (type == 0)
		{
			board[a][b]= 1;
			numQueens++;
			return 0;
		}
		else if (type == 1)
		{
			board [a][b]= 0;
			return 0;
		}
		System.out.println("wrong type");
		return -3;
		
		
	}
	
	public static int get(int a, int b)
	{
		if(a<0||b<0||a>7||b>7)
		{

			return -1;
		}
		return board[a][b];
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
