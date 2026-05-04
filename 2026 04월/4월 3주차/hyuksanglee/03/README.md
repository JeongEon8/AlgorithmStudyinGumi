# [백준 - G4] 20040. 사이클 게임

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 유니온 파인드

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 유니온을 이용해서 서로 연결해준다
  ```kotlin
	fun union(a: Int, b:Int):Boolean{
    val aParent = find(a)
    val bParent = find(b)
    if(aParent != bParent){
        parent[bParent] = aParent
        return true
    }
    return false
}
```
- 파인드로 서로 부모가 연결 되었는지 확인하고 연결 되었으면 0을 아닐경우 카운트를 셈
```kotlin
	fun find(target: Int):Int{
    if(parent[target]== target){
        return target
    }
    parent[target] = find(parent[target])
    return parent[target]
}
```
- 찾고자 하는 값 나오면 출력


```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20040
