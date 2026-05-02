class Solution {
    
    static int answer = 0, cnt = 0;
    static String[] arr = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        dfs("", word);
        return answer;
    }
    
    static void dfs(String curr, String target) {
        
        if (curr.equals(target)) {
            answer = cnt;
            System.out.println(cnt);
            return;
        }
        
        if (curr.length() == 5) return;
        
        for (int i = 0; i < 5; i++) {
            cnt++;
            dfs(curr + arr[i], target);
        }
    }
}