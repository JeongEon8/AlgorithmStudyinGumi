import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int time = -1;
        String answer = "(None)";
        
        m = convertMelody(m);
        
        for (String music : musicinfos) {
            String[] info = music.split(",");
            
            int playTime = getPlayingTime(info[0], info[1]);
            String title = info[2];
            String melody = convertMelody(info[3]);
            
            StringBuilder played = new StringBuilder();

            for (int i = 0; i < playTime; i++) {
                played.append(melody.charAt(i % melody.length()));
            }
            
            if (played.toString().contains(m) && playTime > time) {
                answer = title;
                time = playTime;
            }
        }
        
        return answer;
    }
    
    public int getPlayingTime(String start, String end) {
        int s = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
        int e = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3, 5));
        return e - s;
    }
    
    public String convertMelody(String melody) {
        return melody
            .replace("C#", "H")
            .replace("D#", "I")
            .replace("F#", "J")
            .replace("G#", "K")
            .replace("A#", "L");
    }
}
