# [프로그래머스 - Lv3] 42884. 단속카메라

## ⏰ **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 이동경로를 sort()를 통해 정렬한다.
2. 경로 하나씩 보면서, 현재 값보다 작아지면 카메라를 설치한다.
```cpp
    for(auto route : routes){
        if(temp < route[0]){
            answer++;
            temp = route[1];
        }
        
        if(temp >= route[1]){
            temp = route[1];
        }
    }
```

## :black_nib: **Review**
- 요새 하늘 너무 예쁘지 않아요?
- 산에 녹음이 예쁘게졌어요. 딱 이번달까지가 등산하기 좋은 달입니다!
- 용마산 가봐요~

## 📡 Link
[프로그래머스 레벨3 단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884)
