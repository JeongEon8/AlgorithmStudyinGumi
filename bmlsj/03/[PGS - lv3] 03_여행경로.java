import java.util.*;
class Solution {
    
    static Map<String, List<String>> routes;
    static List<String> path = new ArrayList<>();
    static int ticketCount;
    static boolean finished = false;
    
    public String[] solution(String[][] tickets) {

        
        ticketCount = tickets.length;
        routes = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {

            String from = tickets[i][0];
            String to = tickets[i][1];

            routes.putIfAbsent(from, new ArrayList<>());
            routes.get(from).add(to);
        }
        
        
         // 알파벳순 정렬
        for (String key : routes.keySet()) {
            Collections.sort(routes.get(key));
        }

        dfs("ICN", 0);
    
        // System.out.println(path);
        return path.toArray(new String[0]);
    }
    
    static void dfs(String now, int used) {
        
        if (finished) {
            return;
        }
        
        path.add(now);
        
        if (used == ticketCount) {
            finished = true;
            return;
        }

        if (routes.containsKey(now)) {
            
            List<String> nextList = routes.get(now);
            
            for (int i = 0; i < nextList.size(); i++) {

                String next = nextList.get(i);

                nextList.remove(i);
                dfs(next, used + 1);
                if (finished) return;
                nextList.add(i, next);

            }
        }
        path.remove(path.size() - 1);
    }
}