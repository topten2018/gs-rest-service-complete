package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    public static int jGameId = 0;
    public static int[] jSession = new int[100];
    public static int[] jGameCounter = new int[100];
    public static int[] jGameMovesCounter = new int[100];
    public static int[][][] jGameBoard = new int[100][3][3];
    public static int  jGameWins=0 ;
    public static int jGameLoose=0;
    public static int jGameDraw=0;
    private static final String template = "HelloEhlo, %s!";
    private final AtomicLong counter = new AtomicLong();
    
   public static List<String> messages3 = new ArrayList<String>();
   public static List<String> Moves = new ArrayList<String>();
   public static int jCounter = 0;
    
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    
    
    @RequestMapping("/ngame")
    public @ResponseBody NewGame greeting() {
    	
    	jSession[jGameId]=0;
    	jGameCounter[jGameId]=0;
    	Moves.add(jGameId,"");
    	NewGame NewGame = new NewGame(jGameId);
		jGameId++;
		return NewGame;
		
	}
    
  
    
    
    




	@RequestMapping("/gamemove")
    public GameMove MoveGame(@RequestParam(value="GameId") int GameId,
    		
    		@RequestParam(value="row") int row, 
    		@RequestParam(value="col") int col)
    		  {
		int jTempGameMoveCounter = jGameMovesCounter[GameId];
		jTempGameMoveCounter++;
		jGameMovesCounter[GameId]=jTempGameMoveCounter;
    	int jTempCounter = jSession[jGameId];
    	jTempCounter++;
    	jSession[jGameId] = jTempCounter;
    	
    	
    	
    	if (jTempGameMoveCounter<6)
    	{
    		GameMove MGame = new GameMove(GameId, row, col);
    		return MGame;
    	}
    	
    	return null;
	}
	
	@RequestMapping("/status")
	public Status Status(@RequestParam(value="GameId") int GameId,
			@RequestParam(value="name") String Name)
	{
		Status jStatus = new Status(GameId, Name);
		return jStatus;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    /*
 @GetMapping("/newgame/")
    
    public NewGame jNewGame( int jId) {
    	NewGame NewGame = new NewGame(jId);
    	return NewGame;
	}
	*/
/*
    @RequestMapping("/new2")
    public @ResponseBody String asd(@RequestParam(value="userId", defaultValue="6240") String userId2) {
		Game Game = new Game();
    	return userId2;
	}
	*/
    
    /*
    @RequestMapping("/new")
    
    public @ResponseBody New jNewGame(int jId) {
    	int jGame = new New();
    	return jGame;
	}
	
	*/
    
    
    
    		
    		
    }

