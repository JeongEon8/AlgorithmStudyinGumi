# [백준 - G3] 8979. 올림픽

## ⏰**time**

40분

## :pushpin: **Algorithm**

우선순위 큐

## :round_pushpin: **Logic**

매달의 수에 따라 순위를 매기고 특정 국가의 순위를 알려주는 문제이다
- n의 개수가 1000개 라서 2번 돌아도 문제가 없을거라고 생각해서 for문으로 우선순위 큐에 넣었습니다
- 큐에 넣을떄 compareByDescending 을 사용해서 우선순위를 정해주었음
- 골드가 많은 순, 실버, 브론즈, 순으로 많으면 우선순위를 주었고 세가지가 다 같을 경우 알고자 하는 국가를 우선순위를 주었음
- 큐에 다 넣은 다음 하나씩 뽑아서 국가번호가 k( 알고자 하는 국가) 일경우 index 값을 출력

```kotlin
val que = PriorityQueue<Score>(
       compareByDescending<Score>{it.gold}
           .thenByDescending{it.silver}
           .thenByDescending{it.bronze}
           .thenBy{it.name != K}
   )

    for( n in 1.. N){
        val(name, g, s, b ) = readLine().split(" ").map{it.toInt()}
        que.add(Score(name, g, s, b))

    }
    var result = 0
    while(que.isNotEmpty()){
        result++
        val score = que.poll()
        if(score.name == K) break
    }

    println(result)
```

## 📡 Link

<https://www.acmicpc.net/problem/8979>
