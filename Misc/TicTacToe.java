import java.util.HashMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class TicTacToe {

	Piece cross, circle;
	Board board;
	Player p1, p2;
	static HashMap<String, String> PlayerSet;
	private static TicTacToe game;

	public static TicTacToe getInstance(int size) {
		if(game == null) {
			Board board = new Board(size);
			System.out.println("j");
			PlayerSet = new HashMap<>();
			
			
		} 
			return game;
	}
	
	public TicTacToe getGame() {
		return game;
	}


	public TicTacToe() {
		
	}

	public boolean login(String id, String  password) {
		return (PlayerSet.containsKey(id)) == true ? true: false;
			

	}
	public boolean register(String id, String password) {
		if (PlayerSet.containsKey(id)){
			return false;
		} 
		PlayerSet.put(id,  password);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game = getInstance(3);
		Board b = new Board(3);
		b.buildBoard();
		System.out.println();
		System.out.println(b.getWinner().getClass());
		

	}

	public Piece getWinner() {
		// TODO Auto-generated method stub
		return board.getWinner();
	}

}
