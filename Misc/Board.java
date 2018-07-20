import java.util.Random;

public class Board {
	Piece[][] pieces;
	Piece winner;
	Board(int size){
		pieces = new Piece[size][size];
		
		
	}
	
	public Piece toggler(int index) {
		Piece p[];
		p = new Piece[2];
		p[0] = new Circle();
		p[1] = new Cross();
		return p[index];
		
	}
	public void buildBoard() {
		Random r = new Random();
		for(int i = 0; i < pieces.length; i++) {
			for(int j = 0; j < pieces[0].length; j++) {
				pieces[i][j]= toggler(r.nextInt(2));
			}
			
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(pieces[i][j].getClass());
			}
			System.out.println();
		}
		
	}

	public Piece getWinner() {
		// TODO Auto-generated method stub
		Piece Winner = new Piece();
		if(isDiagonalWinner() != null) 
			Winner = isDiagonalWinner();
		for(int i = 0; i < pieces.length; i++) {
			
			if(isRowWinner(i) != null && checkWinner(isRowWinner(i))) {
				Winner =  isRowWinner(i).getClass() != Winner.getClass()? Winner: isRowWinner(i);
				System.out.println("here");
			}
		}
		for(int j = 0; j < pieces[0].length; j++)
			if(isColWinner(j) != null && checkWinner(isColWinner(j))) 
				Winner =  isColWinner(j).getClass() != Winner.getClass()? Winner: isColWinner(j);
		
		if(isOppDiagonalWinner() != null && checkWinner(isOppDiagonalWinner())) 
			Winner =  isOppDiagonalWinner();
		return Winner;
	}

	private Piece isOppDiagonalWinner() {
		// TODO Auto-generated method stub
		int len = pieces.length;
		int i = len -1;
		int j = 0;
		
		
		Piece temp = pieces[i][j];
		while(i >=0) {
			if (temp.getClass() != pieces[i][j].getClass()) return null;
			i--; j++;
		}
		
		return temp;
	}

	private Piece isColWinner(int j) {
		// TODO Auto-generated method stub
		Piece temp = pieces[0][j];
		int row = 0;
		while(row < pieces.length) {
			if(temp.getClass() != pieces[row][j].getClass()) return null;
		}
		return temp;
	}

	private boolean checkWinner(Piece rowWinner) {
		// TODO Auto-generated method stub
		return true;
	}

	private Piece isRowWinner(int i) {
		// TODO Auto-generated method stub
		Piece temp = pieces[i][0];
		int j = 0;
		while(j < pieces[0].length) {
			
			if(temp.getClass() != pieces[i][j].getClass()) return null;
		}
		return temp;
	}

	private Piece isDiagonalWinner() {
		// TODO Auto-generated method stub
		Piece cur = pieces[0][0];
		int i = 1, j = 1;
		
		while(i < pieces.length) {
			if(pieces[i][j] != pieces[i+1][j+1]) return null;
				i++;
				j++;
		}
		return cur;
	}
	
}
