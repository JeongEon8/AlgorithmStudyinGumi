import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();
        
        for (String record : records) {
            String[] str = record.split(" ");
            String[] time = str[0].split(":");
            
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String car = str[1];
            boolean isIn = str[2].equals("IN");
            
            if (isIn) {
                inTime.put(car, minute);
            } else {
                int t = minute - inTime.remove(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
            }
        }
        
        int end = 23 * 60 + 59;
        
        for (String car : inTime.keySet()) {
            int t = end - inTime.get(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
        }
        
        int[] answer = new int[totalTime.size()];
        int idx = 0;
        
        for (int total : totalTime.values()) {
            answer[idx++] = calcFee(total, fees);
        }
        
        return answer;
    }
    
    static int calcFee(int total, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
    
        if (total <= baseTime) 
            return baseFee;
        
        int extraTime = total - baseTime;
        int extraFee = (extraTime + unitTime - 1) / unitTime * unitFee;
        
        return baseFee + extraFee;
    }
}
