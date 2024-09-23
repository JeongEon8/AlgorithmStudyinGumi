# [백준 - G5] 5430. AC

## ⏰  **time**
20분

## :pushpin: **Algorithm**
문자열, 구현


## :round_pushpin: **Logic**
1. 배열에 수를 담아 head와 tail을 조절해서 남은 숫자 구하기
```
  for (auto i: todo) {
            if (head < tail && i == 'D') {
                err = true;
                break;
            }
            if (i == 'R')status = !status;
            if (i == 'D') {
                if (status) {
                    tail++;
                } else {
                    head--;
                }
            }
        }
```

## :black_nib: **Review**
- 👍



## 📡 Link
https://www.acmicpc.net/problem/5430
