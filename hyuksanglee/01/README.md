# [프로그래머스 - Lv2] 요격 시스템

## ⏰  **time**
120분

## :pushpin: **Algorithm**
- 정렬

## ⏲️**Time Complexity**
$O(len)$

## :round_pushpin: **Logic**
1. e가 작은거 순, s가 작은 순으로 정렬
```java
       static class Info implements Comparable<Info>{
        int s;
        int e;
        
        Info(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Info o){
            if (this.e != o.e) {
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
```
2. 하나씩 탐색
    1. last를 -1로 초기화
    2. last랑 start를 비교해서 start가 크면 last를 end로 갱신하고 미사일 개수 더해준다.
```java
int len = targets.length;
        Info[] infos = new Info[len];
        
        // 입력을 Info 배열로 변환
        for (int i = 0; i < len; i++) {
            infos[i] = new Info(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(infos);
        
        int answer = 0;
        
        int last = -1;
        
        for (int i = 0; i < len; i++) {
            int start = infos[i].s;
            int end = infos[i].e;
            
            // 현재 구간의 시작이 last 이상이면, 기존 미사일로는 커버 불가 → 새로 쏨
            if (start >= last) {
                answer++;
                last = end;  // 이 구간의 끝점에 미사일을 쏜다고 생각
            }
            // start < last 면, 이미 last 위치 미사일에 이 구간이 포함되므로 아무 것도 안 함
        }
```



## :black_nib: **Review**
- 처음에 정렬을 s가 작은거 순, e가 작은 순으로 정렬 하니깐 틀렸어요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/181188
