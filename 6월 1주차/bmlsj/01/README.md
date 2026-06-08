# [PGS - Lv3] 01\_베스트앨범

## ⏰**time**

30분

## :pushpin: **Algorithm**

- 해시

## ⏲️**Time Complexity**

$O(n \log n)$

## :round_pushpin: **Logic**

1. 조건대로 정렬 수행

- 단 처음 조건 수행은 map에 장르별 재생 수를 넣어 정렬한다.

  ```java
  total = new HashMap<>();
  for(int i = 0; i < genres.length; i++) {
      total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
  }
  ```

```java
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
```

1. 장르별로 2개씩 모아야해서 2개이하일 때만 answer에 추가한다.

```java
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
```

## :black_nib: **Review**

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java](https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java)
