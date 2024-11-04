# [백준 - 골드 3] 2252. 줄 세우기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
위상정렬

## ⏲️**Time Complexity**
$O(N+M)$

## :round_pushpin: **Logic**
1. 2차원 배열을 사용하여 해당 학생에 인덱스 해당 학생보다 큰 학생을 담는 배열 ArrayList<Integer>[]arr을 생성한다.
2. 해당 학생보다 작은 학생이 몇명인지 받는 배열 indegree 생성

3. 학생의 정보를 받을때 a의 학생 칸에 b학생을 추가 해주고 B학생 indegree배열에 1증가 시켜준다.

4.  indegree을 for문을 돌면서 값이 0인 값을 찾아서 que에 넣어준다.

5.  que에서 하나씩 뽑아서 출력하고 해당 숫자가 arr안에 있는 학생들을 하나씩 꺼내서 indegree을값을 비교하고 0이 아니면 1감소시키고 0이면 출력한다.
   ```java
	while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current);
            System.out.print(" ");

            for (int next : arr[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next); // 진입 차수가 0이 된 문제를 큐에 추가
                }
            }
        }
   ```

## :black_nib: **Review**
- 위상정렬 어려워요

## 📡 Link
https://www.acmicpc.net/problem/2252
