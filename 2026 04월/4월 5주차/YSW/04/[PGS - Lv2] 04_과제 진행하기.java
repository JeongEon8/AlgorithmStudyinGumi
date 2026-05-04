import java.util.*;

class Solution {
    class Info {
        String name;
        int remain;
        
        public Info(String name, int remain){
            this.name = name;
            this.remain = remain;
        }
    }
    
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        Stack<Info> stack = new Stack<>();
        
        Arrays.sort(plans, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        int index = 0;
        int currentTime = 0;
        for(String[] sArr: plans){
            String name = sArr[0];
            int start = toMin(sArr[1]);
            int playTime = Integer.parseInt(sArr[2]);
            
            while(!stack.isEmpty()){
                Info cur = stack.pop();
                if(currentTime + cur.remain <= start){
                    currentTime += cur.remain;
                    answer[index++] = cur.name;
                }else {
                    cur.remain -= (start - currentTime);
                    stack.push(cur);
                    break;
                }
            }
            
            currentTime = start;
            stack.push(new Info(name, playTime));
        }
        
        while(!stack.isEmpty()){
            Info cur = stack.pop();
            answer[index++] = cur.name;
        }
        
        return answer;
    }
    
    public int toMin(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}