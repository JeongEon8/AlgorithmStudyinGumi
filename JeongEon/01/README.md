# [백준 - 실버 5] 1343. 폴리오미노
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현, 수학

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. X 카운트를 세고, 짝수이면 4로 먼저 나누고, 2로 나누어 AAAA와 BB를 result에 더한다.
2. 이때, 짝수로 나눠지지 않으면 -1로 출력한다.
```cpp
    for (int i = 0; i < input.length(); i++) {
        if (input[i] == 'X') {
            cnt++;
        }
        else {
            if (cnt != 0) {
                if (cnt % 2 == 0) {
                    for (int j = 0; j < cnt / 4; j++) {
                        result += "AAAA";
                    }
                    cnt = cnt % 4;
                    if (cnt % 2 == 0) {
                        for (int j = 0; j < cnt / 2; j++) {
                            result += "BB";
                        }
                    }                
                    cnt = 0;
                }
                else {
                    cout << "-1" << endl;
                    return 0;
                }
            }
            result += input[i];
        }
    }
```

## :black_nib: **Review**
- 후헤헤 이런 거 좋아!

## 📡 Link
https://www.acmicpc.net/problem/1343
