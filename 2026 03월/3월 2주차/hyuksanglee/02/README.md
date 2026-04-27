# [백준 - 골드 4] 2056. 작업

## ⏰**time**

약 30분

## :pushpin: **Algorithm**
- dp


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**


1. 앞에서 부터 차근차근 값을 더해주는데 선행 작업들 중에서 최대시간과 더해준다.

```kotlin
for (l in 0 until len){
        val input = readLine().split(" ").map{it.toInt()}
        val price = input[0]
        val plen = input[1]
        var max = 0;
        for(pl in 0 until plen){
            val imPrice = list[input[2+pl]]
            if(max<imPrice){
                max = imPrice
            }
        }
        list[l+1] = price + max
        if(result<list[l+1]){
            result = list[l+1]
        }
    }
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/2056>
