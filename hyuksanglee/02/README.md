# [백준 - S1] 14888. 연산자 끼워넣기

## ⏰ **time**

45분

## :pushpin: **Algorithm**

- dfs

## ⏲️**Time Complexity**

$O((N-1) \times (N-1)!)$

## :round_pushpin: **Logic**

- 수열이 에서 연산들을 조합하여 최댓값과 최솟값을 구하는 문제
	- DFS를 사용하여 연산자를 조합하여 차례대로 계산해서 list에 저장
1. 수열을 배열에 담고 연산자도 배열에 담아준다. 

```kotlin
		nums = readLine().split(" ").map{it.toInt()}
    type = mutableListOf()
    result = mutableListOf()
    isType= BooleanArray(N-1)

    val input = readLine().split(" ").map{it.toInt()}
    for(i in 0..3){
        val count = input[i]
        for(c in 0..count-1){
            type.add(i)
        }
    }
```

2. A1를 먼저 total에 넣어서 초기화 시켜준다.
   - 모든 계산은 A1은 똑같아서
3. DFS로 연산자를 하나 골라서 An을 계산
4. 4번을 반복해서 An-1까지 계산하고 list에 담는다
   - 연산자를 고를때는 조합방식으로 사용해준다.
```kotlin
fun dfs(index: Int, total:Int){
    if(index == N-1){
        result.add(total)
        return
    }
    for(i in 0..type.size-1){
        if(!isType[i]){
            isType[i] = true
            dfs(index+1,calculator(total,nums[index+1],type[i]))
            isType[i] = false
        }
    }


}
```
- 값을 연산자에 맞게 계산 해주는 함수
```kotlin
fun calculator(total: Int, num:Int, type:Int):Int{
    when(type){
        0 -> return total+num
        1 -> return total-num
        2 -> return total*num
        else -> return total/num
    }
}
```
5. 결과 값 리스트를 정렬해서 최댓값과 최솟값 출력

```kotlin
result.sort()
println(result.last())
println(result[0])
```


## :black_nib: **Review**
- 코틀린에서는 lateinit 사용해서 전역변수로 사용했는데 기본 타입(Int, Long, Float, Boolean 등)은 사용이 불가능하다는거 알았어요

## 📡**Link**

https://www.acmicpc.net/problem/14888
