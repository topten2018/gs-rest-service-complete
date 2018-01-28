package hello;

public class Status {
public String jName;
public int jGameId;
public int fGameWins;
public int fGameLoos;
public int fGameDraws;
	public Status(int gameId, String Name) {
		// TODO Auto-generated constructor stub
		this.jName=Name;
		this.jGameId=gameId;
		this.fGameWins = hello.GreetingController.jGameWins;
		this.fGameLoos = hello.GreetingController.jGameLoose;
		this.fGameDraws = hello.GreetingController.jGameDraw;
		
	}
	
	public String getName()
	{
		return jName;
	}
	public int getGameId()
	{
		return jGameId;
	}
	public int getGameWins()
	{
		return fGameWins;
	}
	public int getGameLoos()
	{
		return fGameLoos;
	}
	public int getGameDraws()
	{
		return fGameDraws;
	}

}
