import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int[][][][][] infoList = new int[3][2][2][2][100_001];
        
        for(String s : info){
            String[] infoArr = s.split(" ");
            int language = exchange(infoArr[0]);
            int jobCategory = exchange(infoArr[1]);
            int career = exchange(infoArr[2]);
            int soulFood = exchange(infoArr[3]);
            int score = Integer.parseInt(infoArr[4]);
            infoList[language][jobCategory][career][soulFood][score]++;
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    for(int l = 0; l < 2; l++){
                        for(int score = 99_999; score > 0; score--){
                            infoList[i][j][k][l][score] += infoList[i][j][k][l][score + 1];
                        }
                    }
                }
            }
        }
        
        for(int t = 0; t < query.length; t++){
            String[] q = query[t].split("\\s+and\\s+|\\s+");
            int language = exchange(q[0]);
            int jobCategory = exchange(q[1]);
            int career = exchange(q[2]);
            int soulFood = exchange(q[3]);
            int score = Integer.parseInt(q[4]);
            
            if(language == 3 || jobCategory == 3 || career == 3 || soulFood == 3){
                for(int i = 0; i < 3; i++){
                    if(language != 3 && i != language){
                        continue;
                    }
                    for(int j = 0; j < 2; j++){
                        if(jobCategory != 3 && j != jobCategory){
                            continue;
                        }
                        for(int k = 0; k < 2; k++){
                            if(career != 3 && k != career){
                                continue;
                            }
                            for(int l = 0; l < 2; l++){
                                if(soulFood != 3 && l != soulFood){
                                    continue;
                                }
                                answer[t] += infoList[i][j][k][l][score];
                            }
                        }
                    }
                }
            }else{
                answer[t] = infoList[language][jobCategory][career][soulFood][score];
            }
        }
        
        return answer;
    }
    
    private int exchange(String s){
        if(s.equals("cpp") || s.equals("backend") || s.equals("junior") || s.equals("chicken") ){
            return 0;
        }else if(s.equals("java") || s.equals("frontend") || s.equals("senior") || s.equals("pizza") ){
            return 1;
        }else if(s.equals("python")){
            return 2;
        }
        
        return 3;
    }
}
