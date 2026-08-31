import java.util.*;
class Solution {
    
    static List<Set<Integer>> candidate;
    static String[][] relation;
    static int n, m;
    public int solution(String[][] relation) {
        
        Solution.relation = relation;
        n = relation.length;
        m = relation[0].length;
        
        candidate = new ArrayList<>();
        for(int i = 1; i <= m; i++) {
            comb(0, i, new HashSet<>());   
        }
        
        return candidate.size();
    }
    
    static void comb(int start, int targetLen, Set<Integer> selected) {
        
        if (selected.size() == targetLen) {
            
            // 최소성 검사
            for(Set<Integer> key: candidate) {
                if (selected.containsAll(key)) {
                    return;
                }
            }
        
            // 유일성
            if (isUnique(selected)) {
                candidate.add(new HashSet<>(selected));
            }
            
            return;
        }
    
        for(int i = start; i < m; i++) {
            selected.add(i);
            comb(i + 1, targetLen, selected);
            selected.remove(i);
        }
    }
    
    static boolean isUnique(Set<Integer> selected) {
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j : selected) {
                sb.append(relation[i][j]).append(",");
            }
            
            set.add(sb.toString());
        }
        
        return set.size() == n;
    }
}