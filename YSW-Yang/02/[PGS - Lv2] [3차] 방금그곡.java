import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = convert(m);
        
        int maxPlayTime = -1;
        for(int i = 0; i < musicinfos.length; i++){
            String[] musicinfo = musicinfos[i].split(",");
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");
            int playTime = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
            String title = musicinfo[2];
            String musicCode = convert(musicinfo[3]);
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < playTime; j++){
                sb.append(musicCode.charAt(j % musicCode.length()));
            }
            
            String playedMelody = sb.toString();
            if(playedMelody.contains(m)){
                if(playTime > maxPlayTime){
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
    
    public String convert(String s){
        return s.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
    }
}
