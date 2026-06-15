import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        int dictSize = 0;
        char ch = 'A';
        while(ch <= 'Z') {
            dict.put("" + ch++, ++dictSize);
        }
        
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < msg.length(); i++) {
            stack.push("" + msg.charAt(msg.length() - i - 1));
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!stack.isEmpty()) {
            String w = stack.pop();
            Integer wIdx = dict.get(w);
            
            if (stack.isEmpty()) {
                list.add(wIdx);
                break;
            }
            
            String c = stack.pop();
            Integer wcIdx = dict.get(w + c);
            
            while (wcIdx != null && !stack.isEmpty()) {
                w = w + c;
                c = stack.pop();
                
                wcIdx = dict.get(w + c);
            }
            
            if (wcIdx != null && stack.isEmpty()) {
                list.add(wcIdx);
                break;
            }
            
            wIdx = dict.get(w);
            list.add(wIdx);
            
            dict.put(w + c, ++dictSize);
            stack.push(c);
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
