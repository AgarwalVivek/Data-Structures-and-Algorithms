import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class SumTreeMostFreq {
     ArrayList<Integer> result;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int numNodes = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
       
        if(root == null) return new int[1];
        
        result = getSumList(root);
        int res[] = new int[result.size()];
        int idx = 0;
        for(int i: result) {
        		res[idx++] = i;
        }
        return res;
    }
    private ArrayList<Integer> getSumList(TreeNode root){
        
        
        doDFS(root);
        List<Integer> bucket[] = new List[numNodes+ 1];
        
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int i ;
        for( i = bucket.length-1; i >= 0 ; i--)
        		if(bucket[i] != null) break;
        result = new ArrayList<Integer>(bucket[i]);
        return result;
        
    }
    private void doDFS(TreeNode root){
      
        if(root == null)
            return;
        numNodes++;
        int sum[] = new int[1];
        SumTree(root, sum);
        map.compute(sum[0], (key, val)->{
            if(val == null)
                return 1;
            else
                return val + 1;
        });
        doDFS(root.left);
        doDFS(root.right);
        
    }
    private void SumTree(TreeNode root, int sum[]){
        if(root == null) return;
        sum[0]+=root.val;
        SumTree(root.left, sum);
        SumTree(root.right, sum);
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    		TreeNode r = new TreeNode(5);
    		r.left = new TreeNode(2);
    		r.right = new TreeNode(-5);
    		SumTreeMostFreq  obj = new SumTreeMostFreq();
    		System.out.println(Arrays.toString(obj.findFrequentTreeSum(r)));

	}
}


