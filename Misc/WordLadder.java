import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class WordLadder {

	public class Ladder{
		String lastWord;
		LinkedList<String> path;
		int distance;
		
		public Ladder(String lastWord, LinkedList<String> path, int distance) {
		
			this.lastWord = lastWord;
			this.path = path;
			this.distance = distance;
		}
		public String getLastWord() {
			return lastWord;
		}
		public void setLastWord(String lastWord) {
			this.lastWord = lastWord;
		}
		public LinkedList<String> getPath() {
			return path;
		}
		public void setPath(LinkedList<String> path) {
			this.path = path;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
	}
	
	public Ladder getLadderPath(String src, String dst, Set<String>  dict) {
		
		if(!dict.contains(dst)) return null;
		
		//to store various possible paths leading to dst
		LinkedList<Ladder> ladderList = new LinkedList<>();
		
		//for successive path defininf a linkedList
		LinkedList<String> path = new LinkedList<>();
		path.add(src);
		dict.remove(src);
		//to do BFS defining Queue of type ladder
		Queue<Ladder> q = new LinkedList<Ladder>();
		
		//defining a ladder with start as src string and length 1
		Ladder ladder = new Ladder(src, path, 1);
		
		//pushing init ladder into queue
		q.offer(ladder);
		ArrayList<String> toRemove = new ArrayList<>();
		while(!q.isEmpty() && !q.peek().equals(dst)) {
			
			//first thing first
			Ladder cur = q.peek();
			q.poll();
			
			if(cur.getLastWord().equals(dst)) {
				return cur;
			}
			
			for(String s: dict) {
			
			
				if(isOneLetterAway(cur.getLastWord().toCharArray(),s.toCharArray())) {
					LinkedList<String> addPath = new LinkedList<>(cur.getPath());
					addPath.add(s);
					q.offer(new Ladder(s,addPath ,cur.getDistance()+1));
					toRemove.add(s);
				}
				
				dict.remove(toRemove);
				toRemove = new ArrayList<>();
			
			}
			//Arrays.sort
		}
		if(!q.isEmpty())
			return q.peek();
		return null;
		
	}
	private  boolean isOneLetterAway(char[] cs, char[] cs2) {
		// TODO Auto-generated method stub
		boolean Fails = false;
		if (cs.length!= cs2.length) return false;
		
		for(int i = 0; i < cs.length; i++) {
			if(cs[i]!= cs2[i]) {
				if(Fails == true)
					return false;
				Fails = true;
			}
		}
		return true;
		
		
	}
	

		public static void main(String[] args) {
			  Set<String> dictionary = new HashSet<String>();
			  dictionary.add("CAT");
			  dictionary.add("BAT");
			  dictionary.add("COT");
			  dictionary.add("COG");
			  dictionary.add("COW");
			  dictionary.add("RAT");
			  dictionary.add("BUT");
			  dictionary.add("CUT");
			  dictionary.add("DOG");
			  dictionary.add("WEB");
			
			  String startWord = "CAT";
			  String endWord = "DOG";
			  WordLadder obj = new WordLadder();
			  Ladder result = obj.getLadderPath(startWord, endWord, dictionary);
			  System.out.println(result.path);

	}

}
