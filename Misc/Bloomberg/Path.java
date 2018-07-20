package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x  = x;
		this.y = y;
		
	}
	public boolean checkEquals(Point dest) {
		// TODO Auto-generated method stub
		return (this.x == dest.x && this.y == dest.y);
	}
	
}
public class Path {
	Point src, dest;
	public Path(int x1, int y1, int x2, int y2) {
		src = new Point(x1, y1);
		dest = new Point(x2, y2);
	}
	ArrayList<ArrayList<Point>> finalResult = new ArrayList<>();
	public void getAllPath(Point src, Point dest) {
		ArrayList<Point> result = new ArrayList<>();
		result.add(src);
		result.indexOf(o)
		if(src.x < dest.x && src.y < dest.y) {
			
			getPath(src,src, dest, result, 1, 1); 
			//System.out.println(finalResult);
		}
		
		//find the shortest possible path
		int min  = Integer.MAX_VALUE;
		for(ArrayList<Point> arr: finalResult){
			if(arr.size() < min) {
				min = arr.size();
				
			}
		}
		System.out.println("hrere");
		for(ArrayList<Point> arr: finalResult) {
			if(arr.size() == min) {
				for(Point p:arr) {
					System.out.print(p.x +"\t"+p.y+"\t");
				}
				System.out.println();
			}
				
		}
	}

	private boolean isSafe(Point p) {
		return (p.x > 0 && p.y > 0 && p.x < 4 && p.y < 4);
	}
	private void printResult() {
		
		for(ArrayList<Point> arr: finalResult) {
			for(Point p: arr) {
				System.out.print(p.x +"\t"+p.y+"\t");
			}
			System.out.println();
		}
		
	}
	private void getPath(Point src, Point cur, Point dest, ArrayList<Point> result, int x, int y) {
		// TODO Auto-generated method stub
		//System.out.println(cur.x +"\t"+cur.y);
		if(!cur.checkEquals(src))result.add(cur);
		
		if(cur.checkEquals(dest)) {
			//System.out.println(cur.x +"\t"+cur.y);
			
			finalResult.add(result);
			//System.out.println(finalResult);
		
			result = new ArrayList<>();
		}
		cur = new Point(cur.x+x, cur.y);
		
		if(isSafe(cur)) {
			getPath(src, cur, dest, result, x, y);
		}
		result.remove(cur);
		cur = new Point(cur.x-x, cur.y+y);
		
		if(isSafe(cur)) {
			getPath(src, cur, dest, result, x, y);
		}
		cur = new Point(cur.x, cur.y-y);
		result.remove(cur);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path obj = new Path(1,1,3,2);
		obj.getAllPath(obj.src, obj.dest);
		//obj.printResult();

	}

}
