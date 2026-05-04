# [백준 - G4] 16202. MST게임

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- MST

## ⏲️**Time Complexity** 

$O(N)$

## :round_pushpin: **Logic**

1. x,y를 map을 통해서 연결해준다.
2. mst를 활용해서 최소거리 구해준다
   - 해당 지역에서 갈수 있는 지역 큐에 담고 큐에서는 거리에 짧은 순으로 정렬

```kotlin
		fun mst(N:Int):Int{
    val minPrices = IntArray(N+1){Int.MAX_VALUE}
    minPrices[0]=0
    val check = BooleanArray(N+1){true}
    val que = PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
    que.add(Pair(1,0))

    while(que.isNotEmpty()){
        val q = que.poll()
        if(!check[q.first]){
            continue
        }
        check[q.first] = false
        minPrices[q.first]= q.second
        val nodes =map[q.first]!!.connect
        for(node in nodes){
            val price = node.second
            val num = node.first
            if(check[num] && minPrices[num]>price && ban[price]){
                que.add(Pair(num,price))
            }
        }

    }
    var total = 0
    var minPrice = Int.MAX_VALUE
    for(i in 2..N){
        if(minPrices[i]==Int.MAX_VALUE){
            return 0
        }
        if(minPrice>minPrices[i]){
            minPrice= minPrices[i]
        }
        total +=  minPrices[i]
    }
    ban[minPrice]=false
    return total
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16202
