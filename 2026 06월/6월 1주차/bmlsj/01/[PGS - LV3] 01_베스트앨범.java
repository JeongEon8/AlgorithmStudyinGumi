import java.util.*;
class Solution {
    
    static Map<String, Integer> total;
    static class Song implements Comparable<Song> {
        String genre;
        int playCnt;
        int idx;
        
        Song(int idx, String genre, int playCnt) {
            this.genre = genre;
            this.idx = idx;
            this.playCnt = playCnt;
        }
        
        @Override 
        public int compareTo(Song o) {
            
            int thisGenre = total.get(this.genre);
            int oGenre = total.get(o.genre);
            
            if (thisGenre != oGenre) {
                return oGenre - thisGenre;  
            }
            if (o.playCnt != this.playCnt) {
                return o.playCnt - this.playCnt;
            } 
            return this.idx - o.idx; 
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        
        // 많이 재생된 장르
        // 장르 내 많이 재생된 노래
        // 고유 번호 낮은 순
        
        total = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        PriorityQueue<Song> pq = new PriorityQueue<>();
        
        for(int i = 0; i < genres.length; i++) {
            pq.add(new Song(i, genres[i], plays[i]));
        }
        
        HashMap<String, Integer> best = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            Song s = pq.poll();
            int cnt = best.getOrDefault(s.genre, 0);
            
            if (cnt < 2) {
                answer.add(s.idx);
                best.put(s.genre, cnt + 1);
            }
        }
        
        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
        
    }
}