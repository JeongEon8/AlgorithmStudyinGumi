import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int dtTime = fees[0]; // 기본 시간
        int dtFee = fees[1];  // 기본 요금
        int unitTime = fees[2]; // 단위시간
        int unitFee = fees[3];  // 단위요금
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> totalTimeMap = new HashMap<>();
        
        for(String record : records) {
            String[] split = record.split(" ");
            int hour = Integer.parseInt(split[0].split(":")[0]);
            int min = Integer.parseInt(split[0].split(":")[1]);
            int time = hour * 60 + min;
            
            int num = Integer.parseInt(split[1]);
            String type = split[2];
            
            if (type.equals("IN")) {
                map.put(num, time);
            } else { // OUT
                int parkTime = time - map.remove(num);
                totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + parkTime);
            }
        }
        
        int lastTime = 23* 60 + 59;
        for(int num: map.keySet()) {
            int parkTime = lastTime - map.get(num);
            totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + parkTime);
        }
        
        List<Integer> keys = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(keys);
        
        int[] answer = new int[keys.size()];
        for(int i = 0; i < keys.size(); i++) {
            int num = keys.get(i);
            int time = totalTimeMap.get(num);
            
            if (time <= dtTime) {
                answer[i] = dtFee;
            } else {
                // 올림
                int exFee = (int) Math.ceil((double) (time - dtTime) / unitTime) * unitFee;
                answer[i] = dtFee + exFee;
            }
        }
        
        return answer;
    }
}