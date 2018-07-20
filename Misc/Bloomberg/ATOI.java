package Bloomberg;






class  ATOI {
	int sign = 1;
    
    public boolean isCharacter(char c){
              if(c>='0' && c<='9') return  false;
        return true;
    }
    
    public int getSum(String s){
        if(s.length() == 0) return 0;
        int sum = 0, cur = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(sign == 1)
        		if(sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign == -1) 
        		if(sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            cur = (int)(s.charAt(i) -'0');
            sum  = (sum *10)+cur;
            System.out.println(sum);

        }
        return sum;
    }
    private boolean isEndOfString(int curIndex, int stringLength){
        return curIndex == stringLength;
        
    }
    
    public int myAtoi(String str) {
        
        if (str.length() == 0) return 0;
        
        boolean isNegative = false;
        int index = 0;
        
        while(str.charAt(index) == ' ') index++;
        System.out.println("her "+ str.charAt(index));
        if(isEndOfString(index, str.length())) return 0;
        
        
        while(isCharacter(str.charAt(index)) && str.charAt(index) != '-') index++;
        System.out.println("her "+ str.charAt(index));
        if(isEndOfString(index, str.length())) return 0;
        System.out.println("her "+ str.charAt(index));
        if(str.charAt(index) == '+' && !isCharacter(str.charAt(index))) index++;
        if(str.charAt(index) == '-'&& !isCharacter(str.charAt(index+1))) {
        		isNegative = true;
        		sign = -1;
        		index++;
        		
        }
        
        String number = "";
    
        while(!isEndOfString(index, str.length()) && !isCharacter(str.charAt(index)) ) {
        	System.out.println("jer");
            number = number  + (str.charAt(index));
            index++;
        }
              
        int num = getSum(number);
        num = isNegative? -num:num;
        if(num <= Integer.MIN_VALUE+1) return Integer.MIN_VALUE;
        if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        System.out.println(Integer.MIN_VALUE);
        return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATOI obj = new ATOI();
		System.out.println(obj.myAtoi("-91283472332"));

	}
}