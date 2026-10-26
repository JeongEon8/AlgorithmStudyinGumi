import java.util.*;
class Solution
{
    static int A, B;
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        A = a;
        B = b;
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 1; i<=n; i++){
            que.add(i);
        }
        
        while(!que.isEmpty()){
            que = find(que);
            answer++;
        }

        return answer;
    }
    
    static Queue<Integer> find(Queue<Integer> que){
        Queue<Integer> tmp = new ArrayDeque<>();
        while(!que.isEmpty()){
            int n1 = que.poll();
            int n2 = que.poll();
            if(check(n1) && check(n2) ){
                return new ArrayDeque<>();
            }
            if(check(n1)){
                tmp.add(n1);
            }else if(check(n2)){
                tmp.add(n2);
            }else{
                tmp.add(n1);
            }
        }
        
        return tmp;
        
    }
    
    static boolean check(int n){
        if(n == A){
            return true;
        }
        if(n == B){
            return true;
        }
        
         return false;
    }
}
