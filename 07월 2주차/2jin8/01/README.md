# [백준- G4] 1963. 소수 경로
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(T × (V + E))$

## :round_pushpin: **Logic**
- 1000 ~ 9999 숫자들의 소수 여부 판별해서 배열에 저장하기
- 각 자리마다 숫자 변경 -> 해당 숫자가 소수 & 방문하지 않은 수면 큐에 넣기
```java
static int bfs(int numberA, int numberB) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(numberA);
    dist[numberA] = 0;

    while (!queue.isEmpty()) {
        int now = queue.poll();
        if (now == numberB)
            break;

        // 첫 번째 자리
        int[] numbers = getNumbers(now);
        int first = numbers[0];
        for (int i = 1; i <= 9; i++) {
            if (first == i) continue;

            numbers[0] = i;
            int number = getNumber(numbers);
            if (dist[number] == -1 && prime[number]) {
                queue.offer(number);
                dist[number] = dist[now] + 1;
            }
        }
        numbers[0] = first;

        // 두 번째 자리
        for (int i = 1; i < 4; i++) {
            int tmp = numbers[i];
            for (int j = 0; j <= 9; j++) {
                if (tmp == j) continue;

                numbers[i] = j;
                int number = getNumber(numbers);
                if (dist[number] == -1 && prime[number]) {
                    queue.offer(number);
                    dist[number] = dist[now] + 1;
                }
            }
            numbers[i] = tmp;
        }
    }
    return dist[numberB];
}
```

## :black_nib: **Review**
복잡하게 생각하지 말자

## 📡**Link**
- https://www.acmicpc.net/problem/1963
