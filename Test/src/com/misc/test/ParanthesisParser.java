package com.misc.test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ParanthesisParser {

	
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String inputSentence = scan.nextLine();

        int openingBraceNum = Integer.parseInt(scan.nextLine().trim());

        int res = closingBracePosition(inputSentence, openingBraceNum);
        
        System.out.println(res);

        //bw.write(String.valueOf(res));
        //bw.newLine();

        //bw.close();
    }
    static int closingBracePosition(String inputSentence, int openingBraceNum) {

    	int result=-1;
    	boolean matchingParanthesisFound = false;
    	Stack<Character> bracesStack = new Stack();
    	if((inputSentence == null || inputSentence.length()==0) && openingBraceNum > 0) {
    		return -1;
    	}
    	for (int i=0; i<inputSentence.length(); i++) {
    		char sentenceChar = inputSentence.charAt(i);
    		if(sentenceChar == '{' || sentenceChar == '[' || sentenceChar == '(') {
    			bracesStack.push(sentenceChar);
    		}
    		if (bracesStack.isEmpty() && (sentenceChar == '}' || sentenceChar == ']' || sentenceChar == ')')) {
    			return -1;
    		}
    		else if (!bracesStack.isEmpty() && (sentenceChar == '}' || sentenceChar == ']' || sentenceChar == ')')) {
    			if((sentenceChar == '}' && bracesStack.peek() == '{') || (sentenceChar == ']' && bracesStack.peek() == '[') || (sentenceChar == ')' && bracesStack.peek() == '(')) {
    				if(bracesStack.size() == openingBraceNum && !matchingParanthesisFound) {
        				result = i+1;
        				matchingParanthesisFound = true;
        			}
        			bracesStack.pop();
    			}
    			else {
    				return -1;
    			}
    		}
    	}
    	if(!bracesStack.isEmpty()) {
    		return -1;
    	}
    	if(openingBraceNum == 0) {
    		return 0;
    	}
    	return result;

    }
}


