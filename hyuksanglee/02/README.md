# [백준 - S2] 1927. 최소 힙

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 최소 힙

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

- 최소힙(PriorityQueue)를 사용해서 풀면 간단하게 해결

```java
	for(n in 1..N){
        val commend = readLine().toInt()
        if(commend==0 ){
            if(que.size>0){
                println(que.poll())
            }else{
                println(0)
            }
        }else{
            que.add(commend)
        }

    }
```

## :black_nib: **Review**
## 📡**Link**

https://www.acmicpc.net/problem/1927
