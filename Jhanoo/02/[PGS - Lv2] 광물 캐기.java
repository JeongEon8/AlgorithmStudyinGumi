import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int pickCount = picks[0] + picks[1] + picks[2];
        int mineralCount = Math.min(minerals.length, pickCount * 5);

        int groupCount = (mineralCount + 4) / 5;
        int[][] groups = new int[groupCount][3];

        for (int i = 0; i < mineralCount; i++) {
            int group = i / 5;

            if (minerals[i].equals("diamond")) {
                groups[group][0]++;
            } else if (minerals[i].equals("iron")) {
                groups[group][1]++;
            } else {
                groups[group][2]++;
            }
        }

        Arrays.sort(groups, (a, b) -> {
            int fatigueA = a[0] * 25 + a[1] * 5 + a[2];
            int fatigueB = b[0] * 25 + b[1] * 5 + b[2];

            return fatigueB - fatigueA;
        });

        int answer = 0;

        for (int[] group : groups) {
            int dia = group[0];
            int iron = group[1];
            int stone = group[2];

            if (picks[0] > 0) {
                answer += dia + iron + stone;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += dia * 5 + iron + stone;
                picks[1]--;
            } else {
                answer += dia * 25 + iron * 5 + stone;
                picks[2]--;
            }
        }

        return answer;
    }
}
