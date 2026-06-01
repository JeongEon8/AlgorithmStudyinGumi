# [PGS - Lv2] 03_[3차] n진수 게임

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- 구현
- 문자열 처리

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 튜브가 t개의 숫자를 확보할 수 있을 때까지 전체 게임 문자열을 생성한다.
   ```java
        int targetLength = t * m;
        while (gameSequence.length() < targetLength) {
            String converted = Integer.toString(currentNumber, n).toUpperCase();
            gameSequence.append(converted);
            currentNumber++;
        }
   ```

2. 전체 문자열에서 튜브의 순서(p)에 해당하는 문자만 골라낸다. 인덱스는 0부터 시작하므로 튜브의 첫 번째 순서는 p - 1가 되고 다음 순서는 게임 참가 인원 m만큼 건너 뛰어서 계산해준다.
   ```java
        for (int i = 0; i < t; i++) {
            int tubeIndex = (p - 1) + (i * m);
            answer.append(gameSequence.charAt(tubeIndex));
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17687
