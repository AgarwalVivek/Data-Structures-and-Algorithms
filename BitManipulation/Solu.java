import java.util.Arrays;

public class Solu {

	    public int[] productExceptSelf(int[] nums) {
	        //build up left and right array for product calculation
	        
	        int left[] = new int[nums.length];
	        
	        int right[] = new int[nums.length];
	        
	        int product[] = new int[nums.length];
	        
	        //now build left first
	        // we have to leave the left most and fill all the right part first
	        //left[0] = dummy left[1] = product till 0th element i.e.nums[0] and so on for right side
	        
	        left[0] = 1;
	        for(int i = 1; i< left.length; i++){
	            left[i] = left[i-1] * nums[i-1];
	        }
	        System.out.println(Arrays.toString(left));
	        right[nums.length-1] = 1;
	        
	        for(int i = nums.length-2; i>=0; i--){
	            right[i] = right[i+1] *nums[i+1];
	        }
	         System.out.println(Arrays.toString(right));
	        for(int i =0; i<product.length; i++){
	            product[i] = left[i] *right[i];
	        }
	        
	        return product;
	        
	    }
	}

