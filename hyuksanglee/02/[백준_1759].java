package beakjoon;

import java.io.*;
import java.util.Arrays;

public class Baekjoon1759 {

	static int L,C, consonant, vowel;
	static char[] ch,alp;
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] input = in.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		ch = new char[C];
		alp = new char[L];
		consonant = 0;
		vowel = 0;
		input = in.readLine().split(" ");
		for(int i = 0; i<C; i++) {
			ch[i] = input[i].charAt(0);
		}
		
		
		Arrays.sort(ch);
		for(int i=0; i<C; i++) {
			if(ch[i] == 'a'||ch[i] == 'e'||ch[i] == 'i'||ch[i] == 'o'||ch[i] == 'u' ) {
				vowel++;
				String st = ""+ch[i];
				back(1,i, st);
				vowel--;
			}else {
				consonant++;
				String st = ""+ch[i];
				back(1,i, st);
				consonant--;
			}
			
		}
	}
	
	static void back(int count, int index, String result) {
		if(count == L) {
			if(vowel >0 && consonant>1){
				System.out.println(result);
			}
			return;
		}
		for(int j =index+1; j<C; j++) {
			String newSt = result+ ch[j];
			
			
			
			if(ch[j] == 'a'||ch[j] == 'e'||ch[j] == 'i'||ch[j] == 'o'||ch[j] == 'u' ) {
				vowel++;
				
				back(count+1,j, newSt);
				vowel--;
			}else {
				consonant++;
				back(count+1,j, newSt);
				consonant--;
			}
			
			
			
		}
		
		
	}

}
