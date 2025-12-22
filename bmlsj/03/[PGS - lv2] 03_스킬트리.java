import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
      
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: skill.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, map.size()) + 1);
        }
        
        int cnt = 0;
        for(String sk: skill_trees) {
            int tmp = 0;
			Boolean check = true;
			for (char ch : sk.toCharArray()) {
				if (map.containsKey(ch) && map.get(ch) == tmp + 1)  {
                    tmp++;
                    continue;
                } else if (!map.containsKey(ch)) {
                    continue;
                }    
                else{
                    check = false;
                    break;
                }
            }
            
            if (check) cnt++;
        }
        
        return cnt;
    }
}