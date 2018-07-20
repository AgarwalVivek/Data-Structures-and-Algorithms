package Bloomberg;
public class Solution {
    public String reverseUtil(char[] str){
        int low = 0;
        int high = str.length -1;
        while(low < high){
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low ++;
            high--;
        }
        String res = new String(str);
        System.out.println(res);
        return res;
    }
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        
        String reverse1 = reverseUtil(s.toCharArray());
        String[] splitString = reverse1.split(" ");
        
        StringBuilder result = new StringBuilder();
        
        int index = 0;
        
        while(index < splitString.length){
            result.append(reverseUtil(splitString[index].toCharArray()));
            result.append(" ");
            index++;
        }
        
        String res = new String(result);
        res = res.substring(0, res.length() - 1);
        return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I am the one";
		
		Solution obj = new Solution();
		System.out.println(obj.reverseWords(s));
	}
}

