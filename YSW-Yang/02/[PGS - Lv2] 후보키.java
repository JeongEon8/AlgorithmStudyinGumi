import java.util.*;
class Solution {
    ArrayList<Integer> candidateKeys;
    public int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;
        candidateKeys = new ArrayList<>();
        
        for(int i = 1; i < (1 << colSize); i++){
            if(!isMinimal(i)){
                continue;
            }
            
            if(isUnique(i, rowSize, colSize, relation)){
                candidateKeys.add(i);
            }
        }
        
        return candidateKeys.size();
    }
    
    public boolean isMinimal(int current){
        for(int key : candidateKeys){
            if((key & current) == key){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isUnique(int current, int rowSize, int colSize, String[][] relation){
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < rowSize; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < colSize; j++){
                if((current & (1 << j)) != 0){
                    sb.append(relation[i][j]).append(",");
                }
            }
            set.add(sb.toString());
        }
        return set.size() == rowSize;
    }
}
