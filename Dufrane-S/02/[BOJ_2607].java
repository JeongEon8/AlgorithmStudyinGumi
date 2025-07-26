import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String word = br.readLine();
		int[]wordCount = new int[26];
		for(int i=0;i<word.length();i++){
		    wordCount[(int)word.charAt(i)-65]+=1;
		}
		int answer=0;
		for(int i=0;i<n-1;i++){
		    String wordTmp = br.readLine();
		    if(Math.abs(wordTmp.length()-word.length())>1)continue;
		    
		    
		    int[]wordCountTmp = new int[26];
    		for(int j=0;j<wordTmp.length();j++){
    		    wordCountTmp[(int)wordTmp.charAt(j)-65]+=1;
    		}
    		int diff=0;
    		
    		for(int j=0;j<26;j++){
    		    diff+=Math.abs(wordCount[j]-wordCountTmp[j]);
    		}
    		if(wordTmp.length()-word.length()==0)diff--;
    		if(diff<=1)answer++;
		}
	
	    System.out.print(answer);
	}
}
