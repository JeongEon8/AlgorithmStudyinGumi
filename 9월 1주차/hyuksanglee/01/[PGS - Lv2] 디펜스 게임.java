import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
        
        for(int e : enemy){
            int tmp = n-e;
            if(tmp<0 && k>0){
                if(!que.isEmpty() && que.peek()>e){
                    n+=que.poll();
                    
                    n-=e;
                    que.add(e);
                }
                k--;
            }else if(tmp>=0){
                n -= e;
                que.add(e);
            }else{
                break;
            }
            answer++;
        }
        return answer;
    }
}
