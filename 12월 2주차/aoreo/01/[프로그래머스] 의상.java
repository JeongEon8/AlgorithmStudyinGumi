import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> sets = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if(sets.containsKey(clothes[i][1])) {
                sets.put(clothes[i][1], sets.get(clothes[i][1]) + 1);
            }else{
                sets.put(clothes[i][1], 1);
            }
        }
        for (Integer val : sets.values()) {
            answer = answer * (val+1);
        }
        return answer-1;
    }
}
