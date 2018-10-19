package com.logical.test;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharInAString {

	public static void main(String[] args) {
		Map<Character, Integer> counts=null;
		String word="appleeddaapaaaaaddss";
		
		char[] letter=word.toCharArray();
		counts=new HashMap<>();
		for(int i=0;i<letter.length;i++){
			if(counts.containsKey(letter[i])){

				int currentValue=counts.get(letter[i]);
				counts.put(letter[i], currentValue+1);
			}else{
				counts.put(letter[i], 1);
			}
			
		}
		
		for(Map.Entry<Character, Integer> data :counts.entrySet()){
			char c=data.getKey();
			int v=data.getValue();
			if(v>1){
				System.out.println(c+"="+v);
			}
			
			
		}
		
		
	}

}
