class Solution {
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        
        for (String tree : skill_trees) {
            int cur = 0;
            boolean ok = true;
            
            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                int idx = skill.indexOf(c);
                
                if (idx == -1) continue;
                
                if (cur < idx) {
                    ok = false;
                    break;
                }
                
                if (cur == idx) cur++;
            }
            
            if (ok) cnt++;
        }
        
        return cnt;
    }
}
