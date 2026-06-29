import java.util.*;
class Solution {
    
    static Map<Long, Long> parent;
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        // 방이 이미 배정 => 더 큰 번호 중 가장 작은 방
        parent = new HashMap<>();
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }
        
        return answer;
    }
    
    static long findEmptyRoom(long room) {
        
        // 1. 해당 번호가 map에 없다면 빈방
        if (!parent.containsKey(room)) {
            // 이 방의 다음 빈방 후보는 다음번호(room + 1)
            parent.put(room, room + 1);  
            return room;
        }
        
        // 이미 배정된 방일 경우, map에 저장된 부모(빈방 후보)를 찾음.
        long next = findEmptyRoom(parent.get(room));
        
        parent.put(room, next + 1);
        return next;
        
        
    }
}