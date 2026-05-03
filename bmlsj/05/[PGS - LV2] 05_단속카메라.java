import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 나가는 지점 기준 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = Integer.MIN_VALUE;
        
        for(int[] r: routes) {
            if (camera < r[0]) {
                camera = r[1];
                answer++;
            }
        }
        
        return answer;
    }
}