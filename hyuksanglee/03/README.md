# [백준 - 실버 3] 15651. N과 M (3) 

## ⏰**time**

약 30분

## :pushpin: **Algorithm**

dfs

## ⏲️**Time Complexity**

$O(N^M)$

## :round_pushpin: **Logic**


1. 1부터 n 만큼 반복해서 dfs를 넣어주는데 이거를 m 번까지 반복하고 출력해준다.

``` kotlin
fun dfs(n: Int, m: Int, de: Int, result: StringBuilder){
    if(de>=m){
        output.append(result.toString().trim()).append("\n")
        return
    }
    for(i in 1..n){
        val len = result.length
        result.append(i).append(" ")
        dfs(n, m,de+1,result)
        result.setLength(len)
    }
}
```

## :black_nib: **Review**
출력하는데 오랜시간이 걸려 StringBuilder() 사용

## 📡 Link

<https://www.acmicpc.net/problem/15651>
