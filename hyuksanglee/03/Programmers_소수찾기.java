package 고득점Kit;

import java.util.TreeSet;

public class Programmers_소수찾기 {

	 static int[] arr;
	    static boolean[] check;
	    static TreeSet<Integer> set = new TreeSet<>();
	    public int solution(String numbers) {
	        int answer = 0;
	        arr = new int[numbers.length()];
	        check = new boolean[numbers.length()];
	        for(int i =0; i<numbers.length(); i++){
	            int num = numbers.charAt(i)-'0';
	            arr[i]=num;
	        }
	        
	        dfs(0, numbers.length(), "");
	        if (set.isEmpty()) return 0;
	        int max = set.last();
	        boolean[] isNotPrime = new boolean[max+1];
	        isNotPrime[0] = isNotPrime[1] = true; 
	        
	        for (int i = 2; i * i <= max; i++) {
	            if (!isNotPrime[i]) {
	                for (int j = i * i; j <= max; j += i) {
	                    isNotPrime[j] = true;
	                }
	            }
	        }
	       
	        for(int s : set){
	            if(!isNotPrime[s]){
	                answer++;
	            }
	        }
	        
	       
	        
	        
	        return answer;
	    }
	    
	    
	    public void dfs(int depth, int len, String num){
	        if(depth>=len){
	            return;
	        }
	        
	        for(int i =0; i<len; i++){
	            if(!check[i]){
	                check[i] = true;
	                
	                set.add(Integer.parseInt(num+ arr[i]));
	                dfs(depth+1, len, num+ arr[i]);
	                check[i] = false;
	            }
	        }
	        
	        
	    }

}
