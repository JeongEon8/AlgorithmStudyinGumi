import java.util.*;
class Solution {
    static Set<String> resultSet = new HashSet<>();
    static boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        
        resultSet.clear();
        visited = new boolean[user_id.length];
        
        dfs(0, user_id, banned_id);
        return resultSet.size();
    }
    
    static void dfs(int index, String[] user_id, String[] banned_id) {
        if (index == banned_id.length) {
            List<String> selected = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    selected.add(user_id[i]);
                }
            }
         
            Collections.sort(selected);
            resultSet.add(String.join(",", selected));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;

            if (isMatch(user_id[i], banned_id[index])) {
                visited[i] = true;             
                dfs(index + 1, user_id, banned_id);
                visited[i] = false;            
            }
        }
    }
    
    static boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
        return false;
    }
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}