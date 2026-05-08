package 고득점Kit;

public class Programmers_타겟넘버 {
	
	static int count = 0;
    public int solution(int[] numbers, int target) {
      
        count = 0;
        int len =numbers.length;
            
        dfs(1, numbers[0], len, target, numbers);
        dfs(1, -1*numbers[0], len, target, numbers);
            
        return count;
    }
    
    public void dfs(int depth, int total, int len, int target, int[] numbers){
        if(depth>=len){
            if(total==target){
                count++;
            }
            return;
        }
        
        dfs(depth+1, total + numbers[depth], len, target, numbers);
        dfs(depth+1, total - numbers[depth], len, target, numbers);
        
        
        
    }

}
