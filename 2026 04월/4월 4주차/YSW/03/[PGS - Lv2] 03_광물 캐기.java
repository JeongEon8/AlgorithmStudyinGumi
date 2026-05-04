import java.util.*;

class Solution {
    class MineGroup implements Comparable<MineGroup> {
        int dia;
        int iron;
        int stone;
        
        public MineGroup(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        
        @Override
        public int compareTo(MineGroup other){
            if(this.dia == other.dia){
                if(this.iron == other.iron){
                    return  other.stone - this.stone;
                }
                return  other.iron - this.iron;
            }
            
            return  other.dia - this.dia;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int canMineSize = Math.min(minerals.length, totalPicks * 5);
        List<MineGroup> mineGroups = new ArrayList<>();
        
        for(int i = 0; i < canMineSize; i += 5){
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5 && j < canMineSize; j++){
                if(minerals[j].equals("diamond")) dia++;
                if(minerals[j].equals("iron")) iron++;
                if(minerals[j].equals("stone")) stone++;
            }
            mineGroups.add(new MineGroup(dia, iron, stone));
        }
        Collections.sort(mineGroups);
        
        for(MineGroup m : mineGroups){
            if(picks[0] > 0){
                answer += m.dia + m.iron + m.stone;
                picks[0]--;
            }else if(picks[1] > 0){
                answer += (m.dia * 5) + m.iron + m.stone;
                picks[1]--;
            }else{
                answer += (m.dia * 25) + (m.iron * 5) + m.stone;
                picks[2]--;
            }
        }
        
        return answer;
    }
}