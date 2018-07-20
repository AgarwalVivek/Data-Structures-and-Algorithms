
public class Player {
	String id;
	String name;
	String password;
	TicTacToe game;
	
	Player(String id, String name, String password, TicTacToe game){
		this.id = id;
		this.name = name;
		this.password = password;
		game = this.game;
		
	}
	
	public Piece getResult() {
		//i+1, j+1==>last last(diagonal)
		
		//i-1, j+1 leading to 0 last
		//i+1, j  leading to last j
		//i, j+1 leading to i last 
		
		//i = 0 j = 0 to endless result to 0][maxCol] true\
		Piece winner;
		return winner = game.getWinner();
		
	}
}
