import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        
        for(String re: record) {
            String[] split = re.split(" ");
            String comm = split[0];
            
            if (comm.equals("Enter") || comm.equals("Change")) {
                String id = split[1];
                String name = split[2];
            
                map.put(id, name);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(String re: record) {
            String[] split = re.split(" ");
            String comm = split[0];
            
            if (comm.equals("Enter")) {
                list.add(map.get(split[1]) + "님이 들어왔습니다.");
            } else if (comm.equals("Leave")) {
                list.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}