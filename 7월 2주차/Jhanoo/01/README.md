# [PGS - Lv2] 01_쿼드압축 후 개수 세기

## ⏰**time**

23분

## :pushpin: **Algorithm**

* 분할 정복
* 재귀
* 쿼드 트리
* 2차원 배열

## ⏲️**Time Complexity**

$O(N^2 \log N)$
`N`은 배열 한 변의 길이이다.

각 재귀 단계에서 현재 영역의 모든 칸을 확인하고, 값이 섞여 있다면 영역을 4등분한다.
한 단계에서 검사하는 전체 칸 수는 최대 $N^2$이고, 영역의 크기는 매 단계 절반으로 줄어들기 때문에 재귀 깊이는 $\log N$이다.

따라서 전체 시간 복잡도는 $O(N^2 \log N)$으로 볼 수 있다.

## :round_pushpin: **Logic**

1. 배열 전체를 하나의 정사각형 영역으로 보고 재귀 탐색을 시작한다.

   재귀 함수에는 현재 영역의 시작 행, 시작 열, 한 변의 길이를 전달한다.

   ```java
   quad(0, 0, arr.length);
   ```

2. 현재 영역의 첫 번째 값을 기준값으로 저장한다.

   ```java
   int value = arr[row][col];
   ```

3. 현재 영역의 모든 칸을 순회하면서 기준값과 다른 값이 있는지 확인한다.

   ```java
   boolean same = true;

   for (int i = row; i < row + size; i++) {
       for (int j = col; j < col + size; j++) {
           if (arr[i][j] != value) {
               same = false;
               break;
           }
       }

       if (!same) break;
   }
   ```

4. 현재 영역이 모두 같은 값으로 이루어져 있다면 하나의 영역으로 압축할 수 있다.

   값이 `0`이면 `answer[0]`, 값이 `1`이면 `answer[1]`을 1 증가시키고 재귀를 종료한다.

   ```java
   if (same) {
       answer[value]++;
       return;
   }
   ```

5. 현재 영역에 서로 다른 값이 섞여 있다면 한 변의 길이를 절반으로 나눈다.

   ```java
   int half = size / 2;
   ```

6. 현재 영역을 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래의 네 영역으로 나누어 재귀 호출한다.

   ```java
   quad(row, col, half);
   quad(row, col + half, half);
   quad(row + half, col, half);
   quad(row + half, col + half, half);
   ```

7. 각 영역에서도 동일하게 `모두 같은 값인지 확인 → 같으면 압축 → 다르면 4등분` 과정을 반복한다.

8. 모든 재귀가 끝나면 `answer[0]`에는 압축 후 남은 `0`의 개수, `answer[1]`에는 압축 후 남은 `1`의 개수가 저장된다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

* 2차원 배열 전체가 같은 값인지 확인하고, 값이 섞여 있으면 네 구역으로 나누는 전형적인 분할 정복 문제였다.
* 재귀 함수의 상태를 `시작 행`, `시작 열`, `영역 크기`로 정의하니 네 영역을 나누는 기준이 명확해졌다.
* 크기가 1인 영역은 자동으로 같은 값으로 판정되므로 별도의 종료 조건 없이도 재귀가 자연스럽게 끝났다.
* 압축 가능한 영역은 칸 수만큼 세는 것이 아니라 하나의 압축 영역으로 보기 때문에 `answer[value]`를 1만 증가시켜야 한다.
* 현재 구현은 각 재귀 영역을 직접 순회해 같은 값인지 확인하므로 이해하기 쉽고 문제 제한에서도 충분히 효율적이다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/68936
