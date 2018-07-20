import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class KMostFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length == 0) {
            return result;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i: nums){
            map.compute(i, ((key, val)->{
                if(val == null)
                    return 1;
                else
                    return val + 1;
            }));
        }
        
       List<Integer> bucket[] = new List[nums.length+1];
   
        System.out.println(bucket.length);
        ArrayList<Integer> curList = null;
        int freq = 0;
        for(int cur : map.keySet()){
            freq = map.get(cur);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<Integer>();
            }
            curList = (ArrayList<Integer>) bucket[freq];
            curList.add(cur);
            
        }
     
        curList = null;
        int count = 0;
        for(int i = bucket.length-1; i>=0; i--){
            if(bucket[i] == null) continue;
            //System.out.println(bucket[i]);
            for(Integer t: (ArrayList<Integer>)bucket[i]) {
            	    count++;
            	    
            		result.add(t);
            		if(count == k) break;
            }
        }
        return result;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2};
		int k = 2;
		KMostFrequent obj = new KMostFrequent();
		System.out.println(obj.topKFrequent(arr, k));
		

	}

}
