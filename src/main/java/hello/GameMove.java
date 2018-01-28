package hello;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class GameMove {
	int fGameId;
	int jGameId2;
	int jrow;
	int jcol;
	
	public Object hj;
	//public ArrayList numbers;
	public Object fh;
	public String jRow;
	public String jCol;
	public String jCon="";
	public String jResult;
	public String jError="";
	public String jStatus;
	public String jWinner;
	String fd;
	
	AnotherMove[] asd= new AnotherMove[11];
	int x = 0;
	public int d = 0;
	/*
	public int TheGameCounter = 0;
	public int TheGameSession = 0;
	*/
	public int TheGameBoardCounter = 0;
	
	public int jtest = 0;
	public int jtempRow;
	public int jtempCol;
	public int GameID;
		
	
	Boolean jStartGame = false; 
	Boolean jWin = false;
	Boolean jSimpleGame = true;
	Boolean jPCwin = false;
	Boolean jUserwin = false;
	Boolean jGameFinisehd = false;
	
	
	
	
	public GameMove(int fGameId, int jrow, int jcol)
	{

		this.fGameId = fGameId;
		this.jrow = jrow;
		this.jcol = jcol;
		
		
	
		this.jtest = fGameId;
		
		
		jRow = String.valueOf(jrow);
		jCol = String.valueOf(jcol);
		printgameID();
		addmove();
		
		printmoves();
		
		printstatus();
		/*
		this.jResult= jResult;
		this.TheGameCounter= TheGameCounter;
		this.TheGameSession = TheGameSession;
		*/
		
		
	}
	
	public void printgameID()
	{
		this.GameID=fGameId;
	}
	
	

	public void initboard()
	{
		
		int row, col;
		
		for (row=0; row<3;row++)
			for (col = 0; col<3; col++)
				hello.GreetingController.jGameBoard[TheGameBoardCounter][row][col]= 0;
		
		
	}
	
	public void addmove()
	{
		jtest = fGameId;
		int jtempCount = hello.GreetingController.jGameCounter[d];
		int jSess = hello.GreetingController.jSession[fGameId];
		jCon = null;
		jCon = hello.GreetingController.Moves.get(jtest);
		
		jCon+= jRow + ","+ jCol+ ";";
	
		hello.GreetingController.Moves.add(jtest,jCon);
		
		jtempCount++;
		hello.GreetingController.jGameCounter[d]=jtempCount;
	//	TheGameCounter = jtempCount;
	//	TheGameSession = d;
		
	}
	public void checkwin(int symbol)
	{
		
		int row, col;
		for (row = 0;row<3; row++)
		{
			
			if ((hello.GreetingController.jGameBoard[TheGameBoardCounter][row][0]== symbol)&& (hello.GreetingController.jGameBoard[TheGameBoardCounter][row][1]==symbol) && (hello.GreetingController.jGameBoard[TheGameBoardCounter][row][2]==symbol))
				jWin = true;
		}
		
		for (col =0; col < 3; col++)
		{
			if ((hello.GreetingController.jGameBoard[TheGameBoardCounter][0][col]==symbol)&&(hello.GreetingController.jGameBoard[TheGameBoardCounter][1][col]==symbol)&&(hello.GreetingController.jGameBoard[TheGameBoardCounter][2][col]==symbol))
				jWin = true;
		}
		if ((hello.GreetingController.jGameBoard[TheGameBoardCounter][0][0]==symbol)&&(hello.GreetingController.jGameBoard[TheGameBoardCounter][1][1]==symbol) && (hello.GreetingController.jGameBoard[TheGameBoardCounter][2][2]==symbol))
			jWin = true;
		if ((hello.GreetingController.jGameBoard[TheGameBoardCounter][0][2]==symbol)&&(hello.GreetingController.jGameBoard[TheGameBoardCounter][1][1]==symbol) && (hello.GreetingController.jGameBoard[TheGameBoardCounter][2][0]==symbol))
			jWin = true;
		
		
	}
	
	public void printstatus()
	{
		
		
		if (jGameFinisehd==true)
		{
			this.jStatus="Finished";
			hello.GreetingController.jGameMovesCounter[GameID]=6;
			if ((jPCwin==false)&&(jUserwin==false))
			{
				hello.GreetingController.jGameDraw++;
				this.jWinner = "No winner";
			}
			
			
		}
		else
		{
			this.jStatus="On Air";
		}
		
		if (jPCwin==true)
		{
			this.jWinner = "Winner is PC";
			hello.GreetingController.jGameLoose++;
			
		}
		if (jUserwin==true)
		{
			this.jWinner="Winner is USer";
			hello.GreetingController.jGameWins++;
			
		}
		
		
	}
	public String getStatus()
	{
		return jStatus;
	}
	public String getWinner()
	{
		return jWinner;
	}
	public void printmoves()
	{
		
		initboard();
		jtest = fGameId;
		int jSess = hello.GreetingController.jSession[d]; 
		
		jResult = hello.GreetingController.Moves.get(jtest);
		String[] sdfg = jResult.split(Pattern.quote(";"));
		String jSymbol ;
		
		//  1 = x , 2 = 0,
		int jrecord;
		int x = 0;
		Boolean jSmb = false;
		for (String k : sdfg)
		{
			String[] extr = k.split(Pattern.quote(","));
			if (jSmb==false)
			{
			jSymbol = "X";	
			jrecord = 1;
			jSmb = true;
			}
			else
			{
			jSymbol = "O";
			jrecord = 2;
			jSmb = false;
			}
			
			this.asd[x] = new AnotherMove(extr[0],extr[1], jSymbol);
			int jx = Integer.parseInt(extr[0]);
			int jy = Integer.parseInt(extr[1]);
			
			hello.GreetingController.jGameBoard[TheGameBoardCounter][jx][jy]= jrecord;  
			x++;
		
		}
		
		
		
		checkwin(1);
		if (jWin==true)
		{
			
			 jUserwin = true;
			 jGameFinisehd = true;
			
			
		}
			
		checkwin(2);
		if (jWin==true)
		{
			 jPCwin = true;
			 jGameFinisehd = true;
			
			
		}
			
		
		
		if (jWin==false)
		{
			if (jSimpleGame==true)
			{
			simplepcmove();	
			}
			else
			{
			hardpcmove();
			}
		}
			
		this.asd[x] = new AnotherMove(String.valueOf(jtempRow), String.valueOf(jtempCol), "O");	
		hello.GreetingController.jGameBoard[TheGameBoardCounter][jtempRow][jtempCol]= 2; 
		
		this.hj = asd;
		
		jRow = String.valueOf(jtempRow);
		jCol = String.valueOf(jtempCol);
		jCon = null;
		jCon = hello.GreetingController.Moves.get(jtest);
		
		jCon+= jRow + ","+ jCol+ ";";
	
		hello.GreetingController.Moves.add(jtest,jCon);
		checkwin(1);
		if (jWin==true)
		{
			
			 jUserwin = true;
			 jGameFinisehd = true;
			
			
		}
			
		checkwin(2);
		if (jWin==true)
		{
			 jPCwin = true;
			 jGameFinisehd = true;
			
			
		}
		
		
	}
	
	
	
	public void simplepcmove()
	{
		int square, row, col;
		
		for (square = 1; square <=9; square++)
		{
			row = (square -1)/3;
			col = (square -1)%3;
			if (hello.GreetingController.jGameBoard[TheGameBoardCounter][row][col]==0)
			{
				hello.GreetingController.jGameBoard[TheGameBoardCounter][row][col]= 2;
				jtempRow = row;
				jtempCol = col;
				break;
			}
		}
		
	}
	
	public void hardpcmove()
	{
		Boolean jFoundSolution = false;
		int square, row, col;
		
		for (square = 1; square <=9; square++)
		{
			row = (square -1)/3;
			col = (square -1)%3;
			if (hello.GreetingController.jGameBoard[TheGameBoardCounter][row][col]==0)
			{
				hello.GreetingController.jGameBoard[TheGameBoardCounter][row][col]= 2;
				checkwin(2);
				if (jWin==true)
				{
					jFoundSolution=true;
				break;
				}
				else
				{
					hello.GreetingController.jGameBoard[TheGameBoardCounter][row][col]=0;
				}
			}
		}
		
		if (jFoundSolution == false)
		{
			simplepcmove();
		}
		
	}
	
	
	public class AnotherMove
	{ String raw; String column; String symbol;
		
		 AnotherMove (String raw, String column, String symbol)
		 {
		 this.raw  = raw;
		 this.column = column;
		 this.symbol = symbol;
		 }
		 public String getRaw()
		 {
			 return raw;
		 }
		 public String getColumn()
		 {
			 return column;
		 }
		 public String getSymbol()
		 {
			 return symbol;
		 }
	}
	
/*	
	public int jTheGameSession()
	{
		return TheGameSession;
	}
	
	public int jTheGameCounter()
	{
		return TheGameCounter;
	}
	
	public int getRow() {
		return jrow;
	}
	
	public int getGameId() {
		return fGameId;
	}
	
	public int getGameId2() {
		return jGameId2;
	}
	
	public int getCol() {
		return jcol;
	}
	public String getIt()
	{
		return jResult;
	}
	*/
	
	
	

}
