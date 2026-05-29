import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> list = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            list.add(new int[] {priorities[i], i});
        }
        
        Arrays.sort(priorities);
        int cnt = 0;
        
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            
            // 대기중인 프로세스의 우선순위가 더 높으면
            if (cur[0] < priorities[priorities.length - cnt - 1]) {
                list.add(cur);
                continue;
            } 
            
            // 현재 프로세스 실행
            cnt++;
            if (cur[1] == location)
                return cnt;
            
        }
        
        return cnt;
    }
}
