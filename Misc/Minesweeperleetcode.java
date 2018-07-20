import java.util.Arrays;
import java.util.HashSet;

class Minesweeperleetcode {
    int xOffset[] = {-1, 0, 1};
    int yOffset[] = {-1, 0, 1};
    HashSet<Integer> hs = new HashSet<>();
    public boolean isSafe(char[][]board, int i, int j){
        if(i>=0 && i<board.length && j >=0 && j<board[0].length) return true;
        return false;
    }
    public boolean hasAdjacent(char[][] board, int x, int y, int count[]){
        int curX = 0, curY = 0;
        count[0] = 0;
        for(int i = 0; i < xOffset.length; i++){
            for(int j = 0; j < yOffset.length; j++){
                if(xOffset[i] == 0 && yOffset[j] == 0) continue;
                curX = x + xOffset[i];
                curY = y + yOffset[j];
                if(isSafe(board, curX, curY)){
                    if(board[curX][curY] == 'M') count[0]++;
                }
            }
        }
        return count[0] == 0? false:true;
    }
    
    public void doDFS(char[][] board, int x, int y, boolean[][]visited, int count[]){
        if(visited[x][y]) return;
        
        visited[x][y] = true;
        if(board[x][y] == 'M') return;
        
        if(hasAdjacent(board, x, y, count)){
        
            board[x][y] = (char)(count[0]+'0');
            
        } else{
            //doDFS for blank cells
        	board[x][y] = 'B';
            int curX = 0, curY = 0;
            for(int i = 0; i< xOffset.length; i++){
                for(int j = 0; j< yOffset.length; j++){
                    if(xOffset[i] == 0 && yOffset[j] == 0) continue;
                    curX = xOffset[i]+x;
                    curY = yOffset[j] +  y;
                    if(isSafe(board, curX, curY)){
                        doDFS(board, curX, curY, visited, count);
                    }
                }
            }
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        //empty board edge case
        if(board.length == 0) return board;
        
        //to prevent retraversal
        boolean visited[][] = new boolean[board.length][board[0].length];
        
        //capturing click co-ordinates
        int i = click[0];
        int j =  click[1];
        
        //pass by reference for getting count when finding adjacent cells status(has M or not)
        int count[] = new int[1];
        if(board[i][j] == 'M'){
            board[i][j] = 'X';
            return board;
        } else if(hasAdjacent(board, i, j, count)){
            board[i][j] = (char)count[0];
        } else{
        //is blank reveal and start revealing all 8 neighbors recursively 
            doDFS(board, i, j, visited, count);
        }
        
        return board;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char board[][] = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
		int click[] = {3, 0};
	
		Minesweeperleetcode obj = new Minesweeperleetcode();
		obj.updateBoard(board, click);
		for(int i = 0; i< board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
    
    
}