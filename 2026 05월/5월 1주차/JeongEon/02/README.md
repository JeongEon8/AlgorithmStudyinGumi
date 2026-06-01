# [프로그래머스 - Lv2] 12941. 최솟값 만들기

## ⏰ **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 하나는 오름차순, 하나는 내림차순으로 정렬한 후 곱한 값들을 출력한다.
```cpp
    sort(A.begin(), A.end(), greater());
    sort(B.begin(), B.end());

    for(int i = 0; i < A.size(); i++){
        answer += A[i] * B[i];
    }
```

## :black_nib: **Review**
- 여러분 나가사키 가보신 적 있나요?
- 사라 우동이라는 음식이 있는데요, 정말 맛있어요. 꼭 먹어보세요!
<img width="400" height="300" alt="image" src="https://github.com/user-attachments/assets/a0de69e3-4e5c-4b22-9c25-4fe558497e7b" />


## 📡 Link
[프로그래머스 레벨2 최솟값 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12941)
