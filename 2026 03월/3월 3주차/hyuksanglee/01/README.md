# [백준 - S4] 1916. 최소비용 구하기

## ⏰ **time**

50분

## ⏲️**Time Complexity**

$O(M \log M)$

## :round_pushpin: **Logic**

1. 인접 리스트로 시작점 리스트에 도착점과 비용을 담아준다

```kotlin
 for(m in 1..M){
        val input = readLine().split(" ").map{it.toInt()}
        val start = input[0]
        val end = input[1]
        val price = input[2]
        list[start].add(Node(end,price.toLong()))
    }
```

2. 다익스트라 배열 생성 ( 모든 값을 최대값으로 초기화)
3. 찾고자 하는 시작점만 0으로 수정
4. 우선순위큐를 생성한다( 비용 기준으로 정렬)
5. 초기에는 시작점과 비용0을 넣어준다.
6. 인점 리스트에서 하나씩 꺼내서 다익스트라 비용과 비교후 값이 작으면 변경 해주고 큐에 넣어준다.
   - 값을 비교할때 현제까지의 비용과 도착지까지 비용을 합친다음 비교
```kotlin
  while(que.isNotEmpty()){
        val node = que.poll()
        val priceC = node.price
        if(dist[node.target] < priceC){
            continue
        }
        for(l in list[node.target]){
           val priceN = l.price+priceC
            if(dist[l.target]>priceN){
                dist[l.target] = priceN
                que.add(Node(l.target, priceN))
            }
        }

    }
```


## :black_nib: Review
- 코틀린으로 푸니깐 쉬운거 같으면서도 어렵네요
- 처음에는 인점리스트 말고 행렬로 풀었다가 시간초과 떴어요(앞으로 인접리스트로 풀어야할거 같아요)

## 📡**Link**

- [https://www.acmicpc.net/problem/1916](https://www.acmicpc.net/problem/1916)
