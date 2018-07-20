import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogInfor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t="word1 word2 3456 [abc def] [ghi jkl] [1234] [-abcd] word 2345";
		t.replaceAll("\\p{P}","");
		
		String in = "Item(s): [item1.test]dsds";

		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(in);

		while(m.find()) {
		    System.out.println(m.group(1));
		}
		int n = -20;
		System.out.println(n>>2);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/vivekagarwal/Desktop/test.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
