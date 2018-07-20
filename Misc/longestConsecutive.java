import java.util.HashSet;

public class longestConsecutive {
	 static class Solution {
	    public int longestConsecutive(int[] nums) {
	        HashSet<Integer> set = new HashSet<>();
	        
	        for(int i : nums){
	            set.add(i);
	        }
	        int  count = 0;
	        int n = nums.length;
	        int maxLength = 0;
	        for(int i = 0; i < n; i++){
	            if(!set.contains(nums[i]-1)){
	                //do the counting of max we have from here
	                count = nums[i];
	                
	                while(set.contains(count)){
	                    count++;
	                }
	                maxLength = Math.max(maxLength, count-nums[i]); 
	                
	            }
	            
	        }
	        return maxLength;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestConsecutive obj = new longestConsecutive();
		Solution sol = new Solution();
		int n[] = {100, 4, 200, 1, 3, 2};
		System.out.println(sol.longestConsecutive(n));
		

	}

}
