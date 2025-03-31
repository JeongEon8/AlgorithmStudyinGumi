# [프로그래머스 - LV.3] 베스트 엘범
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 
```java
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
```

## :black_nib: **Review**
- 

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java
