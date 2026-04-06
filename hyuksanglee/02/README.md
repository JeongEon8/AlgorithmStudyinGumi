# [백준 - G3] 2110. 공유기 설치

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 이분탐색

## ⏲️**Time Complexity** 

$O(M*N)$

## :round_pushpin: **Logic**

1. 1 ~ 최댓값을 이분탐색해서 구하기
   - 최댓값은 먼거리랑 가까운 거리를 뺀 거리

```kotlin
		while(minValue<=maxValue){
        var midValue = (maxValue+minValue)/2
        var lineValue = places[0]+midValue
        var count =1
        for(i in 1..N-1){
            if(lineValue<=places[i]){
                count++
                lineValue = places[i]+midValue
            }
        }
        if(count>=C){
            result = midValue
            minValue = midValue +1
        }else{
            maxValue = midValue-1
        }
    }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2110
