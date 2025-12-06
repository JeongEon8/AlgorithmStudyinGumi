import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    static List<Integer> answer;
    static int max;
    public int[] solution(int n, int[] info) {
        answer = new ArrayList<Integer>();
        max = 0;
        recur(0, n, 0, new int[11], info);
        if(answer.size() == 0) answer.add(-1);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public void recur(int depth, int n, int next, int[] current, int[] info) {
        if(depth == n || next == 10) {
            if(depth != n && next == 10) {
                current[10] += n - depth;
            }
            int score = compareScore(info, current);
            if(score > 0) {
                if(max < score) {
                    max = score;
                    answer = Arrays.stream(current).boxed().collect(Collectors.toList());
                } else if(max == score) {
                    for(int i = 10; i >= 0; i--) {
                        if(answer.get(i) < current[i]) {
                            answer = Arrays.stream(current).boxed().collect(Collectors.toList());
                            break;
                        } else if(answer.get(i) > current[i]) break;
                    }
                }
            }
            if(depth != n && next == 10) current[10] -= n - depth;
            return;
        }

        for(int i = next; i < 10; i++) {
            if(info[i] > 0 && n - depth >= info[i]+1) {
                current[i] += info[i]+1;
                recur(depth+info[i]+1, n, i+1, current, info);
                current[i] -= info[i]+1;
            }
            if(info[i] == 0) {
                current[i] = 1;
                recur(depth+1, n, i+1, current, info);
                current[i] = 0;
            }
            recur(depth, n, i+1, current, info);
        }
    }
    
    public int compareScore(int[] apeach, int[] ryan) {
        int aScore = 0;
        int rScore = 0;
        for(int i = 0; i < 10; i++) {
            if(apeach[i] == ryan[i] && apeach[i] == 0) continue;
            if(apeach[i] >= ryan[i]) aScore += 10-i;
            else rScore += 10-i;
        }
        
        if(aScore - rScore >= 0) return -1;
        else return rScore - aScore;
    }
}
