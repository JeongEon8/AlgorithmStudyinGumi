# [백준 - S1] 1446. 지름길

## ⏰ **time**

35분

## :pushpin: **Algorithm**

- 우선순위 큐
- dp

## ⏲️**Time Complexity**

$O((N-1) \times (N-1)!)$

## :round_pushpin: **Logic**

- 1에서 시작을 하여 중간에 지름길이 통해 D까지를 가는 최소시간을 구하는 문제
- N을 시작과 도착점을 작은순으로 정렬하고 dp배열에 최소시간 업데이트식
	- N이 12개라서 정렬을 한다고 해도 12log12라서 충분
 	- dp배열에 도착시간 이후에 값을 초기화해줘야하는데 이것도 12 x 100000이므로 충분
1. 우선순위 큐를 생성하고 하나씩 담아주는데 D보다 작은 값만 담아준다. ( 뒤로가는 경우는 없다고해서 생략함)
	- 정렬은 시작점, 도착점, 시간을 작은순으로 정렬
2. 큐에서 값을 하나씩 꺼내서 도착점과 값을 비교후 작을경우 그뒤에 값들도 비교해서 변경해준다.

```kotlin
	hile(que.isNotEmpty()){
        val data = que.poll()
        val start = data.start
        val end = data.end
        val price = data.price

        var total = dp[start]
        total += price
        if(dp[end]>total){
            dp[end]= total
            for(i in end+1..D){
                if(dp[i]>dp[i-1]+1){
                    dp[i]=dp[i-1]+1
                }
            }
        }
    }
```


## :black_nib: **Review**
- 지금 코틀린에 적응해 버렸는데 다른 코테에서 코틀린이 안 된다고 하면 ㄷㄷ

## 📡**Link**

https://www.acmicpc.net/problem/1446
