# [PGS - LV2] 138476. 귤 고르기

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디
- 해시맵
- 정렬

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
각 크기별로 몇개가 있는지 카운팅한다.  
이 갯수들을 내림차순으로 정렬하고 가장 많은거부터 박스에 담는다.  
이 때 박스에 담긴게 원하는 갯수 이상이되면 그 종류까지만 담으면 되므로 그 종류수가 답이다.
```java
Map<Integer, Integer> map = new HashMap<>();
for(int size:tangerine){
    map.put(size, map.getOrDefault(size,0)+1);
}
List<Integer> counts = new ArrayList(map.values());
Collections.sort(counts,Collections.reverseOrder());
int current = 0;
for(int count: counts){
    current+=count;
    answer++;
    if(current>=k)break;
}
```
## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/138476