# [백준 - S4] 1302. 베스트셀러

## ⏰  **time**
20분

## :pushpin: **Algorithm**
자료구조, 맵

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. Map에 나타난 책 이름 담기, 이미 존재하면 map에서 꺼낸 값에 1 더한 값으로 put하고 없으면 0에 1 더한 값으로 put
```java
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            map.put(str, map.getOrDefault(str,0)+1);
        }
```
2. 우선순위큐에 이름과 나타난 횟수를 key와 value로 담기
```java
        PriorityQueue<Book> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Book(entry.getKey(), entry.getValue()));
        }
        
```
3. Book 클래스 생성, Comparable을 implements하여 숫자가 클수록 앞이고, 이름을 사전순으로 앞으로 나타나게 정렬함
```java
    static class Book implements Comparable<Book>{
        String name;
        int cnt;

        public Book(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Book o) {
            if(this.cnt < o.cnt) return 1;
            else if(this.cnt == o.cnt) {
                return this.name.compareTo(o.name);
            }
            else return -1;
        }
        
    }
```
4. 정렬순서대로 가장 앞에 나온 값을 꺼내서 name 출력하기
```java
 System.out.println(pq.poll().name);
```


## :black_nib: **Review**
- 해시맵 최고!..

## 📡 Link
https://www.acmicpc.net/problem/1302
