import java.util.*;
class Solution {
    
    static class Group {
        int dia, iron, stone;
        
        Group(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 곡괭이 수
        int totalPick = picks[0] + picks[1] + picks[2];
        // 최대 광물 수(곡괭이 x 5개)
        int maxMinerals = Math.min(minerals.length, totalPick * 5);

        List<Group> groups = new ArrayList<>();
        
        for(int i = 0; i < maxMinerals; i += 5) {
            
            int dia = 0, iron = 0, stone = 0;
            
            for(int j = i; j < i + 5 && j < maxMinerals; j++) {
                String mineral = minerals[j];
                
                if (mineral.equals("diamond")) {
                    dia++;
                    iron += 5;
                    stone += 25;
                } else if (mineral.equals("iron")) {
                    dia++;
                    iron++;
                    stone += 5;
                } else {
                    dia++;
                    iron++;
                    stone++;
                }
            }
            groups.add(new Group(dia, iron, stone));
        }
        
        groups.sort((a, b) -> b.stone - a.stone);
        
        for(Group g: groups) {
            if (picks[0] > 0) {
                answer += g.dia;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += g.iron;
                picks[1]--;
            } else {
                answer += g.stone;
                picks[2]--;
            }
        }
        
        return answer;
    }
}