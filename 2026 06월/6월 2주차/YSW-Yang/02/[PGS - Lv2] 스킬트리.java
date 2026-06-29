import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        int index = 1;
        for(int i = 0; i < skill.length(); i++){
            hashmap.put(skill.charAt(i) ,index++);
        }
        
        
        for(String s : skill_trees){
            index = 1;
            boolean canSkillTree = true;
            for(int i = 0; i < s.length(); i++){
                if(hashmap.containsKey(s.charAt(i))){
                    if(hashmap.get(s.charAt(i)) == index){
                        index++;
                    }else{
                        canSkillTree = false;
                        break;
                    }
                }
            }
            
            if(canSkillTree){
                answer++;
            }
        }
        
        return answer;
    }
}
