import java.util.Arrays;
import java.util.List;

class LetterCombinationsOfPhone {

String letters1[][] = {{},{}, {"a","b","c"}, {"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};


public List<String> letterCombinations(String digits) {
    
    String listArr[];
    
    if(digits.length() == 0){
        listArr = new String[0];
    }
    else{
        listArr = crossProduct(digits);
    }

    return Arrays.asList(listArr);
}



String[] crossProduct(String digits){
    
    String finalList[] = letters1[Integer.parseInt(digits.charAt(0)+"")];
    System.out.println(Arrays.toString(finalList));
    String temp[];
    String nextDigit[];
    
    for(int k = 1; k < digits.length(); k++){
        
        nextDigit = letters1[Integer.parseInt(digits.charAt(k)+"")];
        
        int len1 = finalList.length, len2 = nextDigit.length;
        
        temp = new String[len1*len2];
        int idx=0;
        
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                temp[idx++] = finalList[i] + nextDigit[j];
            }
        }
        finalList = temp;
    }
    
    return finalList;
}

public static void main(String [] args) {
	LetterCombinationsOfPhone obj = new LetterCombinationsOfPhone();
	 int x =98;
	 int a[] = new int[26];
	 a[x-'a'] = 1;
	 char s = (char) x;
	 System.out.println(s);
	System.out.println(obj.letterCombinations("23"));
}
}