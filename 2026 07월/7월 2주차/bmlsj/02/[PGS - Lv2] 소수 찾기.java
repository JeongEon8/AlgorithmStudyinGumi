import java.util.*;
class Solution {
    
    static HashSet<Integer> set;
    public int solution(String numbers) {
 
        set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited);
        
        int cnt = 0;
        for(int num: set) {
            if (isPrime(num)) {
                cnt++;
            }
        }
        
        
        return cnt;
    }
    
    static void dfs(String numbers, String curr, boolean[] visited) {
        if (!curr.isEmpty()) {
            set.add(Integer.parseInt(curr));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, curr + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}