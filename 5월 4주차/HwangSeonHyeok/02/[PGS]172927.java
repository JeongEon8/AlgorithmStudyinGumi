import java.util.*;
class Solution {
    class Stones implements Comparable<Stones>{
        int dia;
        int iron;
        int stone;
        int total;
        public Stones(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
            this.total = (dia*25)+(iron*5)+stone;
        }
        
        @Override
        public int compareTo(Stones o){
            return Integer.compare(o.total,this.total);
        }
        
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<Stones> list = new ArrayList<>();
        int picksCnt = picks[0]+picks[1]+picks[2];
        for(int i = 0; i<minerals.length && i<5*picksCnt; i+=5){
            int dia=0;
            int iron=0;
            int stone=0;
            for(int j = i; j<i+5;j++){
                if(j==minerals.length)break;
                if(minerals[j].equals("diamond"))dia++;
                else if(minerals[j].equals("iron"))iron++;
                else stone++;
            }
            list.add(new Stones(dia,iron,stone));
        }
        Collections.sort(list);
        for(Stones s:list){
            if(picks[0]>0){
                answer+= s.dia + s.iron + s.stone;
                picks[0]--;
            }else if(picks[1]>0){
                answer+= (s.dia*5) + s.iron + s.stone;
                picks[1]--;
            }else{
                answer+= s.total;
                picks[2]--;
            }
        }
        
        
        return answer;
    }
}