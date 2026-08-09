import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        m = replaceNote(m);
        int max = -1;
        
        // C, C#, D, D#, E, F, F#, G, G#, A, A#, B
        for(String music: musicinfos) {
            String[] info = music.split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            String title = info[2];
            String musicInfo = info[3];
            
            // 시간 변환
            int playTime = changeTime(Integer.parseInt(start[0]),Integer.parseInt(start[1]),
                                  Integer.parseInt(end[0]),Integer.parseInt(end[1]));
            
            // '#' 다른 문자로 치환
            musicInfo = replaceNote(musicInfo);
            
            StringBuilder tmp = new StringBuilder();
            int len = musicInfo.length();
            for (int i = 0; i < playTime; i++) {
                tmp.append(musicInfo.charAt(i % len));
            }
            
            if (tmp.toString().contains(m)) {
                if (playTime > max) {
                    max = playTime;
                    answer = title;
                }
            }
            
        }
        
        return answer;
    }
    
    static int changeTime(int stHour, int stMin, int endHour, int endMin) {
        
        int st = stHour * 60 + stMin;
        int end = endHour * 60 + endMin;
        
        return end - st;
    }
    
    static String replaceNote(String str) {
        return str.replaceAll("C#", "c")
                  .replaceAll("D#", "d")
                  .replaceAll("F#", "f")
                  .replaceAll("G#", "g")
                  .replaceAll("A#", "a")
                  .replaceAll("B#", "b");
    }
}