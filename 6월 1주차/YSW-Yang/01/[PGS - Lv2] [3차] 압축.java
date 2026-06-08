import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> dictionary = new HashMap<>();
        
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), index++);
        }
        
        int end = 0;
        for(int start = 0; start < msg.length(); start++){
            end = start + 1;
            String res = "";
            while(true){
                if(end > msg.length()){
                    answerList.add(dictionary.get(res));
                    start = end - 2;
                    break;
                }
                String key = msg.substring(start, end);
                if(dictionary.containsKey(key)){
                    res = key;
                    end++;
                }else{
                    answerList.add(dictionary.get(res));
                    dictionary.put(key, index++);
                    start = end - 2;
                    break;
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
