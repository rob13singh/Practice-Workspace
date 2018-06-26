package com.misc.test;
import java.io.IOException;
import java.util.Scanner;

public class StringEncodeAndCollapse {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        /*BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }*/

        String res;
        String input;
        try {
            input = in.nextLine();
        } catch (Exception e) {
            input = null;
        }

        res = collapseString(input);
        
        System.out.println(res);
        /*bw.write(res);
        bw.newLine();

        bw.close();*/
    }
    
    
static String collapseString(String input) {
    	
    	String output = new String();
    	int charRepetitionValue = 0;
    	if(input == null || input.length() == 0) {
    		return null;
    	}
    	char lastChar = 0;
    	char charAtIndex = 0;
    	for(int i=0; i<input.length(); i++) {
    		charAtIndex = input.charAt(i);
    		if(i==0) {
    			lastChar = charAtIndex;
    			charRepetitionValue++;
    			continue;
    		}
    		if(charAtIndex == lastChar) {
    			charRepetitionValue++;
    		}
    		else {
    			output += String.valueOf(charRepetitionValue) + lastChar; 
    			lastChar = input.charAt(i);
    			charRepetitionValue = 1;
    		}
    		if(i+1 == input.length() && lastChar != charAtIndex) {
    			lastChar = charAtIndex;
    			charRepetitionValue = 1;
    		}
    	}
    	output += String.valueOf(charRepetitionValue) + lastChar; 
    	return output;

    }
}


