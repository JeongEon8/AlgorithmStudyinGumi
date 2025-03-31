import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer>gPlays = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            int play = plays[i];
            String genre = genres[i];
            Integer tmp = gPlays.get(genre);
            if(tmp==null){
                gPlays.put(genre,play);
            }else{
                gPlays.put(genre,play+tmp);
            }
        }
        List<Genre>list = new ArrayList<>();
        for(Map.Entry<String,Integer>entry:gPlays.entrySet()){
            Genre genre = new Genre();
            genre.name=entry.getKey();
            genre.total=entry.getValue();
            list.add(genre);
            
        }
        Collections.sort(list);
        
        List<Integer>tmpAnswer = new ArrayList<>();
        
        for(Genre tmp : list){
            findTop2(tmp,genres,plays);
            tmpAnswer.add(tmp.first);
            if(tmp.second!=-1)tmpAnswer.add(tmp.second);
            System.out.println(tmp.name+" : "+tmp.total);
            System.out.println(tmp.name+" : "+tmp.first);
            System.out.println(tmp.name+" : "+tmp.second);
        }
        for(int tmp : tmpAnswer){
            System.out.println(tmp);
        }
        
        int[] answer = new int [tmpAnswer.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=tmpAnswer.get(i);
        }
        return answer;
    }
    static void findTop2(Genre tmp,String [] genres, int [] plays){
        int first=0;
        int second=0;
        int firstLoc=-1;
        int secondLoc=-1;
        
        
        for(int i=0;i<plays.length;i++){
            String genre = genres[i];
            if(genre.equals(tmp.name)){
                if(second<plays[i]){
                    second=plays[i];
                    secondLoc=i;
                }               
                if(first<plays[i]){
                    second=first;
                    secondLoc=firstLoc;
                    first=plays[i];
                    firstLoc=i;
                }
            }
        }
        
        tmp.first=firstLoc;
        tmp.second=secondLoc;
    }
}
class Genre implements Comparable<Genre>{
    String name;
    int first;
    int second;
    int total;
    @Override
    public int compareTo(Genre g){
        if(this.total>g.total)return -1;
        if(this.total==g.total)return 0;
        return 1;
    }
}
