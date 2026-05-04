import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        List<String> words = new ArrayList<>();
        List<int[]> ranges = new ArrayList<>();
        
        int idx = 0;
        for(String word: message.split(" ")) {
            int start = message.indexOf(word, idx);
            int end = start + word.length() - 1;
            
            words.add(word);
            ranges.add(new int[]{start, end});
            
            idx = end + 1;
        }
        
        Set<String> set = new HashSet<>();
        for(int[] spoiler: spoiler_ranges) {
            int start = spoiler[0];
            int end = spoiler[1];
            
            for(int i = 0; i < words.size(); i++) {
                int ws = ranges.get(i)[0];
                int we = ranges.get(i)[1];
                
                if (!(we < start || ws > end)) {
                    set.add(words.get(i));
                }
            }
           
        }
        
        for(String s: set) {
            int total = 0;
            int inSpoiler = 0;
            
            for(int i = 0; i < words.size(); i++) {
                if (words.get(i).equals(s)) {
                    total++;
                    
                    int ws = ranges.get(i)[0];
                    int we = ranges.get(i)[1];
                    
                    // 스포 방지 단어인가
                    for (int[] spoiler : spoiler_ranges) {
                        int start = spoiler[0];
                        int end = spoiler[1];

                        if (!(we < start || ws > end)) {
                            inSpoiler++;
                            break;
                        }
                    }
                    
                }
            }
            
            if (total == inSpoiler) {
                answer++;
            }
            
        }
       
        return answer;
    }
}