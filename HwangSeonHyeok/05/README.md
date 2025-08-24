# [백준 - G4] 17215. 볼링 점수 계산

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
문자열을 각 투구의 점수로 우선 바꾼다. 규칙대로 각 프레임별 점수를 개산하고 스트라이크나 스페어인 경우 다음 투구 점수를 확인하여 보너스 점수를 계산한다.
```java
List<Integer> scores = new ArrayList<>();
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    if (c == 'S') {
        scores.add(10);
    } else if (c == 'P') {
        scores.add(10 - scores.get(scores.size() - 1));
    } else if (c == '-') {
        scores.add(0);
    } else {
        scores.add(c - '0');
    }
}
int ans = 0;
int frame = 1;
int scoreIndex = 0;

while (frame <= 10) {
    int first = scores.get(scoreIndex);
    if (first == 10) {
        ans += 10 + scores.get(scoreIndex + 1) + scores.get(scoreIndex + 2);
        scoreIndex++;
    } else {
        int second = scores.get(scoreIndex + 1);
        if (first + second == 10) {
            ans += 10 + scores.get(scoreIndex + 2);
        } else {
            ans += first + second;
        }
        scoreIndex += 2;
    }

    if (frame < 10) {
        frame++;
    } else {
        break;
    }
}
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/17215