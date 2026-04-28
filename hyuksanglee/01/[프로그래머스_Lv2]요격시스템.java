package programmers;

import java.util.Arrays;

public class Programmers_요격시스템 {

	static class Info implements Comparable<Info>{
        int s;
        int e;
        
        Info(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Info o){
            if (this.e != o.e) {
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
    
    public int solution(int[][] targets) {
        
        int len = targets.length;
        Info[] infos = new Info[len];
        
        // 입력을 Info 배열로 변환
        for (int i = 0; i < len; i++) {
            infos[i] = new Info(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(infos);
        
        int answer = 0;
        
        int last = -1;
        
        for (int i = 0; i < len; i++) {
            int start = infos[i].s;
            int end = infos[i].e;
            
            // 현재 구간의 시작이 last 이상이면, 기존 미사일로는 커버 불가 → 새로 쏨
            if (start >= last) {
                answer++;
                last = end;  // 이 구간의 끝점에 미사일을 쏜다고 생각
            }
            // start < last 면, 이미 last 위치 미사일에 이 구간이 포함되므로 아무 것도 안 함
        }
        
        return answer;
    }

}
