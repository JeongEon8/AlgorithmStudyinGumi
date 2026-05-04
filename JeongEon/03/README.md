# [프로그래머스 - Lv2] 42577.전화번호 목록 

## ⏰ **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 전화번호 sort()를 이용하여 정렬 후 이후 전화번호에 이전 전화번호가 포함되어있는지 확인한다
```cpp
    sort(phone_book.begin(), phone_book.end());
    
    for(int i = 0; i < phone_book.size() - 1; i++){
        if(phone_book[i + 1].find(phone_book[i]) == 0){
            return false;
        }
    }
```

## :black_nib: **Review**
- 요새 하늘 너무 예쁘지 않아요?
- 산에 녹음이 예쁘게졌어요. 딱 이번달까지가 등산하기 좋은 달입니다!
- 용마산 가봐요~

## 📡 Link
[프로그래머스 레벨2 전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577)
