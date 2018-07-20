
public class longestCommon {

	public longestCommon() {
		// TODO Auto-generated constructor stub
	}

	    public String longestCommonPrefix(String[] strs) {
	        if(strs.length == 0) return "";
	        String pointer = strs[0];
	        //to start comparing from second string in list
	        int arrayIndex = 1;
	        
	        /* pointer will get shortened in each iteration as per number of letter match
	        *
	        */
	        
	        while(pointer != null && arrayIndex <= strs.length -1){
	            
	            //extract current string do match cehck operation
	            
	            String subject = strs[arrayIndex];
	            System.out.println("Here "+subject);
	            
	            //mainrtain index to cutshort pointer for next iteration
	            int index = 0;
	            //check number of character match with pointer
	            int smaller = pointer.length() < subject.length() ?pointer.length():subject.length();
	            int bigger = smaller == pointer.length() ? subject.length(): pointer.length();
	            while(index < smaller && subject.charAt(index) == pointer.charAt(index))
	                index++;
	            pointer = pointer.substring(0, index);
	            System.out.println(pointer);
	        
	            //update arrayIndex to check next subject
	            arrayIndex++;
	        }
	        return pointer;
	    }
	}

