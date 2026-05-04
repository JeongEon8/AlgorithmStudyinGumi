# [프로그래머스 - Lv2] 42586. 기능개발

## ⏰ **time**
15분

## :pushpin: **Algorithm**
수학

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 남은 진도 / 개발 속도 + 1로 얼마나 걸리는 지 벡터에 저장한다.
2. 얼마나 걸리는지 날짜가 기존 flag보다 커질때까지 cnt하고, 커지면 cnt를 출력한다.
```cpp
    for(int i = 1; i < days.size(); i++){
        if(flag < days[i]){
            flag = days[i];
            answer.push_back(cnt);
            cnt = 1;
            continue;
        }
        cnt++;
    }
```

## :black_nib: **Review**
- 요새 하늘 너무 예쁘지 않아요?
- 산에 녹음이 예쁘게졌어요. 딱 이번달까지가 등산하기 좋은 달입니다!
- 용마산 가봐요~

## 📡 Link
[프로그래머스 레벨2 기능개](https://school.programmers.co.kr/learn/courses/30/lessons/42586)
