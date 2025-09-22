# [백준 - S5] 1417. 국회의원 선거

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 구현
- 자료 구조
- 그리디 알고리즘
- 시뮬레이션
- 우선순위 큐

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
큰 수가 우선순위가 되도록 우선순위 큐에 다솜이를 제외한 후보들의 득표수를 넣고 가장 큰 수의 득표수를 1개씩 다솜이의 득표로 매수하고 다시 우선순위 큐에 넣고를 다솜이의 득표수가 더 많아질때까지 반복한다. 
```java
if (n > 1) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i = 0; i < n - 1; i++) {
        int num = -Integer.parseInt(in.readLine());
        pq.add(num);
    }

    while (true) {
        int maxVote = -pq.poll();
        if (dasom > maxVote)
            break;
        ans++;
        dasom++;
        pq.add(1 - maxVote);

    }
}
```

## :black_nib: **Review**  
수학적 규칙을 찾고 싶었는데 결국 그냥 시뮬레이션으로 돌렸다.
## 📡**Link**
https://www.acmicpc.net/problem/1417