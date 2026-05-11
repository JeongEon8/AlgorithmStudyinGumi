# [프로그래머스 - Lv2] 42842. 카펫

## ⏰ **time**
10분

## :pushpin: **Algorithm**
완전탐색

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 갈색과 노란색을 더해서 임의의 높이로 나눈 값이 가로가 된다.
2. (높이 - 2) * (너비 - 2) 값이 노란색 개수가 된다면 정답이다.
```cpp
    for(int height = 3;; height++){
        if(sum % height == 0){
            int weight = sum / height;
            
            if((height - 2) * (weight - 2) == yellow){
                answer.push_back(weight);
                answer.push_back(height);
                break;
            }
        } 
    }
```

## :black_nib: **Review**
- 여러분 나가사키 가보신 적 있나요?
- 사라 우동이라는 음식이 있는데요, 정말 맛있어요. 꼭 먹어보세요!
<img width="400" height="300" alt="image" src="https://github.com/user-attachments/assets/a0de69e3-4e5c-4b22-9c25-4fe558497e7b" />


## 📡 Link
[프로그래머스 레벨2 카펫](https://school.programmers.co.kr/learn/courses/30/lessons/42842)
